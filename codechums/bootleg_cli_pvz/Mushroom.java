package bootleg_cli_pvz;

public abstract class Mushroom extends Plant{
    boolean state;
    public Mushroom(String name, int sun_cost, boolean state) {
        super(name, sun_cost);
        this.state = state;
    }

    public boolean isAwake() {
        // TODO implementation
        return state;
    }

    public void awaken(CoffeeBean coffeeBean) {
        // TODO implementation
        state = true;
        System.out.println(coffeeBean.die());
    }

    // an example given for free
    public static class SunShroom extends Mushroom implements SunProducer {

        public SunShroom(boolean state) {
            super("Sun-shroom", 25, state);
        }

        @Override
        public int produce_sun() {
            if (isAwake()) {
                System.out.println(name + " produces 10 suns");
                return 10;
            }
            System.out.println(name + " is asleep and cannot produce sun");
            return 0;
        }
    }

    // Add more mushroom subclasses here
    public static class PuffShroom extends Mushroom implements Attacker {
        public PuffShroom(boolean state){
            super("Puff-shroom", 0, state);
        }
        
        @Override
        public int attack(){
            if(!isAwake()){
                System.out.println(name + " is asleep and cannot attack");
                return 0;
            }
            else{
                System.out.println(name + " attacks");
                return 1;
            }
        }
        
        @Override
        public int rangeType(){
            return 3;
        }
    }
    
    public static class DoomShroom extends Mushroom implements InstantKiller, Attacker {
        public DoomShroom(boolean state){
            super("Doom-shroom", 125, state);
        }
        
        @Override
        public int attack(){
            if(!isAwake()){
                System.out.println(name + " is asleep and cannot attack");
                return 0;
            }
            else{
                System.out.println(name + " attacks");
                System.out.println(super.die() + "while exploding and leaves a crater");
                return 10;
            }
        }
        
        @Override
        public int rangeType(){
            return 2;
        }
        
        @Override
        public int killType(){
            return 1;
        }
    }
}
