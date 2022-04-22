package co.anbora.labs.firebase.lang.core.psi.resolve.ref

import co.anbora.labs.firebase.lang.core.psi.FireRuleNamedElement
import co.anbora.labs.firebase.lang.core.psi.resolve.FireRuleReferenceElement
import co.anbora.labs.firebase.lang.core.util.doRenameIdentifier
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

abstract class FireRuleReferenceBase<T : FireRuleReferenceElement>(element: T) : PsiPolyVariantReferenceBase<T>(element),
                                                                     FireRuleReference {

    override fun resolve(): FireRuleNamedElement? = super.resolve() as? FireRuleNamedElement

    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> =
        multiResolve().map { PsiElementResolveResult(it) }.toTypedArray()

    override fun equals(other: Any?): Boolean =
        other is FireRuleReferenceBase<*> && element === other.element

    override fun hashCode(): Int = element.hashCode()

    override fun getRangeInElement(): TextRange {
        return super.getRangeInElement()
    }

    final override fun calculateDefaultRangeInElement(): TextRange {
        val anchor = element.referenceNameElement ?: return TextRange.EMPTY_RANGE
        return TextRange.from(
            anchor.startOffsetInParent,
            anchor.textLength
        )
    }

    override fun handleElementRename(newName: String): PsiElement {
        val refNameElement = element.referenceNameElement
        if (refNameElement != null) {
            doRenameIdentifier(refNameElement, newName)
        }
        return element
    }
}
