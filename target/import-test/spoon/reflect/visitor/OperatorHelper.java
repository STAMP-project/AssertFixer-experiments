/**
 * Copyright (C) 2006-2017 INRIA and contributors
 * Spoon - http://spoon.gforge.inria.fr/
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package spoon.reflect.visitor;


import spoon.SpoonException;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.UnaryOperatorKind;


/**
 * Computes source code representation of the operator
 */
class OperatorHelper {
    private OperatorHelper() {
    }

    public static boolean isPrefixOperator(UnaryOperatorKind o) {
        return (OperatorHelper.isSufixOperator(o)) == false;
    }

    public static boolean isSufixOperator(UnaryOperatorKind o) {
        return o.name().startsWith("POST");
    }

    /**
     *
     *
     * @return java source code representation of a pre or post unary operator.
     */
    public static String getOperatorText(UnaryOperatorKind o) {
        switch (o) {
            case POS :
                return "+";
            case NEG :
                return "-";
            case NOT :
                return "!";
            case COMPL :
                return "~";
            case PREINC :
                return "++";
            case PREDEC :
                return "--";
            case POSTINC :
                return "++";
            case POSTDEC :
                return "--";
            default :
                throw new SpoonException(("Unsupported operator " + (o.name())));
        }
    }

    /**
     *
     *
     * @return java source code representation of a binary operator.
     */
    public static String getOperatorText(BinaryOperatorKind o) {
        switch (o) {
            case OR :
                return "||";
            case AND :
                return "&&";
            case BITOR :
                return "|";
            case BITXOR :
                return "^";
            case BITAND :
                return "&";
            case EQ :
                return "==";
            case NE :
                return "!=";
            case LT :
                return "<";
            case GT :
                return ">";
            case LE :
                return "<=";
            case GE :
                return ">=";
            case SL :
                return "<<";
            case SR :
                return ">>";
            case USR :
                return ">>>";
            case PLUS :
                return "+";
            case MINUS :
                return "-";
            case MUL :
                return "*";
            case DIV :
                return "/";
            case MOD :
                return "%";
            case INSTANCEOF :
                return "instanceof";
            default :
                throw new SpoonException(("Unsupported operator " + (o.name())));
        }
    }
}

