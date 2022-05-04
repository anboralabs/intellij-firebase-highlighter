package co.anbora.labs.firebase.ide.formatter.impl

import co.anbora.labs.firebase.ide.formatter.FirebaseFmtContext
import co.anbora.labs.firebase.ide.formatter.FirebaseFormatterBlock
import co.anbora.labs.firebase.lang.FirebaseRulesLanguage
import co.anbora.labs.firebase.lang.core.psi.FireRulesTypes.*
import com.intellij.formatting.Block
import com.intellij.formatting.Spacing
import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings

fun FirebaseFormatterBlock.computeSpacing(child1: Block?, child2: Block, ctx: FirebaseFmtContext): Spacing? = ctx.spacingBuilder.getSpacing(this, child1, child2)

fun createSpacingBuilder(commonSettings: CodeStyleSettings): SpacingBuilder {
    return SpacingBuilder(commonSettings, FirebaseRulesLanguage)
            //Rules Version
            .after(RULES_VERSION).spacing(1, 1, 0, false, 0)
            .after(EQ).spacing(1, 1, 0, false, 0)
            .after(VERSIONS).spacing(0,0,0,false,0)
            //Service Statement
            .after(SERVICE).spacing(1, 1, 0, false, 0)
            .after(SERVICE_NAME).spacing(1, 1, 0, false, 0)
            //Function Statement
            .after(FUNCTION).spacing(1, 1, 0, false, 0)
            .after(FUNCTION_PARAMETER_LIST).spacing(1, 1, 0, false, 0)
            .after(RETURN).spacing(1, 1, 0, false, 0)
            .around(IS).spacing(1, 1, 0, false, 0)
            //Match Statement
            .after(MATCH).spacing(1, 1, 0, false, 0)
            .after(FULL_PATH).spacing(1, 1, 0, false, 0)
            //Allow Statement
            .after(ALLOW).spacing(1, 1, 0, false, 0)
            .after(PERMISSIONS).spacing(0,0,0,false,0)
            .after(COMMA).spacing(1, 1, 0, false, 0)
            .after(COLON).spacing(1, 1, 0, false, 0)
            .after(IF).spacing(1, 1, 0, false, 0)
            .after(EXPR).spacing(1, 1, 0, false, 0)

            .around(OR_OR).spacing(1, 1, 0, false, 0)
            .around(AND_AND).spacing(1, 1, 0, false, 0)
            .around(LT).spacing(1, 1, 0, false, 0)
            .around(GT).spacing(1, 1, 0, false, 0)
            .around(LT_EQ).spacing(1, 1, 0, false, 0)
            .around(GT_EQ).spacing(1, 1, 0, false, 0)
            .around(EQ_EQ).spacing(1, 1, 0, false, 0)
            .around(NOT_EQ).spacing(1, 1, 0, false, 0)

            .before(SEMICOLON).spacing(0,0,0,false,0)
}
