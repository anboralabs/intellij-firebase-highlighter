// This is a generated file. Not intended for manual editing.
package co.anbora.labs.firebase.syntax.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import co.anbora.labs.firebase.syntax.psi.impl.*;

public interface FirebaseRulesTypes {

  IElementType ALLOW_STATEMENT = new FirebaseRulesElementType("ALLOW_STATEMENT");
  IElementType BRIDGE = new FirebaseRulesElementType("BRIDGE");
  IElementType COMPONENT = new FirebaseRulesElementType("COMPONENT");
  IElementType CONNECTION = new FirebaseRulesElementType("CONNECTION");
  IElementType FULL_PATH_STATEMENT = new FirebaseRulesElementType("FULL_PATH_STATEMENT");
  IElementType IMP = new FirebaseRulesElementType("IMP");
  IElementType LEFTLET = new FirebaseRulesElementType("LEFTLET");
  IElementType LINE_TERM = new FirebaseRulesElementType("LINE_TERM");
  IElementType MATCH_STATEMENT = new FirebaseRulesElementType("MATCH_STATEMENT");
  IElementType METADATA = new FirebaseRulesElementType("METADATA");
  IElementType NODE_RULE = new FirebaseRulesElementType("NODE_RULE");
  IElementType PORT = new FirebaseRulesElementType("PORT");
  IElementType PORT_WITH_INDEX = new FirebaseRulesElementType("PORT_WITH_INDEX");
  IElementType PROPERTY = new FirebaseRulesElementType("PROPERTY");
  IElementType RIGHTLET = new FirebaseRulesElementType("RIGHTLET");
  IElementType RULE_VERSION_STATEMENT = new FirebaseRulesElementType("RULE_VERSION_STATEMENT");
  IElementType SERVICE_STATEMENT = new FirebaseRulesElementType("SERVICE_STATEMENT");
  IElementType STMT = new FirebaseRulesElementType("STMT");

  IElementType ALLOW = new FirebaseRulesTokenType("allow");
  IElementType CHAR = new FirebaseRulesTokenType("char");
  IElementType COLON = new FirebaseRulesTokenType(":");
  IElementType COMMA = new FirebaseRulesTokenType(",");
  IElementType COMMENT = new FirebaseRulesTokenType("comment");
  IElementType COMPMETA = new FirebaseRulesTokenType("compMeta");
  IElementType DOT = new FirebaseRulesTokenType(".");
  IElementType DOT_COMMA = new FirebaseRulesTokenType("DOT_COMMA");
  IElementType EQ = new FirebaseRulesTokenType("=");
  IElementType FULL_PATH = new FirebaseRulesTokenType("FULL_PATH");
  IElementType LB = new FirebaseRulesTokenType("[");
  IElementType LEFT_BRACE = new FirebaseRulesTokenType("LEFT_BRACE");
  IElementType LP = new FirebaseRulesTokenType("(");
  IElementType MATCH = new FirebaseRulesTokenType("match");
  IElementType NODENAME = new FirebaseRulesTokenType("nodename");
  IElementType NUMBER = new FirebaseRulesTokenType("number");
  IElementType OP = new FirebaseRulesTokenType("->");
  IElementType PORTNAME = new FirebaseRulesTokenType("portname");
  IElementType PORTTOKEN = new FirebaseRulesTokenType("portToken");
  IElementType RB = new FirebaseRulesTokenType("]");
  IElementType RIGHT_BRACE = new FirebaseRulesTokenType("RIGHT_BRACE");
  IElementType RP = new FirebaseRulesTokenType(")");
  IElementType RULES_VERSION = new FirebaseRulesTokenType("RULES_VERSION");
  IElementType SERVICE = new FirebaseRulesTokenType("service");
  IElementType SERVICE_NAME = new FirebaseRulesTokenType("SERVICE_NAME");
  IElementType STRING = new FirebaseRulesTokenType("string");
  IElementType VERSIONS = new FirebaseRulesTokenType("VERSIONS");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALLOW_STATEMENT) {
        return new FirebaseRulesAllowStatementImpl(node);
      }
      else if (type == BRIDGE) {
        return new FirebaseRulesBridgeImpl(node);
      }
      else if (type == COMPONENT) {
        return new FirebaseRulesComponentImpl(node);
      }
      else if (type == CONNECTION) {
        return new FirebaseRulesConnectionImpl(node);
      }
      else if (type == FULL_PATH_STATEMENT) {
        return new FirebaseRulesFullPathStatementImpl(node);
      }
      else if (type == IMP) {
        return new FirebaseRulesImpImpl(node);
      }
      else if (type == LEFTLET) {
        return new FirebaseRulesLeftletImpl(node);
      }
      else if (type == LINE_TERM) {
        return new FirebaseRulesLineTermImpl(node);
      }
      else if (type == MATCH_STATEMENT) {
        return new FirebaseRulesMatchStatementImpl(node);
      }
      else if (type == METADATA) {
        return new FirebaseRulesMetadataImpl(node);
      }
      else if (type == NODE_RULE) {
        return new FirebaseRulesNodeRuleImpl(node);
      }
      else if (type == PORT) {
        return new FirebaseRulesPortImpl(node);
      }
      else if (type == PORT_WITH_INDEX) {
        return new FirebaseRulesPortWithIndexImpl(node);
      }
      else if (type == PROPERTY) {
        return new FirebaseRulesPropertyImpl(node);
      }
      else if (type == RIGHTLET) {
        return new FirebaseRulesRightletImpl(node);
      }
      else if (type == RULE_VERSION_STATEMENT) {
        return new FirebaseRulesRuleVersionStatementImpl(node);
      }
      else if (type == SERVICE_STATEMENT) {
        return new FirebaseRulesServiceStatementImpl(node);
      }
      else if (type == STMT) {
        return new FirebaseRulesStmtImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
