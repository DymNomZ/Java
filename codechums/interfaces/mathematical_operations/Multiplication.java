package interfaces.mathematical_operations;

class Multiplication extends Operation {
    
    public Multiplication(double left, double right){
        super(left, right);
    }
    
    public double performOperation(){
        return left * right;
    }
    
    public void printResult(){
        super.printResult();
    }
}
