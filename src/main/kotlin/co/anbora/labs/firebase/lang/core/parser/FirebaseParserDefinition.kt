package co.anbora.labs.firebase.lang.core.parser

import co.anbora.labs.firebase.lang.FirebaseRulesLanguage
import co.anbora.labs.firebase.lang.core.lexer.FirebaseLexer
import co.anbora.labs.firebase.lang.core.FIREBASE_COMMENTS
import co.anbora.labs.firebase.lang.core.psi.FirebaseFile
import co.anbora.labs.firebase.lang.core.psi.FirebaseRulesTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class FirebaseParserDefinition: ParserDefinition {

    private val type = IFileElementType(FirebaseRulesLanguage)

    override fun createLexer(project: Project?): Lexer = FirebaseLexer()

    override fun createParser(project: Project?): PsiParser = FirebaseRulesParser()

    override fun getFileNodeType(): IFileElementType = type

    override fun getCommentTokens(): TokenSet = FIREBASE_COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode?): PsiElement = FirebaseRulesTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = FirebaseFile(viewProvider)
}
