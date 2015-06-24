package com.jyril;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jyril81 on 22.06.2015.
 */
public class Parenthesis {


    public static void main(String[] args) {
        System.out.println();
    }

    public static void solve(String exp) {
        String[] split = exp.split(" ");
        List<String> list = Arrays.asList(split);
        System.out.println("Input" + list);
        placeParenthesis(list);

    }

    /**
     * Iteratively loop and attempt place parenthesis to all possible places
     *
     * @param list
     */
    private static void placeParenthesis(List<String> list) {
        for (int openingParBeforeIndex = 0; openingParBeforeIndex < list.size() - 2; openingParBeforeIndex = openingParBeforeIndex + 2) {
            for (int closingParAfterIndex = openingParBeforeIndex + 2; closingParAfterIndex < list.size(); closingParAfterIndex = closingParAfterIndex + 2) {
                if (openingParBeforeIndex == 0 && closingParAfterIndex == list.size() - 1) {
                    //skip whole exp
                    continue;
                }
                List<String> preTokens = list.subList(0, openingParBeforeIndex);
                List<String> expInpar = list.subList(openingParBeforeIndex, closingParAfterIndex + 1);
                List<String> postTokens = list.subList(closingParAfterIndex + 1, list.size());
                boolean result = evaluate(preTokens, expInpar, postTokens);
                if (result) {
                    printMatch(preTokens, expInpar, postTokens);
                }
            }
        }
    }


    /**
     * Evaluates whole expression by evaluating it in 3 parts (before parnethesis, in parenthesis and after parenthesis)
     *
     * @param preTokens     is in form "preexp op"
     * @param inParenthesis
     * @param postTokens    is in form "op postexp"
     * @return
     */
    private static boolean evaluate(List<String> preTokens, List<String> inParenthesis, List<String> postTokens) {
        Boolean preExpValue = null;
        Boolean postExpValue = null;
        String preOp = null;
        String postOp = null;

        if (!preTokens.isEmpty()) {
            preOp = preTokens.get(preTokens.size() - 1);
            preExpValue = evalExp(preTokens.subList(0, preTokens.size() - 1));
        }
        if (!postTokens.isEmpty()) {
            postOp = postTokens.get(0);
            postExpValue = evalExp(postTokens.subList(1, postTokens.size()));
        }

        Boolean inParenthesisValue = evalExp(inParenthesis);

        Boolean result = inParenthesisValue;

        if (preExpValue != null) {
            result = op(preExpValue, preOp, inParenthesisValue);
        }

        if (postExpValue != null) {
            result = op(result, postOp, postExpValue);
        }

        return result;
    }

    /**
     * Applies given on on exp1 and exp2
     *
     * @param exp1
     * @param op
     * @param exp2
     * @return
     */
    private static Boolean op(Boolean exp1, String op, Boolean exp2) {
        Boolean result = null;
        if ("and".equals(op)) {
            result = exp1 && exp2;
        } else if ("or".equals(op)) {
            result = exp1 || exp2;
        } else if ("xor".equals(op)) {
            result = exp1 ^ exp2;
        }
        return result;
    }

    /**
     * Eval given exp to boolean value
     * Assumes exp is in correct form to be evaluated
     * Uses recursion
     *
     * @param strings
     * @return
     */
    private static Boolean evalExp(List<String> strings) {
        Boolean first = Boolean.valueOf(strings.get(0));
        if (strings.size() == 1) {
            return first;
        }
        return op(first, strings.get(1), evalExp(strings.subList(2, strings.size())));
    }

    /**
     * Print expression with parenethesis
     *
     * @param preTokens
     * @param expInpar
     * @param postTokens
     */
    private static void printMatch(List<String> preTokens, List<String> expInpar, List<String> postTokens) {
        for (String preToken : preTokens) {
            System.out.print(preToken + " ");
        }
        System.out.print("(");

        for (int i = 0; i < expInpar.size(); i++) {
            //avoid space before closing parenthesis
            if (i == expInpar.size() - 1) {
                System.out.print(expInpar.get(i));
            } else {
                System.out.print(expInpar.get(i) + " ");
            }
        }

        System.out.print(")");
        for (String postToken : postTokens) {
            System.out.print(" " + postToken);
        }

        System.out.println();
    }
}
