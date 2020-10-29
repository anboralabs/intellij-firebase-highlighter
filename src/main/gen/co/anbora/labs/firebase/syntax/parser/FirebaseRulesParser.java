// This is a generated file. Not intended for manual editing.
package co.anbora.labs.firebase.syntax.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static co.anbora.labs.firebase.syntax.psi.FirebaseRulesTypes.*;
import static co.anbora.labs.firebase.syntax.parser.FirebaseRulesParserUtil.*;
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
  // ALLOW_KEYWORD PermissionStatement COLON ConditionalStatement DOT_COMMA
  public static boolean AllowStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AllowStatement")) return false;
    if (!nextTokenIs(b, ALLOW_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ALLOW_KEYWORD);
    r = r && PermissionStatement(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && ConditionalStatement(b, l + 1);
    r = r && consumeToken(b, DOT_COMMA);
    exit_section_(b, m, ALLOW_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // EQEQ|NE|OROR|ANDAND|LT|LE|GT|GE|IN_KEYWORD
  public static boolean BooleanOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BooleanOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_OPERATOR, "<boolean operator>");
    r = consumeToken(b, EQEQ);
    if (!r) r = consumeToken(b, NE);
    if (!r) r = consumeToken(b, OROR);
    if (!r) r = consumeToken(b, ANDAND);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, GE);
    if (!r) r = consumeToken(b, IN_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TRUE_KEYWORD|FALSE_KEYWORD
  public static boolean BooleanStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BooleanStatement")) return false;
    if (!nextTokenIs(b, "<boolean statement>", FALSE_KEYWORD, TRUE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_STATEMENT, "<boolean statement>");
    r = consumeToken(b, TRUE_KEYWORD);
    if (!r) r = consumeToken(b, FALSE_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER(DOT IDENTIFIER)?FunctionParameterStatement
  public static boolean CallFunctionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallFunctionStatement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && CallFunctionStatement_1(b, l + 1);
    r = r && FunctionParameterStatement(b, l + 1);
    exit_section_(b, m, CALL_FUNCTION_STATEMENT, r);
    return r;
  }

  // (DOT IDENTIFIER)?
  private static boolean CallFunctionStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallFunctionStatement_1")) return false;
    CallFunctionStatement_1_0(b, l + 1);
    return true;
  }

  // DOT IDENTIFIER
  private static boolean CallFunctionStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallFunctionStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression (BooleanOperator Expression)*
  public static boolean ConditionalExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_EXPRESSION, "<conditional expression>");
    r = Expression(b, l + 1);
    r = r && ConditionalExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (BooleanOperator Expression)*
  private static boolean ConditionalExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ConditionalExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConditionalExpression_1", c)) break;
    }
    return true;
  }

  // BooleanOperator Expression
  private static boolean ConditionalExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BooleanOperator(b, l + 1);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF_KEYWORD ConditionalExpression
  public static boolean ConditionalStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalStatement")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF_KEYWORD);
    r = r && ConditionalExpression(b, l + 1);
    exit_section_(b, m, CONDITIONAL_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // BooleanStatement
  //         | CallFunctionStatement
  //         | ObjectStatement
  //         | LiteralStatement
  //         | NullStatement
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = BooleanStatement(b, l + 1);
    if (!r) r = CallFunctionStatement(b, l + 1);
    if (!r) r = ObjectStatement(b, l + 1);
    if (!r) r = LiteralStatement(b, l + 1);
    if (!r) r = NullStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // LP ParameterStatement? RP
  public static boolean FunctionParameterStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameterStatement")) return false;
    if (!nextTokenIs(b, LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && FunctionParameterStatement_1(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, FUNCTION_PARAMETER_STATEMENT, r);
    return r;
  }

  // ParameterStatement?
  private static boolean FunctionParameterStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameterStatement_1")) return false;
    ParameterStatement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FUNCTION_KEYWORD CallFunctionStatement LEFT_BRACE ReturnStatement RIGHT_BRACE
  public static boolean FunctionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionStatement")) return false;
    if (!nextTokenIs(b, FUNCTION_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION_KEYWORD);
    r = r && CallFunctionStatement(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && ReturnStatement(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, FUNCTION_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // number|string
  public static boolean LiteralStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralStatement")) return false;
    if (!nextTokenIs(b, "<literal statement>", NUMBER, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_STATEMENT, "<literal statement>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MATCH_KEYWORD FullPathStatement LEFT_BRACE comment (AllowStatement|MatchStatement|FunctionStatement)+ RIGHT_BRACE
  public static boolean MatchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchStatement")) return false;
    if (!nextTokenIs(b, MATCH_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH_KEYWORD);
    r = r && FullPathStatement(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && comment(b, l + 1);
    r = r && MatchStatement_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, MATCH_STATEMENT, r);
    return r;
  }

  // (AllowStatement|MatchStatement|FunctionStatement)+
  private static boolean MatchStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchStatement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MatchStatement_4_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!MatchStatement_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MatchStatement_4", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // AllowStatement|MatchStatement|FunctionStatement
  private static boolean MatchStatement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchStatement_4_0")) return false;
    boolean r;
    r = AllowStatement(b, l + 1);
    if (!r) r = MatchStatement(b, l + 1);
    if (!r) r = FunctionStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // NULL_KEYWORD
  public static boolean NullStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NullStatement")) return false;
    if (!nextTokenIs(b, NULL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NULL_KEYWORD);
    exit_section_(b, m, NULL_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER(DOT IDENTIFIER)*
  public static boolean ObjectStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectStatement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && ObjectStatement_1(b, l + 1);
    exit_section_(b, m, OBJECT_STATEMENT, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean ObjectStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectStatement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ObjectStatement_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ObjectStatement_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean ObjectStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression(COMMA Expression)*
  public static boolean ParameterStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_STATEMENT, "<parameter statement>");
    r = Expression(b, l + 1);
    r = r && ParameterStatement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA Expression)*
  private static boolean ParameterStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterStatement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParameterStatement_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterStatement_1", c)) break;
    }
    return true;
  }

  // COMMA Expression
  private static boolean ParameterStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER|PATH_VARIABLE
  public static boolean PathStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathStatement")) return false;
    if (!nextTokenIs(b, "<path statement>", IDENTIFIER, PATH_VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_STATEMENT, "<path statement>");
    r = consumeToken(b, IDENTIFIER);
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
  // RETURN_KEYWORD ConditionalExpression DOT_COMMA
  public static boolean ReturnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement")) return false;
    if (!nextTokenIs(b, RETURN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN_KEYWORD);
    r = r && ConditionalExpression(b, l + 1);
    r = r && consumeToken(b, DOT_COMMA);
    exit_section_(b, m, RETURN_STATEMENT, r);
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
  // SERVICE_KEYWORD SERVICE_NAME LEFT_BRACE (comment MatchStatement)+ RIGHT_BRACE
  public static boolean ServiceStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ServiceStatement")) return false;
    if (!nextTokenIs(b, SERVICE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SERVICE_KEYWORD, SERVICE_NAME, LEFT_BRACE);
    r = r && ServiceStatement_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, SERVICE_STATEMENT, r);
    return r;
  }

  // (comment MatchStatement)+
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

  // comment MatchStatement
  private static boolean ServiceStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ServiceStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comment(b, l + 1);
    r = r && MatchStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LINE_COMMENT*
  static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_COMMENT)) break;
      if (!empty_element_parsed_guard_(b, "comment", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // RuleVersionStatement? ServiceStatement
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, "<property>", RULES_VERSION, SERVICE_KEYWORD)) return false;
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
