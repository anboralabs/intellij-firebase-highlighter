package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.lang.core.psi.FireRulesMatchBlock
import co.anbora.labs.firebase.lang.core.psi.FireRulesMatchDef

fun FireRulesMatchDef.pathVars() = this.fullPath?.pathStatementList?.mapNotNull{ it.pathVar }.orEmpty()

fun FireRulesMatchBlock.functions() = this.functionDefList.orEmpty()
