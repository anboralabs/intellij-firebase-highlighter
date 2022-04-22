package co.anbora.labs.firebase.lang.core.psi.resolve

import co.anbora.labs.firebase.lang.core.psi.FireRuleNamedElement

//sealed class Resolution

data class SimpleScopeEntry(
    val name: String,
    val element: FireRuleNamedElement
)

fun interface MatchingProcessor {
    fun match(entry: SimpleScopeEntry): Boolean

    fun match(name: String, elem: FireRuleNamedElement): Boolean {
        val entry = SimpleScopeEntry(name, elem)
        return match(entry)
    }

    fun match(element: FireRuleNamedElement): Boolean {
        val name = element.name ?: return false
        return match(name, element)
    }

    fun matchAll(vararg collections: Collection<FireRuleNamedElement>): Boolean =
        listOf(*collections).flatten().any { match(it) }
}
