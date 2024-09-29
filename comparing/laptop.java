package comparing;

public class laptop implements Comparable<laptop>{
    String brand;
    int ram;
    int price;

    laptop(String brand, int ram, int price){
        this.brand = brand;
        this.ram = ram;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Laptop brand, ram, and price: " + brand + " " + ram + " " + price;
    }

    @Override
    public int compareTo(laptop o) {
        return this.brand.compareTo(o.brand);
    }
}
