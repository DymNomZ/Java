package interfaces.simple_drawing_with_shapes;

class Square implements Shape {
    int side;
    
    public Square(int side){
        this.side = side;
    }
    
    public void draw(){
        for(int i = 1; i <= side; i++){
            for(int j = 1; j <= side; j++){
                System.out.print("` ");
            }
            System.out.println();
        }
    }
}
