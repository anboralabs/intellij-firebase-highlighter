package co.anbora.labs.firebase.lang.core.psi.ext

import co.anbora.labs.firebase.ide.icons.FirebaseIcons
import co.anbora.labs.firebase.lang.core.psi.FireRulesFunctionDef
import co.anbora.labs.firebase.lang.core.psi.impl.FireRuleNameIdentifierOwnerImpl
import com.intellij.lang.ASTNode
import javax.swing.Icon

/*val MvSpecFunction.typeParameters get() = this.typeParameterList?.typeParameterList.orEmpty()

val MvSpecFunction.parameters get() = this.functionParameterList?.functionParameterList.orEmpty()

val MvSpecFunction.parameterBindings get() = this.parameters.map { it.bindingPat }

val MvSpecFunction.typeParamsUsedOnlyInReturnType: List<MvTypeParameter>
    get() {
        val usedTypeParams = mutableSetOf<MvTypeParameter>()
        this.parameters
            .map { it.declaredTy }
            .forEach {
                it.foldTyTypeParameterWith { paramTy -> usedTypeParams.add(paramTy.parameter); paramTy }
            }
        return this.typeParameters.filter { it !in usedTypeParams }
    }*/


abstract class FireRuleFunctionMixin(node: ASTNode) : FireRuleNameIdentifierOwnerImpl(node),
                                                    FireRulesFunctionDef {

    var builtIn = false

    override fun canNavigate(): Boolean = !builtIn
    override fun canNavigateToSource(): Boolean = !builtIn

    override fun getIcon(flags: Int): Icon = FirebaseIcons.FUNCTION
}
