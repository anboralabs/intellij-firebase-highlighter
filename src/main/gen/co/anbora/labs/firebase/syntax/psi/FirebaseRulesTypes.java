// This is a generated file. Not intended for manual editing.
package co.anbora.labs.firebase.syntax.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import co.anbora.labs.firebase.syntax.psi.impl.*;

public interface FirebaseRulesTypes {

  IElementType MATCH_STATEMENT = new FirebaseRulesElementType("MATCH_STATEMENT");
  IElementType SERVICE_STATEMENT = new FirebaseRulesElementType("SERVICE_STATEMENT");

  IElementType ALLOW = new FirebaseRulesTokenType("ALLOW");
  IElementType MATCH = new FirebaseRulesTokenType("MATCH");
  IElementType SERVICE = new FirebaseRulesTokenType("SERVICE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == MATCH_STATEMENT) {
        return new FirebaseRulesMatchStatementImpl(node);
      }
      else if (type == SERVICE_STATEMENT) {
        return new FirebaseRulesServiceStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
