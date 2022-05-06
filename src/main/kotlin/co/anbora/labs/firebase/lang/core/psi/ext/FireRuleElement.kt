package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.lang.core.psi.FireRuleElement
import co.anbora.labs.firebase.lang.core.psi.FireRulesFunctionDef
import co.anbora.labs.firebase.lang.core.psi.FireRulesMatchDef
import co.anbora.labs.firebase.lang.core.psi.FireRulesServiceDef
import com.intellij.psi.util.PsiTreeUtil

fun FireRuleElement.isMslAvailable(): Boolean {
    return PsiTreeUtil.findFirstParent(this, false) {
         it is FireRulesServiceDef
                || it is FireRulesMatchDef
                || it is FireRulesFunctionDef
    } != null
}
