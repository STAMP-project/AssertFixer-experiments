package datawave.query.jexl.functions;

import datawave.query.jexl.ArithmeticJexlEngines;

import org.apache.commons.jexl2.parser.ASTFunctionNode;

/**
 * Utility for getting the function class associated with a JEXL function.
 */
public class GetFunctionClass {
    public static Class<?> get(ASTFunctionNode node) throws ClassNotFoundException {
        FunctionJexlNodeVisitor fvis = new FunctionJexlNodeVisitor();
        fvis.visit(node, null);
        
        Object mapping = ArithmeticJexlEngines.functions().get(fvis.namespace());
        if (mapping == null) {
            throw new ClassNotFoundException("Mapping for namespace " + fvis.namespace() + " was null!");
        } else if (!(mapping instanceof Class<?>)) {
            throw new ClassNotFoundException("Mapping for namespace " + fvis.namespace() + " was a " + mapping.getClass() + ", not a Class!");
        } else {
            return (Class<?>) mapping;
        }
    }
}
