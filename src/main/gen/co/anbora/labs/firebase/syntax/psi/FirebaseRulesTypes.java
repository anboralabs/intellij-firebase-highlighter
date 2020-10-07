// This is a generated file. Not intended for manual editing.
package co.anbora.labs.firebase.syntax.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import co.anbora.labs.firebase.syntax.psi.impl.*;

public interface FirebaseRulesTypes {

  IElementType ALLOW_STATEMENT = new FirebaseRulesElementType("ALLOW_STATEMENT");
  IElementType FULL_PATH_STATEMENT = new FirebaseRulesElementType("FULL_PATH_STATEMENT");
  IElementType MATCH_STATEMENT = new FirebaseRulesElementType("MATCH_STATEMENT");
  IElementType PATH_STATEMENT = new FirebaseRulesElementType("PATH_STATEMENT");
  IElementType PERMISSION_STATEMENT = new FirebaseRulesElementType("PERMISSION_STATEMENT");
  IElementType PROPERTY = new FirebaseRulesElementType("PROPERTY");
  IElementType RULE_VERSION_STATEMENT = new FirebaseRulesElementType("RULE_VERSION_STATEMENT");
  IElementType SERVICE_STATEMENT = new FirebaseRulesElementType("SERVICE_STATEMENT");

  IElementType ALLOW = new FirebaseRulesTokenType("allow");
  IElementType COLON = new FirebaseRulesTokenType(":");
  IElementType COMMA = new FirebaseRulesTokenType(",");
  IElementType COMMENT = new FirebaseRulesTokenType("comment");
  IElementType COMPMETA = new FirebaseRulesTokenType("compMeta");
  IElementType DOT = new FirebaseRulesTokenType(".");
  IElementType DOT_COMMA = new FirebaseRulesTokenType("DOT_COMMA");
  IElementType EQ = new FirebaseRulesTokenType("=");
  IElementType LB = new FirebaseRulesTokenType("[");
  IElementType LEFT_BRACE = new FirebaseRulesTokenType("LEFT_BRACE");
  IElementType LP = new FirebaseRulesTokenType("(");
  IElementType MATCH = new FirebaseRulesTokenType("match");
  IElementType NUMBER = new FirebaseRulesTokenType("number");
  IElementType OP = new FirebaseRulesTokenType("->");
  IElementType PATH_NAME = new FirebaseRulesTokenType("PATH_NAME");
  IElementType PATH_VARIABLE = new FirebaseRulesTokenType("PATH_VARIABLE");
  IElementType PERMISSION = new FirebaseRulesTokenType("PERMISSION");
  IElementType PORTTOKEN = new FirebaseRulesTokenType("portToken");
  IElementType RB = new FirebaseRulesTokenType("]");
  IElementType RIGHT_BRACE = new FirebaseRulesTokenType("RIGHT_BRACE");
  IElementType RP = new FirebaseRulesTokenType(")");
  IElementType RULES_VERSION = new FirebaseRulesTokenType("RULES_VERSION");
  IElementType SERVICE = new FirebaseRulesTokenType("service");
  IElementType SERVICE_NAME = new FirebaseRulesTokenType("SERVICE_NAME");
  IElementType SLASH = new FirebaseRulesTokenType("SLASH");
  IElementType STRING = new FirebaseRulesTokenType("string");
  IElementType VERSIONS = new FirebaseRulesTokenType("VERSIONS");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALLOW_STATEMENT) {
        return new FirebaseRulesAllowStatementImpl(node);
      }
      else if (type == FULL_PATH_STATEMENT) {
        return new FirebaseRulesFullPathStatementImpl(node);
      }
      else if (type == MATCH_STATEMENT) {
        return new FirebaseRulesMatchStatementImpl(node);
      }
      else if (type == PATH_STATEMENT) {
        return new FirebaseRulesPathStatementImpl(node);
      }
      else if (type == PERMISSION_STATEMENT) {
        return new FirebaseRulesPermissionStatementImpl(node);
      }
      else if (type == PROPERTY) {
        return new FirebaseRulesPropertyImpl(node);
      }
      else if (type == RULE_VERSION_STATEMENT) {
        return new FirebaseRulesRuleVersionStatementImpl(node);
      }
      else if (type == SERVICE_STATEMENT) {
        return new FirebaseRulesServiceStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
