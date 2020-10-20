import java.util.Scanner;
import java.util.Stack;
public class InfixToPostfixConverter
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an infix expression: ");
        StringBuilder infix = new StringBuilder(s.nextLine());

        System.out.printf("\nThe original infix expression is: \n%s \n", infix);
        StringBuilder postfix = convertToPostfix(infix);
        System.out.printf("The expression in postfix notation is: \n%s \n", postfix);
    }

    public static StringBuilder convertToPostfix(StringBuilder infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();

        stack.push('(');
        infix.append(')');

        for (int i = 0; !stack.isEmpty(); i++) {
            if (Character.isDigit(infix.charAt(i))) {
                temp.append(infix.charAt(i)).append(" ");
            }
            else if (infix.charAt(i) == '(') {
                stack.push('(');
            }
            else if (isOperator(infix.charAt(i))) {
                while (isOperator(stack.peek()) && precedence(infix.charAt(i), stack.peek())) {
                    temp.append(stack.pop()).append(" ");
                }

                stack.push(infix.charAt(i));
            }
            else if (infix.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    temp.append(stack.pop()).append(" ");
                }

                stack.pop();
            }
        }

        return temp;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' ||
                c == '/' || c == '%' || c == '^';
    }

    private static boolean precedence(char operator1, char operator2) {
        if (operator1 == '^') {
            return false;
        }
        else if (operator2 == '^') {
            return true;
        }
        else if (operator1 == '*' || operator1 == '/' || operator1 == '%') {
            return false;
        }
        else return operator2 == '*' || operator2 == '/' || operator2 == '%';
    }
}