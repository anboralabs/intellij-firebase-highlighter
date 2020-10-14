// This is a generated file. Not intended for manual editing.
package co.anbora.labs.firebase.syntax.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static co.anbora.labs.firebase.syntax.psi.FirebaseRulesTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import co.anbora.labs.firebase.syntax.psi.*;

public class FirebaseRulesConditionalExpressionImpl extends ASTWrapperPsiElement implements FirebaseRulesConditionalExpression {

  public FirebaseRulesConditionalExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FirebaseRulesVisitor visitor) {
    visitor.visitConditionalExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FirebaseRulesVisitor) accept((FirebaseRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FirebaseRulesBooleanOperator> getBooleanOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FirebaseRulesBooleanOperator.class);
  }

  @Override
  @NotNull
  public List<FirebaseRulesExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FirebaseRulesExpression.class);
  }

}
