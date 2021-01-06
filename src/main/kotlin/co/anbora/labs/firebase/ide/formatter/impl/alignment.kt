package co.anbora.labs.firebase.ide.formatter.impl

import co.anbora.labs.firebase.ide.formatter.FirebaseAlignmentStrategy
import co.anbora.labs.firebase.ide.formatter.FirebaseFormatterBlock
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.CALL_FUNCTION_STATEMENT
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.PARAMETER_STATEMENT

fun FirebaseFormatterBlock.getAlignmentStrategy(): FirebaseAlignmentStrategy = when (node.elementType) {
    PARAMETER_STATEMENT, CALL_FUNCTION_STATEMENT ->
        FirebaseAlignmentStrategy
            .shared()
            .alignUnlessBlockDelim()
            .alignIf(ctx.commonSettings.ALIGN_MULTILINE_PARAMETERS)
    else -> FirebaseAlignmentStrategy.NullStrategy

}

fun FirebaseAlignmentStrategy.alignUnlessBlockDelim(): FirebaseAlignmentStrategy =
    alignIf { c, p, _ -> !c.isDelimiterOfCurrentBlock(p) }