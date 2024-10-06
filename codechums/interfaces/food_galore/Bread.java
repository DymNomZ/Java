package interfaces.food_galore;

class Bread implements FoodInterface {
    int satietyPoints;
    
    public Bread(){
        satietyPoints = 10;
    }
    
    public void cook(int n){
        satietyPoints *= n;
    }
    
    public int eat(){
        return satietyPoints;
    }
}
