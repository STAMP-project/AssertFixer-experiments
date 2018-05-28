// Generated from net/runelite/cache/script/assembler/rs2asm.g4 by ANTLR 4.6
package net.runelite.cache.script.assembler;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class rs2asmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NEWLINE=8, INT=9, 
		QSTRING=10, INSTRUCTION=11, COMMENT=12, WS=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "NEWLINE", "INT", 
		"QSTRING", "INSTRUCTION", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.id '", "'.int_stack_count '", "'.string_stack_count '", "'.int_var_count '", 
		"'.string_var_count '", "'LABEL'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "NEWLINE", "INT", "QSTRING", 
		"INSTRUCTION", "COMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public rs2asmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "rs2asm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17\u00a1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\6\tv\n\t\r\t\16\tw\3\n\5\n{\n\n\3"+
		"\n\6\n~\n\n\r\n\16\n\177\3\13\3\13\3\13\3\13\7\13\u0086\n\13\f\13\16\13"+
		"\u0089\13\13\3\13\3\13\3\f\6\f\u008e\n\f\r\f\16\f\u008f\3\r\3\r\7\r\u0094"+
		"\n\r\f\r\16\r\u0097\13\r\3\r\3\r\3\16\6\16\u009c\n\16\r\16\16\16\u009d"+
		"\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\3\2\b\4\2\f\f\17\17\3\2\62;\6\2\f\f\17\17$$^^\4\2$$^^\5\2\62"+
		";aac|\4\2\13\13\"\"\u00a8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\"\3"+
		"\2\2\2\7\64\3\2\2\2\tI\3\2\2\2\13Y\3\2\2\2\rl\3\2\2\2\17r\3\2\2\2\21u"+
		"\3\2\2\2\23z\3\2\2\2\25\u0081\3\2\2\2\27\u008d\3\2\2\2\31\u0091\3\2\2"+
		"\2\33\u009b\3\2\2\2\35\36\7\60\2\2\36\37\7k\2\2\37 \7f\2\2 !\7\"\2\2!"+
		"\4\3\2\2\2\"#\7\60\2\2#$\7k\2\2$%\7p\2\2%&\7v\2\2&\'\7a\2\2\'(\7u\2\2"+
		"()\7v\2\2)*\7c\2\2*+\7e\2\2+,\7m\2\2,-\7a\2\2-.\7e\2\2./\7q\2\2/\60\7"+
		"w\2\2\60\61\7p\2\2\61\62\7v\2\2\62\63\7\"\2\2\63\6\3\2\2\2\64\65\7\60"+
		"\2\2\65\66\7u\2\2\66\67\7v\2\2\678\7t\2\289\7k\2\29:\7p\2\2:;\7i\2\2;"+
		"<\7a\2\2<=\7u\2\2=>\7v\2\2>?\7c\2\2?@\7e\2\2@A\7m\2\2AB\7a\2\2BC\7e\2"+
		"\2CD\7q\2\2DE\7w\2\2EF\7p\2\2FG\7v\2\2GH\7\"\2\2H\b\3\2\2\2IJ\7\60\2\2"+
		"JK\7k\2\2KL\7p\2\2LM\7v\2\2MN\7a\2\2NO\7x\2\2OP\7c\2\2PQ\7t\2\2QR\7a\2"+
		"\2RS\7e\2\2ST\7q\2\2TU\7w\2\2UV\7p\2\2VW\7v\2\2WX\7\"\2\2X\n\3\2\2\2Y"+
		"Z\7\60\2\2Z[\7u\2\2[\\\7v\2\2\\]\7t\2\2]^\7k\2\2^_\7p\2\2_`\7i\2\2`a\7"+
		"a\2\2ab\7x\2\2bc\7c\2\2cd\7t\2\2de\7a\2\2ef\7e\2\2fg\7q\2\2gh\7w\2\2h"+
		"i\7p\2\2ij\7v\2\2jk\7\"\2\2k\f\3\2\2\2lm\7N\2\2mn\7C\2\2no\7D\2\2op\7"+
		"G\2\2pq\7N\2\2q\16\3\2\2\2rs\7<\2\2s\20\3\2\2\2tv\t\2\2\2ut\3\2\2\2vw"+
		"\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\22\3\2\2\2y{\7/\2\2zy\3\2\2\2z{\3\2\2\2"+
		"{}\3\2\2\2|~\t\3\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2"+
		"\2\2\u0080\24\3\2\2\2\u0081\u0087\7$\2\2\u0082\u0086\n\4\2\2\u0083\u0084"+
		"\7^\2\2\u0084\u0086\t\5\2\2\u0085\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7$\2\2\u008b\26\3\2\2\2\u008c\u008e"+
		"\t\6\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\30\3\2\2\2\u0091\u0095\7=\2\2\u0092\u0094\n\2\2\2"+
		"\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\b\r\2\2\u0099"+
		"\32\3\2\2\2\u009a\u009c\t\7\2\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2"+
		"\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0"+
		"\b\16\2\2\u00a0\34\3\2\2\2\13\2wz\177\u0085\u0087\u008f\u0095\u009d\3"+
		"\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}