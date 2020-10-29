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

public class FirebaseRulesExpressionImpl extends ASTWrapperPsiElement implements FirebaseRulesExpression {

  public FirebaseRulesExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FirebaseRulesVisitor visitor) {
    visitor.visitExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FirebaseRulesVisitor) accept((FirebaseRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FirebaseRulesBooleanStatement getBooleanStatement() {
    return findChildByClass(FirebaseRulesBooleanStatement.class);
  }

  @Override
  @Nullable
  public FirebaseRulesBuiltInFunctionStatement getBuiltInFunctionStatement() {
    return findChildByClass(FirebaseRulesBuiltInFunctionStatement.class);
  }

  @Override
  @Nullable
  public FirebaseRulesCallFunctionStatement getCallFunctionStatement() {
    return findChildByClass(FirebaseRulesCallFunctionStatement.class);
  }

  @Override
  @Nullable
  public FirebaseRulesLiteralStatement getLiteralStatement() {
    return findChildByClass(FirebaseRulesLiteralStatement.class);
  }

  @Override
  @Nullable
  public FirebaseRulesNullStatement getNullStatement() {
    return findChildByClass(FirebaseRulesNullStatement.class);
  }

  @Override
  @Nullable
  public FirebaseRulesObjectStatement getObjectStatement() {
    return findChildByClass(FirebaseRulesObjectStatement.class);
  }

}
