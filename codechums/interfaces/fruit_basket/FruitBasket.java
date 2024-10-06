package interfaces.fruit_basket;

import java.util.ArrayList;

class FruitBasket {
    private ArrayList<Fruit> fruits = new ArrayList<>();
    
    public void addFruit(Fruit fruit){
        fruits.add(fruit);
    }
    
    public void countApple(){
        int count = 0;
        for(Fruit a : fruits){
            if(a instanceof Apple){
                count++;
            }
        }
        System.out.println("Number of Apples in the basket: " + count);
    }
    
    public void countBanana(){
        int count = 0;
        for(Fruit a : fruits){
            if(a instanceof Banana){
                count++;
            }
        }
        System.out.println("Number of Bananas in the basket: " + count);
    }
    
    public void countOrange(){
        int count = 0;
        for(Fruit a : fruits){
            if(a instanceof Orange){
                count++;
            }
        }
        System.out.println("Number of Oranges in the basket: " + count);
    }
    
    public void fruitBasketTastes(){
        for(Fruit a : fruits){
            a.getTaste();
        }
    }
    
    public void fruitBasketTextures(){
        for(Fruit a : fruits){
            a.getTexture();
        }
    }
}
