package co.anbora.labs.firebase.ide.formatter.impl

import co.anbora.labs.firebase.ide.formatter.FirebaseAlignmentStrategy
import co.anbora.labs.firebase.ide.formatter.FirebaseFormatterBlock
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.CALL_ARGUMENTS
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.FUNCTION_PARAMETER_LIST

fun FirebaseFormatterBlock.getAlignmentStrategy(): FirebaseAlignmentStrategy = when (node.elementType) {
    FUNCTION_PARAMETER_LIST, CALL_ARGUMENTS ->
        FirebaseAlignmentStrategy
            .shared()
            .alignUnlessBlockDelim()
            .alignIf(ctx.commonSettings.ALIGN_MULTILINE_PARAMETERS)
    else -> FirebaseAlignmentStrategy.NullStrategy

}

fun FirebaseAlignmentStrategy.alignUnlessBlockDelim(): FirebaseAlignmentStrategy =
    alignIf { c, p, _ -> !c.isDelimiterOfCurrentBlock(p) }