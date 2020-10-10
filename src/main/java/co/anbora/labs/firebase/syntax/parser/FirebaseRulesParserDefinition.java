package co.anbora.labs.firebase.syntax.parser;

import co.anbora.labs.firebase.syntax.FirebaseRulesAdapter;
import co.anbora.labs.firebase.syntax.FirebaseRulesLanguage;
import co.anbora.labs.firebase.syntax.psi.FirebaseRulesFile;
import co.anbora.labs.firebase.syntax.psi.FirebaseRulesTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class FirebaseRulesParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(FirebaseRulesLanguage.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new FirebaseRulesAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new FirebaseRulesParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return FirebaseRulesTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new FirebaseRulesFile(viewProvider);
    }
}
