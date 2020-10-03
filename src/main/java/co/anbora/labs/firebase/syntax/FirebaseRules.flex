// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package co.anbora.labs.firebase.syntax;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import co.anbora.labs.firebase.syntax.psi.FirebaseRulesTypes;
import com.intellij.psi.TokenType;

%%

%class FirebaseRulesLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

Newline = (\n|\r|\r\n)
Space = " "
WhiteSpace = {Space}+
Tab = \t
LineComment = ("--")[^\r\n]*
IdentifierChar = [[:letter:][:digit:]_]
HexChar = [[:digit:]A-Fa-f]
LowerCaseIdentifier = [:lowercase:]{IdentifierChar}+
UpperCaseIdentifier = [:uppercase:]{IdentifierChar}+
NumberLiteral = ("-")?[:digit:]+(\.[:digit:]+)?(e"-"?[:digit:]+)?
HexLiteral = 0x{HexChar}+
Operator = ("!"|"$"|"^"|"|"|"*"|"/"|"?"|"+"|"~"|"."|-|=|@|#|%|&|<|>|:|€|¥|¢|£|¤)+

ValidEscapeSequence = \\(u\{{HexChar}{4,6}\}|[nrt\"'\\])
InvalidEscapeSequence = \\(u\{[^}]*\}|[^nrt\"'\\])
ThreeQuotes = \"\"\"

Slash=[/]
ServiceName = (cloud.firestore|firebase.storage)

%state WAITING_VALUE

%%

<YYINITIAL> {
    "service"                   { return FirebaseRulesTypes.SERVICE; }
    "match"                     { return FirebaseRulesTypes.MATCH; }
    "allow"                     { return FirebaseRulesTypes.ALLOW; }
    /*"if"                        { return FirebaseRulesTypes.IF; }
    "read"                      { return FirebaseRulesTypes.READ; }
    "write"                     { return FirebaseRulesTypes.WRITE; }
    "get"                       { return FirebaseRulesTypes.GET; }
    "list"                      { return FirebaseRulesTypes.LIST; }
    "create"                    { return FirebaseRulesTypes.CREATE; }
    "update"                    { return FirebaseRulesTypes.UPDATE; }
    "delete"                    { return FirebaseRulesTypes.DELETE; }
    "("                         { return FirebaseRulesTypes.LEFT_PARENTHESIS; }
    ")"                         { return FirebaseRulesTypes.RIGHT_PARENTHESIS; }
    "["                         { return FirebaseRulesTypes.LEFT_SQUARE_BRACKET; }
    "]"                         { return FirebaseRulesTypes.RIGHT_SQUARE_BRACKET; }
    "{"                         { return FirebaseRulesTypes.LEFT_BRACE; }
    "}"                         { return FirebaseRulesTypes.RIGHT_BRACE; }
    ".."                        { return FirebaseRulesTypes.DOUBLE_DOT; }
    ","                         { return FirebaseRulesTypes.COMMA; }
    "="                         { return FirebaseRulesTypes.EQ; }
    "->"                        { return FirebaseRulesTypes.ARROW; }
    ":"                         { return FirebaseRulesTypes.COLON; }
    "|"                         { return FirebaseRulesTypes.PIPE; }
    "\\"                        { return FirebaseRulesTypes.BACKSLASH; }
    "_"                         { return FirebaseRulesTypes.UNDERSCORE; }
    "."                         { return FirebaseRulesTypes.DOT; }
    {LowerCaseIdentifier}       { return FirebaseRulesTypes.LOWER_CASE_IDENTIFIER; }*/
}

. {
    return TokenType.BAD_CHARACTER;
}
