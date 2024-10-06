package interfaces.food_galore;

class Meat implements FoodInterface {
    int satietyPoints;
    
    public Meat(){
        satietyPoints = 40;
    }
    
    public void cook(int n){
        satietyPoints *= n;
    }
    
    public int eat(){
        return satietyPoints;
    }
}
