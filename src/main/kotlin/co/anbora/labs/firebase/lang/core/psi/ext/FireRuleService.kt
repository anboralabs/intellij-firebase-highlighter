package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.lang.core.psi.FireRulesServiceBlock

fun FireRulesServiceBlock.functions() = this.functionDefList.orEmpty()