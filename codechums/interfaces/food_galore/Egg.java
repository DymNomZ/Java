package interfaces.food_galore;

class Egg implements FoodInterface {
    int satietyPoints;
    
    public Egg(){
        satietyPoints = 5;
    }
    
    public void cook(int n){
        satietyPoints *= n;
    }
    
    public int eat(){
        return satietyPoints;
    }
}
