package interfaces.shape_of_us;

// Add Comparable and Comparator interface implementation here

import java.util.*;

public abstract class Shape implements Comparable<Shape>{
    String color;

    public Shape(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "A shape that is color " + color;
    }

    public abstract double area();
    public abstract double perimeter();
    
    @Override
    public int compareTo(Shape s2){
        int comp = this.color.compareTo(s2.color);
        return comp;
    }
    
    static public class PerimeterCompare implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2){
            if(s2.perimeter() >  s1.perimeter()){
                return 1;
            }else if(s2.perimeter() <  s1.perimeter()){
                return -1;
            }
            return 0;
        }
    }
    
    static public class AreaCompare implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2){
            if(s2.area() >  s1.area()){
                return 1;
            }else if(s2.area() <  s1.area()){
                return -1;
            }
            return 0;
        }
    }
}
