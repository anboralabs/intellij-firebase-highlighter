package co.anbora.labs.firebase.lang.core.psi.resolve.ref

import co.anbora.labs.firebase.lang.core.psi.FireRuleNamedElement
import co.anbora.labs.firebase.lang.core.psi.resolve.FireRuleReferenceElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.ResolveResult
import com.intellij.psi.impl.source.resolve.ResolveCache

abstract class FireRuleReferenceCached<T : FireRuleReferenceElement>(element: T) : FireRuleReferenceBase<T>(element) {
    abstract fun resolveInner(): List<FireRuleNamedElement>

    final override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> =
        cachedMultiResolve().toTypedArray()

    final override fun multiResolve(): List<FireRuleNamedElement> =
        cachedMultiResolve().mapNotNull { it.element as? FireRuleNamedElement }

    private fun cachedMultiResolve(): List<PsiElementResolveResult> {
        return ResolveCache
            .getInstance(element.project)
            .resolveWithCaching(this, Resolver, true, false)
            .orEmpty()
    }

    private object Resolver :
        ResolveCache.AbstractResolver<FireRuleReferenceCached<*>, List<PsiElementResolveResult>> {
        override fun resolve(
            ref: FireRuleReferenceCached<*>,
            incompleteCode: Boolean
        ): List<PsiElementResolveResult> {
            return ref.resolveInner().map { PsiElementResolveResult(it) }
        }
    }
}
