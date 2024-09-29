package comparing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<laptop> laptops = new ArrayList<>();

        laptops.add(new laptop("Dell", 8, 16000));
        laptops.add(new laptop("Hp", 4, 8000));
        laptops.add(new laptop("Toshiba", 4, 9000));
        laptops.add(new laptop("Acer", 8, 2100));
        laptops.add(new laptop("Lenovo", 16, 18000));
        laptops.add(new laptop("Acer", 4, 1000));

        Collections.sort(laptops);

        for(laptop l : laptops){
            System.out.println(l.toString());
        }

        System.out.println();

        //un-lambdaed
        Comparator<laptop> c1 = new Comparator<laptop>() {
            @Override
            public int compare(laptop o1, laptop o2) {
                return Integer.compare(o1.ram, o2.ram);
            }
            
        };

        laptops.sort(c1);

        for(laptop l : laptops){
            System.out.println(l.toString());
        }

        System.out.println();

        //lambdaed lmao
        Comparator<laptop> c2 = (laptop o1, laptop o2) -> Integer.compare(o1.price, o2.price);

        laptops.sort(c2);

        for(laptop l : laptops){
            System.out.println(l.toString());
        }

        System.out.println();
    }
    
}
