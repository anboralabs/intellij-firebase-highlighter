// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package co.anbora.labs.firebase.lang.core.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes.*;
import com.intellij.psi.TokenType;

%%

%{
  public FirebaseRulesLexer() {
    this(null);
  }
%}

%class FirebaseRulesLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%unicode

%{
    private int commentLevel = 0;
    private int charLength = 0;
    private boolean docComment = false;

    private void startComment() {
        commentLevel = 1;
        yybegin(COMMENT);
    }
%}

%xstate COMMENT TYPE_PENDING

WhiteSpace = [ \n\t\f]+

Number=[0-9]+(\.[0-9]*)?
String=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
Slash=\/
LineComment=("//")[^\r\n]*

ServiceName=(cloud.firestore|firebase.storage)
RulesVersion=rules_version
Versions=('1'|'2')
Identifier=[a-zA-Z_\-0-9]+
PathVariable=[{][a-zA-Z_\-0-9]+(=\*\*)?[}]
PathBuiltIn=[$][(][a-zA-Z_\-0-9]+[a-zA-Z_\.\-0-9]*[)]

%%

<COMMENT> {
    "/*" {
        commentLevel++;
    }
    "*/" {
            if (--commentLevel == 0) {
                yybegin(YYINITIAL);
                return BLOCK_COMMENT;
            }
        }

    <<EOF>> { commentLevel = 0; yybegin(YYINITIAL); return BLOCK_COMMENT; }

    [^] { }
}

<TYPE_PENDING> {
    {WhiteSpace}    { return TokenType.WHITE_SPACE; }
}

<YYINITIAL> {
  {LineComment}     { return LINE_COMMENT; }
  "/*" {
      startComment();
  }

  {PathBuiltIn}      { return PATH_BUILT_IN; }
  {PathVariable}     { return PATH_VARIABLE; }
  "true"             { return TRUE_KEYWORD; }
  "false"            { return FALSE_KEYWORD; }
  "let"              { return LET_KEYWORD; }
  "if"               { return IF_KEYWORD; }
  "null"             { return NULL_KEYWORD; }
  "in"               { return IN_KEYWORD; }
  "is"               { return IS_KEYWORD; }

  "service"          { return SERVICE_KEYWORD; }
  {ServiceName}      { return SERVICE_NAME; }
  "match"            { return MATCH_KEYWORD; }
  "allow"            { return ALLOW_KEYWORD; }
  {RulesVersion}     { return RULES_VERSION; }
  {Versions}         { return VERSIONS; }
  "function"         { return FUNCTION_KEYWORD; }
  "return"           { return RETURN_KEYWORD; }

  /*"exists"           { return EXITS_KEYWORD; }
  "get"              { return GET_KEYWORD; }
  "read"             { return READ_KEYWORD; }
  "write"            { return WRITE_KEYWORD; }
  "list"             { return LIST_KEYWORD; }
  "create"           { return CREATE_KEYWORD; }
  "update"           { return UPDATE_KEYWORD; }
  "delete"           { return DELETE_KEYWORD; }*/

  "=="               { return EQEQ; }
  "!="               { return NE; }
  "||"               { return OROR; }
  "&&"               { return ANDAND; }
  "<"                { return LT; }
  "<="               { return LE; }
  ">"                { return GT; }
  ">="               { return GE; }
  "!"                { return NEGATE; }
  "?"                { return Q_MARK; }

  "+"                { return PLUS_OP; }
  "-"                { return MINUS_OP; }
  "*"                { return MULT_OP; }

  "("                { return LP; }
  ")"                { return RP; }
  "["                { return LB; }
  "]"                { return RB; }
  "{"                { return LEFT_BRACE; }
  "}"                { return RIGHT_BRACE; }
  "->"               { return OP; }
  ":"                { return COLON; }
  ","                { return COMMA; }
  "="                { return EQ; }
  "."                { return DOT; }
  ";"                { return DOT_COMMA; }

  {Number}           { return NUMBER; }
  {String}           { return STRING; }
  {Identifier}       { return IDENTIFIER; }
  {Slash}            { return SLASH; }

  {WhiteSpace}       { return com.intellij.psi.TokenType.WHITE_SPACE; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
