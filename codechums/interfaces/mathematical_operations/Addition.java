package interfaces.mathematical_operations;

class Addition extends Operation {
    
    public Addition(double left, double right){
        super(left, right);
    }
    
    public double performOperation(){
        return left + right;
    }
    
    public void printResult(){
        super.printResult();
    }
    
}
