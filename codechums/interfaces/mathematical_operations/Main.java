package interfaces.mathematical_operations;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Hey there, start typing your Java code here...
        Scanner sc = new Scanner(System.in);
        double first, second;
        char op;
        Operation someOperation;
        System.out.print("Enter the first number: ");
        first = sc.nextDouble();
        System.out.print("Enter the second number: ");
        second = sc.nextDouble();
        System.out.print("Choose an operator (+ - * /): ");
        op = sc.next().charAt(0);
        
        switch(op){
            case '+':
                someOperation = new Addition(first, second);
                Tester.test(someOperation);
            break;
            
            case '-':
                someOperation = new Subtraction(first, second);
                Tester.test(someOperation);
            break;
            
            case '*':
                someOperation = new Multiplication(first, second);
                Tester.test(someOperation);
            break;
            
            case '/':
                someOperation = new Division(first, second);
                Tester.test(someOperation);
            break;
        }
    }
}
