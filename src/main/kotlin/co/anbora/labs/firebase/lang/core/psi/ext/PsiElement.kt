package co.anbora.labs.firebase.lang.core.psi.ext

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiUtilCore

val PsiElement.elementType: IElementType
    get() = PsiUtilCore.getElementType(this)

val PsiElement.childrenWithLeaves: Sequence<PsiElement>
    get() = generateSequence(this.firstChild) { it.nextSibling }

fun PsiElement.childrenByType(type: IElementType): Sequence<PsiElement> =
    childrenWithLeaves.filter { it.elementType == type }

fun PsiElement.findLastChildByType(type: IElementType): PsiElement? =
    childrenByType(type).lastOrNull()