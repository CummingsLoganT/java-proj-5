package MeatAndTaters;

import java.util.HashMap;
import java.util.Stack;

public class brackets {

    public static boolean balancedParenthesis (String str) {
        int numUnclosedOpenParens = 0;
        for (int i = 0; i < str.length(); i += 1) {
            if (str.charAt(i) == '(') {
                numUnclosedOpenParens += 1;
            } else if (str.charAt(i) == '(') {
                numUnclosedOpenParens -= 1;
            }

            if (numUnclosedOpenParens < 0) {
                return false;
            }
        }
        return numUnclosedOpenParens == 0;
    }


    public static boolean balancedBrackets (String str) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character , Character> bracketPairs = new HashMap<Character , Character>();
        bracketPairs.put(')' , '(');
        bracketPairs.put(']' , '[');
        bracketPairs.put('}' , '{');
        bracketPairs.put('>' , '<');


        for (int i = 0; i < str.length(); i += 1) {
            if (bracketPairs.containsValue(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else if (bracketPairs.containsKey(str.charAt(i))) {
                if (stack.isEmpty()) {
                    return  false;
                }
                Character mostRecentBracket = stack.pop();
                if (!mostRecentBracket.equals(bracketPairs.get(str.charAt(i)))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {


        String balancedParens = "(1)";
        String tooManyOpenParens = "((1";
        String tooManyOpenParens1 = "(1)(";
        String tooManyClosedParens = "(1))";
        String startClosedParens = ")(";
        String emptyString = "";

        System.out.println("Balanced Paranthesis Testing: TTFFFF");
        System.out.println(balancedParenthesis(balancedParens));
        System.out.println(balancedParenthesis(emptyString));
        System.out.println(balancedParenthesis(tooManyOpenParens));
        System.out.println(balancedParenthesis(tooManyOpenParens1));
        System.out.println(balancedParenthesis(tooManyClosedParens));
        System.out.println(balancedParenthesis(startClosedParens));

        String balancedAngleBrackets = "<<>>";
        String balancedComboBrackets = "<({})>";
        String mismatchedBrackets = "<({)}>";

        System.out.println("Balanced Brackets Testing: TTFFFFTTF");
        System.out.println(balancedBrackets(emptyString));
        System.out.println(balancedBrackets(balancedParens));
        System.out.println(balancedBrackets(tooManyOpenParens));
        System.out.println(balancedBrackets(tooManyOpenParens1));
        System.out.println(balancedBrackets(tooManyClosedParens));
        System.out.println(balancedBrackets(startClosedParens));
        System.out.println(balancedBrackets(balancedAngleBrackets));
        System.out.println(balancedBrackets(balancedComboBrackets));
        System.out.println(balancedBrackets(mismatchedBrackets));


    }

}
