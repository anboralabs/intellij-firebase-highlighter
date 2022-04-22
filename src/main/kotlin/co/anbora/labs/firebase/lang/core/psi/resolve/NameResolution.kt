package co.anbora.labs.firebase.lang.core.psi.resolve

import co.anbora.labs.firebase.lang.core.psi.*
import co.anbora.labs.firebase.lang.core.psi.ext.ancestorOrSelf
import co.anbora.labs.firebase.lang.core.psi.ext.isMslAvailable
import co.anbora.labs.firebase.lang.core.psi.ext.wrapWithList
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.Namespace
import co.anbora.labs.firebase.lang.core.psi.resolve.ref.Visibility
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.PsiUtilCore

enum class MslScope {
    NONE, EXPR, LET;
}

val FireRuleElement.mslScope: MslScope
    get() {
        if (!this.isMslAvailable()) return MslScope.NONE
        val letStatement = this.ancestorOrSelf<FireRulesLetStatement>()
        return when {
            letStatement == null -> MslScope.EXPR
            else -> MslScope.LET
        }
    }

data class ItemVis(
    val namespaces: Set<Namespace> = emptySet(),
    val visibilities: Set<Visibility> = emptySet(),
    val msl: MslScope = MslScope.NONE
) {
    val isMsl get() = msl != MslScope.NONE

    fun replace(
        ns: Set<Namespace> = this.namespaces,
        vs: Set<Visibility> = this.visibilities,
        msl: MslScope = this.msl
    ): ItemVis {
        return ItemVis(ns, vs, msl)
    }
}

fun resolveItem(element: FireRuleReferenceElement, namespace: Namespace): List<FireRuleNamedElement> {
    val itemVis = ItemVis(setOf(namespace), msl = element.mslScope)
    var resolved: FireRuleNamedElement? = null
    processItems(element, itemVis) {
        if (it.name == element.referenceName) {
            resolved = it.element
            return@processItems true
        }
        return@processItems false
    }
    return resolved.wrapWithList()
}

fun processItems(
    element: FireRuleElement,
    itemVis: ItemVis,
    processor: MatchingProcessor,
): Boolean {
    return walkUpThroughScopes(
        element,
        stopAfter = { it is FireRulesFunctionDef || it is FireRulesMatchDef }
    ) { cameFrom, scope ->
        processLexicalDeclarations(
            scope, cameFrom, itemVis, processor
        )
    }
}

fun walkUpThroughScopes(
    start: FireRuleElement,
    stopAfter: (FireRuleElement) -> Boolean,
    handleScope: (cameFrom: FireRuleElement, scope: FireRuleElement) -> Boolean,
): Boolean {

    var cameFrom = start
    var scope = start.parent as FireRuleElement?
    while (scope != null) {
        if (handleScope(cameFrom, scope)) return true
        if (stopAfter(scope)) break

        cameFrom = scope
        scope = scope.parent as? FireRuleElement
    }

    return false
}

fun processLexicalDeclarations(
    scope: FireRuleElement,
    cameFrom: FireRuleElement,
    itemVis: ItemVis,
    processor: MatchingProcessor,
): Boolean {
    check(cameFrom.parent == scope)

    return when (itemVis.namespaces.single()) {
        Namespace.DOT_ACCESSED_FIELD -> false
        Namespace.STRUCT_FIELD -> false
        Namespace.SCHEMA_FIELD -> false
        Namespace.NAME -> false
        Namespace.TYPE -> false
        Namespace.SPEC_ITEM -> false
        Namespace.SCHEMA -> false
        Namespace.MODULE -> false
    }
}

