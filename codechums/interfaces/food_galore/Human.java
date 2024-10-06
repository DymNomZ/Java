package interfaces.food_galore;

class Human {
    public int satietyLevel;
    
    public Human(){
        satietyLevel = 0;
    }
    
    public void getSatiety(){
        if(satietyLevel < 50){
            System.out.println("Hungry");
        }else if(satietyLevel < 90){
            System.out.println("Satiated");
        }else{
            System.out.println("Full");
        }
    }
    
    public void feed(FoodInterface food){
        satietyLevel += food.eat();
        if(satietyLevel > 100){
            satietyLevel = 100;
        }
    }
}
