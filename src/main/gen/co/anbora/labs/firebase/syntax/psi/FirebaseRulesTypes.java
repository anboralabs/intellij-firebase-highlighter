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
  IElementType BUILT_IN_FUNCTION_STATEMENT = new FirebaseRulesElementType("BUILT_IN_FUNCTION_STATEMENT");
  IElementType CALL_FUNCTION_STATEMENT = new FirebaseRulesElementType("CALL_FUNCTION_STATEMENT");
  IElementType CONDITIONAL_EXPRESSION = new FirebaseRulesElementType("CONDITIONAL_EXPRESSION");
  IElementType CONDITIONAL_STATEMENT = new FirebaseRulesElementType("CONDITIONAL_STATEMENT");
  IElementType EXIST_BUILT_IN_FUNCTION_STATEMENT = new FirebaseRulesElementType("EXIST_BUILT_IN_FUNCTION_STATEMENT");
  IElementType EXPRESSION = new FirebaseRulesElementType("EXPRESSION");
  IElementType FULL_BUILT_IN_PARAMETER_STATEMENT = new FirebaseRulesElementType("FULL_BUILT_IN_PARAMETER_STATEMENT");
  IElementType FULL_PATH_STATEMENT = new FirebaseRulesElementType("FULL_PATH_STATEMENT");
  IElementType FUNCTION_PARAMETER_STATEMENT = new FirebaseRulesElementType("FUNCTION_PARAMETER_STATEMENT");
  IElementType FUNCTION_STATEMENT = new FirebaseRulesElementType("FUNCTION_STATEMENT");
  IElementType GET_BUILT_IN_FUNCTION_STATEMENT = new FirebaseRulesElementType("GET_BUILT_IN_FUNCTION_STATEMENT");
  IElementType LITERAL_STATEMENT = new FirebaseRulesElementType("LITERAL_STATEMENT");
  IElementType MATCH_STATEMENT = new FirebaseRulesElementType("MATCH_STATEMENT");
  IElementType NULL_STATEMENT = new FirebaseRulesElementType("NULL_STATEMENT");
  IElementType OBJECT_STATEMENT = new FirebaseRulesElementType("OBJECT_STATEMENT");
  IElementType PARAMETER_STATEMENT = new FirebaseRulesElementType("PARAMETER_STATEMENT");
  IElementType PATH_BUILT_IN_PARAMETER_STATEMENT = new FirebaseRulesElementType("PATH_BUILT_IN_PARAMETER_STATEMENT");
  IElementType PATH_STATEMENT = new FirebaseRulesElementType("PATH_STATEMENT");
  IElementType PERMISSION_KEY_WORD = new FirebaseRulesElementType("PERMISSION_KEY_WORD");
  IElementType PERMISSION_STATEMENT = new FirebaseRulesElementType("PERMISSION_STATEMENT");
  IElementType PROPERTY = new FirebaseRulesElementType("PROPERTY");
  IElementType RETURN_STATEMENT = new FirebaseRulesElementType("RETURN_STATEMENT");
  IElementType RULE_VERSION_STATEMENT = new FirebaseRulesElementType("RULE_VERSION_STATEMENT");
  IElementType SERVICE_STATEMENT = new FirebaseRulesElementType("SERVICE_STATEMENT");

  IElementType ALLOW_KEYWORD = new FirebaseRulesTokenType("ALLOW_KEYWORD");
  IElementType ANDAND = new FirebaseRulesTokenType("ANDAND");
  IElementType COLON = new FirebaseRulesTokenType(":");
  IElementType COMMA = new FirebaseRulesTokenType(",");
  IElementType CREATE_KEYWORD = new FirebaseRulesTokenType("CREATE_KEYWORD");
  IElementType DELETE_KEYWORD = new FirebaseRulesTokenType("DELETE_KEYWORD");
  IElementType DOT = new FirebaseRulesTokenType(".");
  IElementType DOT_COMMA = new FirebaseRulesTokenType("DOT_COMMA");
  IElementType EQ = new FirebaseRulesTokenType("=");
  IElementType EQEQ = new FirebaseRulesTokenType("EQEQ");
  IElementType EXITS_KEYWORD = new FirebaseRulesTokenType("EXITS_KEYWORD");
  IElementType FALSE_KEYWORD = new FirebaseRulesTokenType("FALSE_KEYWORD");
  IElementType FUNCTION_KEYWORD = new FirebaseRulesTokenType("FUNCTION_KEYWORD");
  IElementType GE = new FirebaseRulesTokenType("GE");
  IElementType GET_KEYWORD = new FirebaseRulesTokenType("GET_KEYWORD");
  IElementType GT = new FirebaseRulesTokenType("GT");
  IElementType IDENTIFIER = new FirebaseRulesTokenType("IDENTIFIER");
  IElementType IF_KEYWORD = new FirebaseRulesTokenType("IF_KEYWORD");
  IElementType IN_KEYWORD = new FirebaseRulesTokenType("IN_KEYWORD");
  IElementType LB = new FirebaseRulesTokenType("[");
  IElementType LE = new FirebaseRulesTokenType("LE");
  IElementType LEFT_BRACE = new FirebaseRulesTokenType("LEFT_BRACE");
  IElementType LINE_COMMENT = new FirebaseRulesTokenType("LINE_COMMENT");
  IElementType LIST_KEYWORD = new FirebaseRulesTokenType("LIST_KEYWORD");
  IElementType LP = new FirebaseRulesTokenType("(");
  IElementType LT = new FirebaseRulesTokenType("LT");
  IElementType MATCH_KEYWORD = new FirebaseRulesTokenType("MATCH_KEYWORD");
  IElementType NE = new FirebaseRulesTokenType("NE");
  IElementType NULL_KEYWORD = new FirebaseRulesTokenType("NULL_KEYWORD");
  IElementType NUMBER = new FirebaseRulesTokenType("number");
  IElementType OP = new FirebaseRulesTokenType("->");
  IElementType OROR = new FirebaseRulesTokenType("OROR");
  IElementType PATH_BUILT_IN = new FirebaseRulesTokenType("PATH_BUILT_IN");
  IElementType PATH_VARIABLE = new FirebaseRulesTokenType("PATH_VARIABLE");
  IElementType RB = new FirebaseRulesTokenType("]");
  IElementType READ_KEYWORD = new FirebaseRulesTokenType("READ_KEYWORD");
  IElementType RETURN_KEYWORD = new FirebaseRulesTokenType("RETURN_KEYWORD");
  IElementType RIGHT_BRACE = new FirebaseRulesTokenType("RIGHT_BRACE");
  IElementType RP = new FirebaseRulesTokenType(")");
  IElementType RULES_VERSION = new FirebaseRulesTokenType("RULES_VERSION");
  IElementType SERVICE_KEYWORD = new FirebaseRulesTokenType("SERVICE_KEYWORD");
  IElementType SERVICE_NAME = new FirebaseRulesTokenType("SERVICE_NAME");
  IElementType SLASH = new FirebaseRulesTokenType("SLASH");
  IElementType STRING = new FirebaseRulesTokenType("string");
  IElementType TRUE_KEYWORD = new FirebaseRulesTokenType("TRUE_KEYWORD");
  IElementType UPDATE_KEYWORD = new FirebaseRulesTokenType("UPDATE_KEYWORD");
  IElementType VERSIONS = new FirebaseRulesTokenType("VERSIONS");
  IElementType WRITE_KEYWORD = new FirebaseRulesTokenType("WRITE_KEYWORD");

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
      else if (type == BUILT_IN_FUNCTION_STATEMENT) {
        return new FirebaseRulesBuiltInFunctionStatementImpl(node);
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
      else if (type == EXIST_BUILT_IN_FUNCTION_STATEMENT) {
        return new FirebaseRulesExistBuiltInFunctionStatementImpl(node);
      }
      else if (type == EXPRESSION) {
        return new FirebaseRulesExpressionImpl(node);
      }
      else if (type == FULL_BUILT_IN_PARAMETER_STATEMENT) {
        return new FirebaseRulesFullBuiltInParameterStatementImpl(node);
      }
      else if (type == FULL_PATH_STATEMENT) {
        return new FirebaseRulesFullPathStatementImpl(node);
      }
      else if (type == FUNCTION_PARAMETER_STATEMENT) {
        return new FirebaseRulesFunctionParameterStatementImpl(node);
      }
      else if (type == FUNCTION_STATEMENT) {
        return new FirebaseRulesFunctionStatementImpl(node);
      }
      else if (type == GET_BUILT_IN_FUNCTION_STATEMENT) {
        return new FirebaseRulesGetBuiltInFunctionStatementImpl(node);
      }
      else if (type == LITERAL_STATEMENT) {
        return new FirebaseRulesLiteralStatementImpl(node);
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
      else if (type == PARAMETER_STATEMENT) {
        return new FirebaseRulesParameterStatementImpl(node);
      }
      else if (type == PATH_BUILT_IN_PARAMETER_STATEMENT) {
        return new FirebaseRulesPathBuiltInParameterStatementImpl(node);
      }
      else if (type == PATH_STATEMENT) {
        return new FirebaseRulesPathStatementImpl(node);
      }
      else if (type == PERMISSION_KEY_WORD) {
        return new FirebaseRulesPermissionKeyWordImpl(node);
      }
      else if (type == PERMISSION_STATEMENT) {
        return new FirebaseRulesPermissionStatementImpl(node);
      }
      else if (type == PROPERTY) {
        return new FirebaseRulesPropertyImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new FirebaseRulesReturnStatementImpl(node);
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
