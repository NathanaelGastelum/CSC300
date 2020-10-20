import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a postfix expression:");
        StringBuilder postfix = new StringBuilder(s.nextLine());

        System.out.println("The original postfix expression is: \n" + postfix);
        System.out.println("The value of the expression is: " + evaluatePostfixExpression(postfix));
    }

    public static int evaluatePostfixExpression(StringBuilder postfix) {
        Stack<Integer> stack = new Stack<>();

        postfix.append(')');

        for (int i = 0; !(postfix.charAt(i) == ')'); i++) {
            if (Character.isDigit(postfix.charAt(i))) {
                stack.push(Character.getNumericValue(postfix.charAt(i)));
                printStack(stack);
            }
            else if (isOperator(postfix.charAt(i))) {
                int x = stack.pop();
                printStack(stack);
                int y = stack.pop();
                printStack(stack);

                stack.push(calculate(y, x, postfix.charAt(i)));
                printStack(stack);
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' ||
                c == '/' || c == '^';
    }

    private static int calculate(int x, int y, char operator) {
        switch (operator) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            case '^':
                return (int) Math.pow(x, y);
            default:
                return -1;
        }
    }

    private static void printStack(Stack<Integer> stack) {
        System.out.print(stack.toString() + "\n\n");
    }
}