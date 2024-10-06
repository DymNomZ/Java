package interfaces.simple_drawing_with_shapes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Hey there, start typing your Java code here...\
        Scanner sc = new Scanner(System.in);
        Shape someShape;
        int choice, x;
        System.out.print("Select shape: (1 - Triangle, 2 - Square, 3 - Diamond): ");
        choice = sc.nextInt();
        
        switch(choice){
            case 1:
                System.out.print("Enter height: ");
                x = sc.nextInt();
                someShape = new Triangle(x);
                Tester.test(someShape);
            break;
            
            case 2:
                System.out.print("Enter side: ");
                x = sc.nextInt();
                someShape = new Square(x);
                Tester.test(someShape);
            break;
            
            case 3:
                System.out.print("Enter height: ");
                x = sc.nextInt();
                someShape = new Diamond(x);
                Tester.test(someShape);
            break;
        }
        // Tester.test(someShape);
    }
}
