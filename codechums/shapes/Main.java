package shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shape shape = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter shape: ");
        String option = sc.nextLine();
        String color;
        double a, side;
        switch (option) {
            case "Rectangle":
                System.out.print("Enter length: ");
                double len = sc.nextDouble();
                System.out.print("Enter width: ");
                double wid = sc.nextDouble();
                // This nextLine is to rid the next line made by the previous scan
                // Do this in the future as well, before getting a String input
                sc.nextLine();
                System.out.print("Enter color: ");
                color = sc.nextLine();
                shape = new Rectangle(len, wid, color);
                break;
            case "Square":
                // Add your input gathering and shape assignment here
                System.out.print("Enter side: ");
                side = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter color: ");
                color = sc.nextLine();
                shape = new Rectangle.Square(side, color);
                break;
                
            case "Ellipse":
                // Add your input gathering and shape assignment here
                System.out.print("Enter a: ");
                a = sc.nextDouble();
                System.out.print("Enter b: ");
                double b = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter color: ");
                color = sc.nextLine();
                shape = new Ellipse(a, b, color);
                break;
            // Add other cases for other shapes here
            case "Circle":
                // Add your input gathering and shape assignment here
                System.out.print("Enter radius: ");
                double radius = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter color: ");
                color = sc.nextLine();
                shape = new Ellipse.Circle(radius, color);
                break;
            
            case "Triangle":
                // Add your input gathering and shape assignment here
                System.out.print("Enter base: ");
                double base = sc.nextDouble();
                System.out.print("Enter height: ");
                double height = sc.nextDouble();
                System.out.print("Enter a: ");
                a = sc.nextDouble();
                System.out.print("Enter c: ");
                double c = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter color: ");
                color = sc.nextLine();
                shape = new Triangle(base, height, a, c, color);
                break;
                
            case "Equilateral Triangle":
                // Add your input gathering and shape assignment here
                System.out.print("Enter side: ");
                side = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter color: ");
                color = sc.nextLine();
                shape = new Triangle.EquilateralTriangle(side, color);
                break;

        }

        // This assert simply states that by the time the switch is done,
        // the shape should already be assigned to a particular shape
        // and is therefore not null anymore
        assert shape != null;
        System.out.println("\n" + shape);
        System.out.print("Area is ");
        System.out.format("%.2f", shape.area());
        System.out.print("\nPerimeter is ");
        System.out.format("%.2f", shape.perimeter());
    }
}
