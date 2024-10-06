package interfaces.mathematical_operations;

abstract class Operation {
    double left, right;
    
    public Operation(double left, double right){
        this.left = left;
        this.right = right;
    }
    
    public abstract double performOperation();
    public void printResult(){
        System.out.print("Result: ");
        System.out.printf("%.2f\n", performOperation());
    }
}
