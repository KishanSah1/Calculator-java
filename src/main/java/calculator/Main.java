package calculator;
import java.util.Scanner;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int evaluate(String expression){
        char[] expressionArray = expression.toCharArray();

        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for(int i=0; i<expressionArray.length; i++){

            if(expressionArray[i]==' ') continue;

            if(Character.isDigit(expressionArray[i])){
                StringBuffer sbuf = new StringBuffer();
                while (i < expressionArray.length && Character.isDigit(expressionArray[i]))
                    sbuf.append(expressionArray[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
                i--;
            } else if (expressionArray[i] == '(') {
                ops.push(expressionArray[i]);
            } else if (expressionArray[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            } else if (expressionArray[i] == '+' || expressionArray[i] == '-' || expressionArray[i] == '*' || expressionArray[i] == '/') {
                while (!ops.empty() && checkPrecedence(expressionArray[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(expressionArray[i]);
            }



        }

    }

    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public static boolean checkPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }



    public static void main(String[] args) {

    }
}