package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.lang.core.psi.FireRulesCodeBlock
import co.anbora.labs.firebase.lang.core.psi.FireRulesLetStatement


//val MvCodeBlock.returningExpr: MvExpr? get() = this.expr

//val MvCodeBlock.rightBrace: PsiElement? get() = this.findLastChildByType(R_BRACE)

val FireRulesCodeBlock.letStatements: List<FireRulesLetStatement>
    get() = statementList.filterIsInstance<FireRulesLetStatement>()
