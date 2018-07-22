package spoon.reflect.visitor.printer.change;

import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.DefaultJavaPrettyPrinter;

/**
 * Knows how to print modified {@link CtElement} by the way that origin formatting is kept as much as possible.
 * There are two streams of source fragments
 * 1) list of origin source fragments
 * 2) stream of tokens produced by {@link DefaultJavaPrettyPrinter} in spaces between printing of child {@link CtElement}s
 *
 * Note: some fragments are optional and some are mandatory. For example:
 * &lt;T&gt; void method(T p);
 * and after remove of type parameter and method parameter....
 * void method();
 * The type parameter bracketes were removed, while parameter brackets are kept.
 * Only DJPP knows whether it has to be displayed or not. So algorithm is like this:
 * <ul>
 * <li> print origin source token only after this token is printed by DJPP
 * <li> if DJPP doesn't prints some token then the same token must be ignored in origin source code too
 * </ul>
 *
 * Handling of spaces before and after tokens:
 * <ul>
 * <li> spaces belong to both surrounding elements. So they are printed only if both elements are printed
 * <li> if the elements are moved, then spaces are moved together with the follow up element
 * <li> if the elements E1 and E2 are separated by sequence of E1, Spaces1, Separator, Spaces2, E2
 * then Spaces1 belongs to E1 and Spaces2 belongs to element E2.
 * </ul>
 */
class SourceFragmentContextNormal extends AbstractSourceFragmentContext {
	private final SourceFragment rootFragment;

	private CtElement element;

	/**
	 * @param mutableTokenWriter {@link MutableTokenWriter}, which is used for printing
	 * @param element the {@link CtElement} which is printed
	 * @param rootFragment the {@link SourceFragment}, which represents whole elements. E.g. whole type or method
	 * @param changedRoles the set of roles which are modified in the `element`
	 */
	SourceFragmentContextNormal(MutableTokenWriter mutableTokenWriter, CtElement element, SourceFragment rootFragment, ChangeResolver changeResolver) {
		super(mutableTokenWriter, changeResolver, rootFragment.getGroupedChildrenFragments());
		this.element = element;
		this.rootFragment = rootFragment;
	}

	@Override
	public boolean matchesPrinterEvent(PrinterEvent event) {
		return true;
	}


	@Override
	public void onFinished() {
		//we are at the end of this element. Printer just tries to print something out of this context.
		if (mutableTokenWriter.isMuted() == false) {
			//print fragment suffix
			printSpaces(childFragments.size());
		}
	}
}
