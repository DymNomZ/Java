package comparing;

interface cellphone {

    public static final int num = 13;

    public default void turn_on(){
        System.out.println("I'm onning " + num);
    }
    
}
