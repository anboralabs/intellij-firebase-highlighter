package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.lang.core.psi.*

val FireRulesCodeBlock.letStatements: List<FireRulesLetStatement>
    get() = statementList.filterIsInstance<FireRulesLetStatement>()
