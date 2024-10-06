package interfaces.food_galore;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Hey there, start typing your Java code here
        Scanner sc = new Scanner(System.in);
        int t_cook;
        Egg egg = new Egg();
        Bread bread = new Bread();
        Rice rice = new Rice();
        Meat meat = new Meat();
        System.out.print("Enter the number of times to cook Egg: ");
        t_cook = sc.nextInt();
        egg.cook(t_cook);
        System.out.print("Enter the number of times to cook Bread: ");
        t_cook = sc.nextInt();
        bread.cook(t_cook);
        System.out.print("Enter the number of times to cook Rice: ");
        t_cook = sc.nextInt();
        rice.cook(t_cook);
        System.out.print("Enter the number of times to cook Meat: ");
        t_cook = sc.nextInt();
        meat.cook(t_cook);
        
        Human human = new Human();
        human.feed(egg);
        human.feed(bread);
        human.feed(rice);
        human.feed(meat);
        Tester.test(human, egg, bread, rice, meat);
    }
}
