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

public class FirebaseRulesBridgeImpl extends ASTWrapperPsiElement implements FirebaseRulesBridge {

  public FirebaseRulesBridgeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FirebaseRulesVisitor visitor) {
    visitor.visitBridge(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FirebaseRulesVisitor) accept((FirebaseRulesVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FirebaseRulesLeftlet getLeftlet() {
    return findChildByClass(FirebaseRulesLeftlet.class);
  }

  @Override
  @Nullable
  public FirebaseRulesNodeRule getNodeRule() {
    return findChildByClass(FirebaseRulesNodeRule.class);
  }

  @Override
  @NotNull
  public List<FirebaseRulesPort> getPortList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FirebaseRulesPort.class);
  }

  @Override
  @Nullable
  public FirebaseRulesRightlet getRightlet() {
    return findChildByClass(FirebaseRulesRightlet.class);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

}
