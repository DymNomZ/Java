package interfaces.mathematical_operations;

class Division extends Operation{
    
    public Division(double left, double right){
        super(left, right);
    }
    
    public double performOperation(){
        return left / right;
    }
    
    public void printResult(){
        super.printResult();
    }
}
