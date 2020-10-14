// This is a generated file. Not intended for manual editing.
package co.anbora.labs.firebase.syntax.psi.impl;

import static co.anbora.labs.firebase.syntax.psi.FirebaseRulesTypes.*;

import co.anbora.labs.firebase.syntax.psi.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.*;

public class FirebaseRulesAllowStatementImpl
    extends ASTWrapperPsiElement implements FirebaseRulesAllowStatement {

  public FirebaseRulesAllowStatementImpl(@NotNull ASTNode node) { super(node); }

  public void accept(@NotNull FirebaseRulesVisitor visitor) {
    visitor.visitAllowStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FirebaseRulesVisitor)
      accept((FirebaseRulesVisitor)visitor);
    else
      super.accept(visitor);
  }

  @Override
  @NotNull
  public FirebaseRulesConditionalStatement getConditionalStatement() {
    return findNotNullChildByClass(FirebaseRulesConditionalStatement.class);
  }

  @Override
  @NotNull
  public FirebaseRulesPermissionStatement getPermissionStatement() {
    return findNotNullChildByClass(FirebaseRulesPermissionStatement.class);
  }
}
