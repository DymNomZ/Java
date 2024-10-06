package interfaces.food_galore;

class Rice implements FoodInterface {
    int satietyPoints;
    
    public Rice(){
        satietyPoints = 20;
    }
    
    public void cook(int n){
        satietyPoints *= n;
    }
    
    public int eat(){
        return satietyPoints;
    }
}
