// This is a generated file. Not intended for manual editing.
package co.anbora.labs.firebase.syntax.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FirebaseRulesBridge extends PsiElement {

  @Nullable
  FirebaseRulesLeftlet getLeftlet();

  @Nullable
  FirebaseRulesNodeRule getNodeRule();

  @NotNull
  List<FirebaseRulesPort> getPortList();

  @Nullable
  FirebaseRulesRightlet getRightlet();

  @Nullable
  PsiElement getString();

}
