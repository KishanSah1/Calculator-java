package calculator;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Calculator");

        Scanner in = new Scanner(System.in);
        System.out.println("Enter value 1");
        int var1 = in.nextInt();
        System.out.println("Enter value 2");
        int var2 = in.nextInt();

        System.out.println("Enter the Operator");
        char op = in.next().charAt(0);

        int result=0;
        switch (op) {
            case '+':
                result = var1 + var2;
                break;

            case '-':
                result = var1 - var2;
                break;
            case '*':
                result = var1 * var2;
                break;

            case '/':
                if (var2 != 0) {
                    result = var1 / var2;
                } else {
                    System.out.println("Division by zero is not allowed");
                    return;
                }
                break;
        }

        System.out.println("Result" + result);

        in.close();


    }
}