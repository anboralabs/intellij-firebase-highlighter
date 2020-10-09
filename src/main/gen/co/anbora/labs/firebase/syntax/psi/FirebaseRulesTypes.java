// This is a generated file. Not intended for manual editing.
package co.anbora.labs.firebase.syntax.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import co.anbora.labs.firebase.syntax.psi.impl.*;

public interface FirebaseRulesTypes {

  IElementType ALLOW_STATEMENT = new FirebaseRulesElementType("ALLOW_STATEMENT");
  IElementType BOOLEAN_OPERATOR = new FirebaseRulesElementType("BOOLEAN_OPERATOR");
  IElementType BOOLEAN_STATEMENT = new FirebaseRulesElementType("BOOLEAN_STATEMENT");
  IElementType CALL_FUNCTION_STATEMENT = new FirebaseRulesElementType("CALL_FUNCTION_STATEMENT");
  IElementType CONDITIONAL_EXPRESSION = new FirebaseRulesElementType("CONDITIONAL_EXPRESSION");
  IElementType CONDITIONAL_STATEMENT = new FirebaseRulesElementType("CONDITIONAL_STATEMENT");
  IElementType EXPRESSION = new FirebaseRulesElementType("EXPRESSION");
  IElementType FULL_PATH_STATEMENT = new FirebaseRulesElementType("FULL_PATH_STATEMENT");
  IElementType FUNCTION_PARAMETER_STATEMENT = new FirebaseRulesElementType("FUNCTION_PARAMETER_STATEMENT");
  IElementType MATCH_STATEMENT = new FirebaseRulesElementType("MATCH_STATEMENT");
  IElementType NULL_STATEMENT = new FirebaseRulesElementType("NULL_STATEMENT");
  IElementType OBJECT_STATEMENT = new FirebaseRulesElementType("OBJECT_STATEMENT");
  IElementType PATH_STATEMENT = new FirebaseRulesElementType("PATH_STATEMENT");
  IElementType PERMISSION_STATEMENT = new FirebaseRulesElementType("PERMISSION_STATEMENT");
  IElementType PROPERTY = new FirebaseRulesElementType("PROPERTY");
  IElementType RULE_VERSION_STATEMENT = new FirebaseRulesElementType("RULE_VERSION_STATEMENT");
  IElementType SERVICE_STATEMENT = new FirebaseRulesElementType("SERVICE_STATEMENT");

  IElementType ALLOW_KEYWORD = new FirebaseRulesTokenType("ALLOW_KEYWORD");
  IElementType ANDAND = new FirebaseRulesTokenType("ANDAND");
  IElementType COLON = new FirebaseRulesTokenType(":");
  IElementType COMMA = new FirebaseRulesTokenType(",");
  IElementType COMMENT = new FirebaseRulesTokenType("comment");
  IElementType DOT = new FirebaseRulesTokenType(".");
  IElementType DOT_COMMA = new FirebaseRulesTokenType("DOT_COMMA");
  IElementType EQ = new FirebaseRulesTokenType("=");
  IElementType EQEQ = new FirebaseRulesTokenType("EQEQ");
  IElementType FALSE_KEYWORD = new FirebaseRulesTokenType("FALSE_KEYWORD");
  IElementType GE = new FirebaseRulesTokenType("GE");
  IElementType GT = new FirebaseRulesTokenType("GT");
  IElementType IDENTIFIER = new FirebaseRulesTokenType("IDENTIFIER");
  IElementType IF_KEYWORD = new FirebaseRulesTokenType("IF_KEYWORD");
  IElementType LB = new FirebaseRulesTokenType("[");
  IElementType LE = new FirebaseRulesTokenType("LE");
  IElementType LEFT_BRACE = new FirebaseRulesTokenType("LEFT_BRACE");
  IElementType LP = new FirebaseRulesTokenType("(");
  IElementType LT = new FirebaseRulesTokenType("LT");
  IElementType MATCH_KEYWORD = new FirebaseRulesTokenType("MATCH_KEYWORD");
  IElementType NE = new FirebaseRulesTokenType("NE");
  IElementType NULL_KEYWORD = new FirebaseRulesTokenType("NULL_KEYWORD");
  IElementType NUMBER = new FirebaseRulesTokenType("number");
  IElementType OP = new FirebaseRulesTokenType("->");
  IElementType OROR = new FirebaseRulesTokenType("OROR");
  IElementType PATH_VARIABLE = new FirebaseRulesTokenType("PATH_VARIABLE");
  IElementType PERMISSION = new FirebaseRulesTokenType("PERMISSION");
  IElementType PORTTOKEN = new FirebaseRulesTokenType("portToken");
  IElementType RB = new FirebaseRulesTokenType("]");
  IElementType RIGHT_BRACE = new FirebaseRulesTokenType("RIGHT_BRACE");
  IElementType RP = new FirebaseRulesTokenType(")");
  IElementType RULES_VERSION = new FirebaseRulesTokenType("RULES_VERSION");
  IElementType SERVICE_KEYWORD = new FirebaseRulesTokenType("SERVICE_KEYWORD");
  IElementType SERVICE_NAME = new FirebaseRulesTokenType("SERVICE_NAME");
  IElementType SLASH = new FirebaseRulesTokenType("SLASH");
  IElementType STRING = new FirebaseRulesTokenType("string");
  IElementType TRUE_KEYWORD = new FirebaseRulesTokenType("TRUE_KEYWORD");
  IElementType VERSIONS = new FirebaseRulesTokenType("VERSIONS");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALLOW_STATEMENT) {
        return new FirebaseRulesAllowStatementImpl(node);
      }
      else if (type == BOOLEAN_OPERATOR) {
        return new FirebaseRulesBooleanOperatorImpl(node);
      }
      else if (type == BOOLEAN_STATEMENT) {
        return new FirebaseRulesBooleanStatementImpl(node);
      }
      else if (type == CALL_FUNCTION_STATEMENT) {
        return new FirebaseRulesCallFunctionStatementImpl(node);
      }
      else if (type == CONDITIONAL_EXPRESSION) {
        return new FirebaseRulesConditionalExpressionImpl(node);
      }
      else if (type == CONDITIONAL_STATEMENT) {
        return new FirebaseRulesConditionalStatementImpl(node);
      }
      else if (type == EXPRESSION) {
        return new FirebaseRulesExpressionImpl(node);
      }
      else if (type == FULL_PATH_STATEMENT) {
        return new FirebaseRulesFullPathStatementImpl(node);
      }
      else if (type == FUNCTION_PARAMETER_STATEMENT) {
        return new FirebaseRulesFunctionParameterStatementImpl(node);
      }
      else if (type == MATCH_STATEMENT) {
        return new FirebaseRulesMatchStatementImpl(node);
      }
      else if (type == NULL_STATEMENT) {
        return new FirebaseRulesNullStatementImpl(node);
      }
      else if (type == OBJECT_STATEMENT) {
        return new FirebaseRulesObjectStatementImpl(node);
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
