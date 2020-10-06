// This is a generated file. Not intended for manual editing.
package co.anbora.labs.firebase.syntax.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import co.anbora.labs.firebase.syntax.psi.impl.*;

public interface FirebaseRulesTypes {

  IElementType BRIDGE = new FirebaseRulesElementType("BRIDGE");
  IElementType COMPONENT = new FirebaseRulesElementType("COMPONENT");
  IElementType CONNECTION = new FirebaseRulesElementType("CONNECTION");
  IElementType IMP = new FirebaseRulesElementType("IMP");
  IElementType LEFTLET = new FirebaseRulesElementType("LEFTLET");
  IElementType LINE_TERM = new FirebaseRulesElementType("LINE_TERM");
  IElementType METADATA = new FirebaseRulesElementType("METADATA");
  IElementType NODE_RULE = new FirebaseRulesElementType("NODE_RULE");
  IElementType PORT = new FirebaseRulesElementType("PORT");
  IElementType PORT_WITH_INDEX = new FirebaseRulesElementType("PORT_WITH_INDEX");
  IElementType PROPERTY = new FirebaseRulesElementType("PROPERTY");
  IElementType RIGHTLET = new FirebaseRulesElementType("RIGHTLET");
  IElementType STMT = new FirebaseRulesElementType("STMT");

  IElementType CHAR = new FirebaseRulesTokenType("char");
  IElementType COLON = new FirebaseRulesTokenType(":");
  IElementType COMMA = new FirebaseRulesTokenType(",");
  IElementType COMMENT = new FirebaseRulesTokenType("comment");
  IElementType COMPMETA = new FirebaseRulesTokenType("compMeta");
  IElementType DOT = new FirebaseRulesTokenType(".");
  IElementType EQ = new FirebaseRulesTokenType("=");
  IElementType LB = new FirebaseRulesTokenType("[");
  IElementType LP = new FirebaseRulesTokenType("(");
  IElementType NODENAME = new FirebaseRulesTokenType("nodename");
  IElementType NUMBER = new FirebaseRulesTokenType("number");
  IElementType OP = new FirebaseRulesTokenType("->");
  IElementType PORTNAME = new FirebaseRulesTokenType("portname");
  IElementType PORTTOKEN = new FirebaseRulesTokenType("portToken");
  IElementType RB = new FirebaseRulesTokenType("]");
  IElementType RP = new FirebaseRulesTokenType(")");
  IElementType STRING = new FirebaseRulesTokenType("string");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BRIDGE) {
        return new FirebaseRulesBridgeImpl(node);
      }
      else if (type == COMPONENT) {
        return new FirebaseRulesComponentImpl(node);
      }
      else if (type == CONNECTION) {
        return new FirebaseRulesConnectionImpl(node);
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
      else if (type == STMT) {
        return new FirebaseRulesStmtImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
