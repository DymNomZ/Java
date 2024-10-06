package interfaces.simple_drawing_with_shapes;

class Triangle implements Shape {
    int height;
    
    public Triangle(int height){
        this.height = height;
    }
    
    public void draw(){
        int n = height;
        int v = 1;
        for(int i = 1; i <= height; i++){
            for(int k = 1; k < n; k++){
                System.out.print("  ");
            }
            for(int j = 1; j <= v; j++){
                System.out.print("` ");
            }
        System.out.println();
        n--;
        v += 2;
        }
    }
        
}
