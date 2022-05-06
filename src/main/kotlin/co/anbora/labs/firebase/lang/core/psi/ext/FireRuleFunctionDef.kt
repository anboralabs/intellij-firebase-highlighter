package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.lang.core.psi.FireRulesFunctionDef

fun FireRulesFunctionDef.parameters() = this.functionParameterList?.functionParameterList.orEmpty()
