// This is a generated file. Not intended for manual editing.
package co.anbora.labs.firebase.syntax.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static co.anbora.labs.firebase.syntax.psi.FirebaseRulesTypes.*;
import static co.anbora.labs.firebase.syntax.FirebaseRulesParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class FirebaseRulesParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // allow PermissionStatement COLON compMeta DOT_COMMA
  public static boolean AllowStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AllowStatement")) return false;
    if (!nextTokenIs(b, ALLOW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ALLOW);
    r = r && PermissionStatement(b, l + 1);
    r = r && consumeTokens(b, 0, COLON, COMPMETA, DOT_COMMA);
    exit_section_(b, m, ALLOW_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // (SLASH PathStatement)+
  public static boolean FullPathStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FullPathStatement")) return false;
    if (!nextTokenIs(b, SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FullPathStatement_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!FullPathStatement_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FullPathStatement", c)) break;
    }
    exit_section_(b, m, FULL_PATH_STATEMENT, r);
    return r;
  }

  // SLASH PathStatement
  private static boolean FullPathStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FullPathStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SLASH);
    r = r && PathStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // match FullPathStatement LEFT_BRACE (AllowStatement|MatchStatement)+ RIGHT_BRACE
  public static boolean MatchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchStatement")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH);
    r = r && FullPathStatement(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && MatchStatement_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, MATCH_STATEMENT, r);
    return r;
  }

  // (AllowStatement|MatchStatement)+
  private static boolean MatchStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchStatement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MatchStatement_3_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!MatchStatement_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MatchStatement_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // AllowStatement|MatchStatement
  private static boolean MatchStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchStatement_3_0")) return false;
    boolean r;
    r = AllowStatement(b, l + 1);
    if (!r) r = MatchStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PATH_NAME|PATH_VARIABLE
  public static boolean PathStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathStatement")) return false;
    if (!nextTokenIs(b, "<path statement>", PATH_NAME, PATH_VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_STATEMENT, "<path statement>");
    r = consumeToken(b, PATH_NAME);
    if (!r) r = consumeToken(b, PATH_VARIABLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PERMISSION
  public static boolean PermissionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PermissionStatement")) return false;
    if (!nextTokenIs(b, PERMISSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PERMISSION);
    exit_section_(b, m, PERMISSION_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // RULES_VERSION EQ VERSIONS DOT_COMMA
  public static boolean RuleVersionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RuleVersionStatement")) return false;
    if (!nextTokenIs(b, RULES_VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, RULES_VERSION, EQ, VERSIONS, DOT_COMMA);
    exit_section_(b, m, RULE_VERSION_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // service SERVICE_NAME LEFT_BRACE (MatchStatement)+ RIGHT_BRACE
  public static boolean ServiceStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ServiceStatement")) return false;
    if (!nextTokenIs(b, SERVICE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SERVICE, SERVICE_NAME, LEFT_BRACE);
    r = r && ServiceStatement_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, SERVICE_STATEMENT, r);
    return r;
  }

  // (MatchStatement)+
  private static boolean ServiceStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ServiceStatement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ServiceStatement_3_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!ServiceStatement_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ServiceStatement_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (MatchStatement)
  private static boolean ServiceStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ServiceStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MatchStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // RuleVersionStatement? ServiceStatement
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, "<property>", RULES_VERSION, SERVICE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_0(b, l + 1);
    r = r && ServiceStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RuleVersionStatement?
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    RuleVersionStatement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // root_item
  static boolean root(PsiBuilder b, int l) {
    return root_item(b, l + 1);
  }

  /* ********************************************************** */
  // !<<eof>> property
  static boolean root_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_item_0(b, l + 1);
    r = r && property(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eof>>
  private static boolean root_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
