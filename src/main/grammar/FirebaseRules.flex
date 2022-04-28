// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package co.anbora.labs.firebase.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static co.anbora.labs.firebase.lang.core.psi.FireRulesTypes.*;
import static co.anbora.labs.firebase.lang.FirebaseParserDefinition.*;

%%

%{
    /**
        * Dedicated storage for starting position of some previously successful
        * match
    */
    private int zzPostponedMarkedPos = -1;

    /**
        * Dedicated nested-comment level counter
    */
    private int zzNestedCommentLevel = 0;
%}

%{
  public FirebaseRulesLexer() {
    this(null);
  }

  IElementType imbueBlockComment() {
      assert(zzNestedCommentLevel == 0);
      yybegin(YYINITIAL);

      zzStartRead = zzPostponedMarkedPos;
      zzPostponedMarkedPos = -1;

      return BLOCK_COMMENT;
  }
%}

%public
%class FirebaseRulesLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

%s IN_BLOCK_COMMENT

///////////////////////////////////////////////////////////////////////////////////////////////////
// Whitespaces
///////////////////////////////////////////////////////////////////////////////////////////////////
EOL_WS           = \n | \r | \r\n
LINE_WS          = [\ \t]
WHITE_SPACE_CHAR = {EOL_WS} | {LINE_WS}
WHITE_SPACE      = {WHITE_SPACE_CHAR}+

///////////////////////////////////////////////////////////////////////////////////////////////////
// Comments
///////////////////////////////////////////////////////////////////////////////////////////////////
EOL_DOC_LINE  = {LINE_WS}*("///".*)
OUTER_EOL_DOC = ({EOL_DOC_LINE}{EOL_WS})*{EOL_DOC_LINE}

///////////////////////////////////////////////////////////////////////////////////////////////////
// Literals
///////////////////////////////////////////////////////////////////////////////////////////////////
BOOL_LITERAL=(true)|(false)
NUMBER_LITERAL=[0-9]+(\.[0-9]*)?
PATH_VARIABLE_LITERAL=\{{IDENTIFIER}(\=\*\*)?\}
PATH_BUILT_IN_LITERAL=\$\({IDENTIFIER}(\.{IDENTIFIER})*\)
STRING_LITERAL=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")

SERVICE_NAME=(cloud.firestore|firebase.storage)

IDENTIFIER=[a-zA-Z_\-0-9]+

/*ServiceName=(cloud.firestore|firebase.storage)
RulesVersion=rules_version
Versions=('1'|'2')
Identifier=[a-zA-Z_\-0-9]+
PathVariable=[{][a-zA-Z_\-0-9]+(=\*\*)?[}]
PathBuiltIn=[$][(][a-zA-Z_\-0-9]+[a-zA-Z_\.\-0-9]*[)]*/

%%

<YYINITIAL> {
      {WHITE_SPACE}        { return WHITE_SPACE; }
      {OUTER_EOL_DOC}                 { return EOL_DOC_COMMENT; }
      "//" .*              { return EOL_COMMENT; }
      "/*"                 {
          yybegin(IN_BLOCK_COMMENT); yypushback(2);
       }
}

<YYINITIAL> {
    // operators
    "{"        { return L_BRACE; }
    "}"        { return R_BRACE; }

    "["        { return L_BRACK; }
    "]"        { return R_BRACK; }
    "("        { return L_PAREN; }
    ")"        { return R_PAREN; }
    "::"       { return COLON_COLON; }
    ":"        { return COLON; }
    ";"        { return SEMICOLON; }
    ","        { return COMMA; }
    "."        { return DOT; }
    "="        { return EQ; }
    "=="       { return EQ_EQ; }
    "!="       { return NOT_EQ; }

    "!"        { return EXCL; }
    "+"        { return PLUS; }
    "-"        { return MINUS; }
    "*"        { return MUL; }
    "/"        { return DIV; }
    "%"        { return MODULO; }
    "^"        { return XOR; }

    "<"        { return LT; }
    ">"        { return GT; }
    "&"        { return AND; }
    "|"        { return OR; }
    "@"        { return AT; }
    "#"        { return HASH; }
    "?"        { return Q_MARK; }

    // keywords
    "let"              { return LET; }
    "if"               { return IF; }
    "in"               { return IN; }
    "is"               { return IS; }
    "null"             { return NULL; }
    "service"          { return SERVICE; }
    "match"            { return MATCH; }
    "allow"            { return ALLOW; }
    "function"         { return FUNCTION; }
    "return"           { return RETURN; }

    {SERVICE_NAME}             { return SERVICE_NAME; }
    {BOOL_LITERAL}             { return BOOL_LITERAL; }
    {NUMBER_LITERAL}           { return NUMBER_LITERAL; }
    {STRING_LITERAL}           { return STRING_LITERAL; }
    {PATH_VARIABLE_LITERAL}    { return PATH_VARIABLE_LITERAL; }
    {PATH_BUILT_IN_LITERAL}    { return PATH_BUILT_IN_LITERAL; }
    {IDENTIFIER}               { return IDENTIFIER; }
}

<IN_BLOCK_COMMENT> {
  "/*"    {
          if (zzNestedCommentLevel++ == 0)
              zzPostponedMarkedPos = zzStartRead;
      }
  "*/"    {
          if (--zzNestedCommentLevel == 0)
              return imbueBlockComment();
      }
  <<EOF>> {
          zzNestedCommentLevel = 0; return imbueBlockComment();
 }
  [^]     { }
}

[^] { return BAD_CHARACTER; }
