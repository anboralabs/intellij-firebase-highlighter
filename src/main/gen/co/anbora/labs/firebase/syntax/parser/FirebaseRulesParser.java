// This is a generated file. Not intended for manual editing.
package co.anbora.labs.firebase.syntax.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static co.anbora.labs.firebase.syntax.psi.FirebaseRulesTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
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
    return AllowStatement(b, l + 1);
  }

  /* ********************************************************** */
  // ALLOW
  static boolean AllowStatement(PsiBuilder b, int l) {
    return consumeToken(b, ALLOW);
  }

  /* ********************************************************** */
  // MATCH
  public static boolean MatchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchStatement")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH);
    exit_section_(b, m, MATCH_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // SERVICE
  public static boolean ServiceStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ServiceStatement")) return false;
    if (!nextTokenIs(b, SERVICE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SERVICE);
    exit_section_(b, m, SERVICE_STATEMENT, r);
    return r;
  }

}
