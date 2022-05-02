package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.lang.core.psi.FireRulesMatchBlock

fun FireRulesMatchBlock.functions() = this.functionDefList.orEmpty()