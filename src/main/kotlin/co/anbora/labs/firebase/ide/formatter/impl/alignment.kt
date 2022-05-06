package co.anbora.labs.firebase.ide.formatter.impl

import co.anbora.labs.firebase.ide.formatter.FirebaseAlignmentStrategy
import co.anbora.labs.firebase.ide.formatter.FirebaseFormatterBlock
import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes.CALL_ARGUMENT_LIST
import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes.FUNCTION_PARAMETER_LIST

fun FirebaseFormatterBlock.getAlignmentStrategy(): FirebaseAlignmentStrategy = when (node.elementType) {
    FUNCTION_PARAMETER_LIST, CALL_ARGUMENT_LIST ->
        FirebaseAlignmentStrategy
            .shared()
            .alignUnlessBlockDelim()
            .alignIf(ctx.commonSettings.ALIGN_MULTILINE_PARAMETERS)
    else -> FirebaseAlignmentStrategy.NullStrategy

}

fun FirebaseAlignmentStrategy.alignUnlessBlockDelim(): FirebaseAlignmentStrategy =
    alignIf { c, p, _ -> !c.isDelimiterOfCurrentBlock(p) }
