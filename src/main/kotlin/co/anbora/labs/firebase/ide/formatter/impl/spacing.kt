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
            /*.after(RULES_VERSION).spacing(1, 1, 0, false, 0)
            .after(EQ).spacing(1, 1, 0, false, 0)
            .after(VERSIONS).spacing(0,0,0,false,0)
            //Service Statement
            .after(SERVICE_KEYWORD).spacing(1, 1, 0, false, 0)
            .after(SERVICE_NAME).spacing(1, 1, 0, false, 0)
            //Function Statement
            .after(FUNCTION_KEYWORD).spacing(1, 1, 0, false, 0)
            .after(FUNCTION_PARAMETER_LIST).spacing(1, 1, 0, false, 0)
            //Match Statement
            .after(MATCH_KEYWORD).spacing(1, 1, 0, false, 0)
            .after(FULL_PATH_STATEMENT).spacing(1, 1, 0, false, 0)
            //Allow Statement
            .after(ALLOW_KEYWORD).spacing(1, 1, 0, false, 0)
            .after(PERMISSION_KEY_WORD).spacing(0,0,0,false,0)
            .after(COMMA).spacing(1, 1, 0, false, 0)
            .after(COLON).spacing(1, 1, 0, false, 0)
            .after(IF_KEYWORD).spacing(1, 1, 0, false, 0)
            .after(EXPRESSION).spacing(1, 1, 0, false, 0)
            .after(OROR).spacing(1, 1, 0, false, 0)
            .after(ANDAND).spacing(1, 1, 0, false, 0)
            .after(LT).spacing(1, 1, 0, false, 0)
            .after(GT).spacing(1, 1, 0, false, 0)
            .after(LE).spacing(1, 1, 0, false, 0)
            .after(GE).spacing(1, 1, 0, false, 0)
            .after(EQEQ).spacing(1, 1, 0, false, 0)
            .after(NE).spacing(1, 1, 0, false, 0)
            .before(DOT_COMMA).spacing(0,0,0,false,0)*/
}
