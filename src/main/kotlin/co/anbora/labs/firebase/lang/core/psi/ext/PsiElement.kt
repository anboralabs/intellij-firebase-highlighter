package co.anbora.labs.firebase.lang.core.psi.ext

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.PsiUtilCore

fun <T> T?.wrapWithList(): List<T> = this?.let { listOf(it) }.orEmpty()

fun PsiElement.hasChild(tokenType: IElementType): Boolean = childrenByType(tokenType).toList().isNotEmpty()

val PsiElement.elementType: IElementType
    get() = PsiUtilCore.getElementType(this)

val PsiElement.childrenWithLeaves: Sequence<PsiElement>
    get() = generateSequence(this.firstChild) { it.nextSibling }

fun PsiElement.childrenByType(type: IElementType): Sequence<PsiElement> =
    childrenWithLeaves.filter { it.elementType == type }

fun PsiElement.findLastChildByType(type: IElementType): PsiElement? =
    childrenByType(type).lastOrNull()

inline fun <reified T : PsiElement> PsiElement.ancestorOrSelf(): T? =
    PsiTreeUtil.getParentOfType(this, T::class.java, false)

inline fun <reified T : PsiElement> PsiElement.hasAncestorOrSelf(): Boolean =
    ancestorOrSelf<T>() != null

inline fun <reified T : PsiElement> PsiElement.ancestorStrict(): T? =
    PsiTreeUtil.getParentOfType(this, T::class.java, true)

inline fun <reified T : PsiElement> PsiElement.descendantOfTypeStrict(): T? =
    PsiTreeUtil.findChildOfType(this, T::class.java, true)
