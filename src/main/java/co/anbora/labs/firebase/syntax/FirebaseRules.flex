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

WHITE_SPACE=[ \t\n\x0B\f\r]+
PORTTOKEN=(INPORT|EXPORT|OUTPORT)
COMMENT=#.*
NUMBER=[0-9]+(\.[0-9]*)?
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
CHAR=[\n\r\u2028\u2029]
COMPMETA=[a-zA-Z=_\-,0-9]+
SLASH=\/
VAR_PATH_NAME="{"[a-zA-Z_\-,0-9]+[=**]?"}"
FULL_PATH=("/"{PATH_NAME}|"/"{VAR_PATH_NAME})+

SERVICE=service
SERVICE_NAME=(cloud.firestore|firebase.storage)
MATCH=match
ALLOW=allow
RULES_VERSION=rules_version
VERSIONS=('1'|'2')
PERMISSIONS_KEYS=(read|write|get|list|create|update|delete)
PATH_NAME=[a-zA-Z_\-,0-9]+

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return com.intellij.psi.TokenType.WHITE_SPACE; }

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

  {SERVICE}          { return SERVICE; }
  {SERVICE_NAME}     { return SERVICE_NAME; }
  {MATCH}            { return MATCH; }
  {ALLOW}            { return ALLOW; }
  {PERMISSIONS_KEYS} { return PERMISSIONS_KEYS; }
  {RULES_VERSION}    { return RULES_VERSION; }
  {VERSIONS}         { return VERSIONS; }
  {PATH_NAME}        { return PATH_NAME; }
  {SLASH}            { return SLASH; }

  {WHITE_SPACE}      { return WHITE_SPACE; }
  {PORTTOKEN}        { return PORTTOKEN; }
  {COMMENT}          { return COMMENT; }
  {NUMBER}           { return NUMBER; }
  {STRING}           { return STRING; }
  {COMPMETA}         { return COMPMETA; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}