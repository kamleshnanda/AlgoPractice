import java.util.Stack;

public class StackProblems {
    public static void main(String[] args) {
        stackProblem1();
        stackProblem2();
        stackProblem3();
    }

    /**
     * Find missing parenthesis in a given expression – 2 * ( 3 + 5(sasdfasdfasd)
     */
    private static void stackProblem1() {
        String expresssion = "2 * ( 3 + 5(sasdfasdfasd)";
        findMissingParenthesis(expresssion);
        expresssion = "())2 * ( 3 + 5(sasdfasdfasd)";
        findMissingParenthesis(expresssion);
    }

    private static void findMissingParenthesis(String expresssion) {
        Stack<Character> parenthesisStack = new Stack<Character>();
        System.out.println("Finding missing parenthesis in " + expresssion);
        for (char var : expresssion.toCharArray()) {
            if (var == '(') {
                parenthesisStack.push(var);
            } else if (var == ')') {
                if (!parenthesisStack.isEmpty() && parenthesisStack.peek() == '(') {
                    parenthesisStack.pop();
                } else {
                    parenthesisStack.push(var);
                }
            }
        }
        System.out.print("Missing parenthesis: ");
        for (char var : parenthesisStack) {
            if (var == '(') {
                System.out.print(") ");
            } else {
                System.out.print("( ");
            }
        }
        System.out.println();
    }

    /**
     * Evaluate an expression given only single digits and only 2 operators * and +.
     */
    private static void stackProblem2() {
        String expression = "2*3+4*5";
        int result = evaluateSingleDigitExpressions(expression);
        if (result == 26) {
            System.out.println("Result of expression " + expression + " is " + result);
        } else {
            System.out.println("Incorrect evaluation of expression " + expression + " with result " + result);
        }

        expression = "3*2+4+5*5+3";
        result = evaluateSingleDigitExpressions(expression);
        if (result == 38) {
            System.out.println("Result of expression " + expression + " is " + result);
        } else {
            System.out.println("Incorrect evaluation of expression " + expression + " with result " + result);
        }

    }

    /**
     * Currently the method does not check for invalid expressions and out of bounds
     * in case the expression ends with operator
     */
    private static int evaluateSingleDigitExpressions(String expression) {
        Stack<Integer> resultStack = new Stack<Integer>();
        char[] charArray = expression.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char var = charArray[i];
            // Test if its number by comparing with ascii value
            if (var - '0' >= 0 && var - '0' <= 9) {
                resultStack.push(var - '0');
            } else if (var == '*') {
                int value1 = resultStack.pop();
                int value2 = charArray[++i] - '0';
                resultStack.push(value1 * value2);
            } else if (var == '+') {
                // Push the next number into the stack
                resultStack.push(charArray[++i] - '0');
            }
        }
        int result = 0;
        for (Integer var : resultStack) {
            result += var;
        }
        return result;
    }

    /**
     * Reverse a stack and put the reversed value back in the same stack. You can
     * use only one other stack and a temp variable.
     */
    private static void stackProblem3() {
        Stack<Integer> firstStack = prepareStack();
        System.out.println("Input Stack: " + firstStack.toString());
        firstStack = reverseStack(firstStack);
        System.out.println("Reverse Stack: " + firstStack.toString());
    }

    private static Stack<Integer> reverseStack(Stack<Integer> firstStack) {
        Stack<Integer> reverseStack = new Stack<Integer>();
        while (!firstStack.isEmpty()) {
            reverseStack.push(firstStack.pop());
        }
        return reverseStack;
    }

    private static Stack<Integer> prepareStack() {
        Stack<Integer> dataStack = new Stack<Integer>();
        dataStack.push(5);
        dataStack.push(4);
        dataStack.push(3);
        dataStack.push(2);
        dataStack.push(1);
        dataStack.push(0);
        dataStack.push(-1);

        return dataStack;
    }
}