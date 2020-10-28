// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package co.anbora.labs.firebase.syntax;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static co.anbora.labs.firebase.syntax.psi.FirebaseRulesTypes.*;
import com.intellij.psi.TokenType;

%%

%{
  public FirebaseRulesLexer() {
    this((java.io.Reader)null);
  }
%}

%class FirebaseRulesLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

NUMBER=[0-9]+(\.[0-9]*)?
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
SLASH=\/
LINE_COMMENT=("//")[^\r\n]*

SERVICE_NAME=(cloud.firestore|firebase.storage)
RULES_VERSION=rules_version
VERSIONS=('1'|'2')
PERMISSIONS_KEYS=(read|write|get|list|create|update|delete)
IDENTIFIER=[a-zA-Z_\-0-9]+
PATH_VARIABLE=[{][a-zA-Z_\-0-9]+(=\*\*)?[}]
PERMISSION={PERMISSIONS_KEYS}([,]({WHITE_SPACE})?{PERMISSIONS_KEYS})*

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return com.intellij.psi.TokenType.WHITE_SPACE; }

  {PERMISSION}       { return PERMISSION; }
  {PATH_VARIABLE}    { return PATH_VARIABLE; }
  "true"             { return TRUE_KEYWORD; }
  "false"            { return FALSE_KEYWORD; }
  "if"               { return IF_KEYWORD; }
  "null"             { return NULL_KEYWORD; }
  "in"               { return IN_KEYWORD; }

  "service"          { return SERVICE_KEYWORD; }
  {SERVICE_NAME}     { return SERVICE_NAME; }
  "match"            { return MATCH_KEYWORD; }
  "allow"            { return ALLOW_KEYWORD; }
  {RULES_VERSION}    { return RULES_VERSION; }
  {VERSIONS}         { return VERSIONS; }
  "function"         { return FUNCTION_KEYWORD; }
  "return"           { return RETURN_KEYWORD; }

  {LINE_COMMENT}     { return LINE_COMMENT; }

  "=="               { return EQEQ; }
  "!="               { return NE; }
  "||"               { return OROR; }
  "&&"               { return ANDAND; }
  "<"                { return LT; }
  "<="               { return LE; }
  ">"                { return GT; }
  ">="               { return GE; }

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

  {NUMBER}           { return NUMBER; }
  {STRING}           { return STRING; }
  {IDENTIFIER}       { return IDENTIFIER; }
  {SLASH}            { return SLASH; }

  {WHITE_SPACE}      { return WHITE_SPACE; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}