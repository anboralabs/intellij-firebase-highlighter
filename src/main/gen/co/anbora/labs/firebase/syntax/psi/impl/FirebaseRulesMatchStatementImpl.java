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

public class FirebaseRulesMatchStatementImpl extends ASTWrapperPsiElement implements FirebaseRulesMatchStatement {

  public FirebaseRulesMatchStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FirebaseRulesVisitor visitor) {
    visitor.visitMatchStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FirebaseRulesVisitor) accept((FirebaseRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FirebaseRulesAllowStatement> getAllowStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FirebaseRulesAllowStatement.class);
  }

  @Override
  @NotNull
  public FirebaseRulesFullPathStatement getFullPathStatement() {
    return findNotNullChildByClass(FirebaseRulesFullPathStatement.class);
  }

  @Override
  @NotNull
  public List<FirebaseRulesFunctionStatement> getFunctionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FirebaseRulesFunctionStatement.class);
  }

  @Override
  @NotNull
  public List<FirebaseRulesMatchStatement> getMatchStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FirebaseRulesMatchStatement.class);
  }

}
