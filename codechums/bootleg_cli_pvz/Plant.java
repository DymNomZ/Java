package bootleg_cli_pvz;

import java.util.Comparator;

public abstract class Plant implements Comparable<Plant>{
    public static final int INFINITE = Integer.MAX_VALUE;

    String name;
    int hp;
    int sun_cost;

    public Plant(String name, int sun_cost) {
        this.name = name;
        this.hp = 6;
        this.sun_cost = sun_cost;
    }

    public Plant(String name, int hp, int sun_cost) {
        this.name = name;
        this.hp = hp;
        this.sun_cost = sun_cost;
    }
    
    public String get_name(){
        return name;
    }
    
    public int get_hp(){
        return hp;
    }
    
    public int get_sun_cost(){
        return sun_cost;
    }

    public boolean isAlive() {
        // TODO implementation
        if(hp > 0) return true;
        return false;
    }

    public String die() {
        // TODO implementation
        hp = 0;
        return name + " dies ";
    }

    @Override
    public String toString() {
        // TODO implementation
        if(hp == INFINITE) return name + " (∞) - cost: " + sun_cost; 
        return name + " (" + hp + ") - cost: " + sun_cost;
    }
    
    @Override
    public int compareTo(Plant o){
        return this.name.compareTo(o.name);
    }

    // Add Plant subclasses here, and
    // Hint: You can also add Comparator inner classes here
    public static class HpComparator implements Comparator<Plant>{
        @Override
        public int compare(Plant o1, Plant o2){
            return Integer.compare(o2.get_hp(), o1.get_hp());
        }
    }
    
    public static class SunCostComparator implements Comparator<Plant>{
        @Override
        public int compare(Plant o1, Plant o2){
            return Integer.compare(o2.get_sun_cost(), o1.get_sun_cost());
        }
    }
    // WallNut and CoffeeBean given for free
    public static class WallNut extends Plant{
        public WallNut() {
            super("Wall Nut", 25, 50);
        }
    }

    public static class CoffeeBean extends Plant{
        public CoffeeBean() {
            super("Coffee Bean", INFINITE, 75);
        }
    }
    
    public static class Sunflower extends Plant implements SunProducer, Upgradable {
        public Sunflower(){
            super("Sunflower", 50);
        }
        
        @Override
        public int produce_sun(){
            System.out.println(name + " produces 25 suns");
            return 25;
        }
        
        @Override
        public PlantUpgrade upgrade(){
            Plant p = new TwinSunflower();
            return (PlantUpgrade)p;
        }
    }
    
    public static class TwinSunflower extends Plant implements SunProducer, PlantUpgrade {
        public TwinSunflower(){
            super("Twin Sunflower", 250);
        }
        
        @Override
        public int produce_sun(){
            System.out.println(name + " produces 50 suns");
            return 50;
        }
        
        @Override
        public int concurrentSunCost(){
            return 50;
        }
    }
    
    public static class Peashooter extends Plant implements Attacker {
        public Peashooter(){
            super("Peashooter", 100);
        }
        
        @Override
        public int attack(){
            System.out.println(name + " attacks");
            return 1;
        }
        
        @Override
        public int rangeType(){
            return 1;
        }
    }
    
    public static class Squash extends Plant implements InstantKiller, Attacker {
        public Squash(){
            super("Squash", INFINITE, 50);
        }
        
        @Override
        public int attack(){
            System.out.println(name + " attacks");
            System.out.println(super.die() + "while squashing zombies");
            return 3;
        }
        
        @Override
        public int rangeType(){
            return 3;
        }
        
        @Override
        public int killType(){
            return 2;
        }
    }
    
    public static class Jalapeno extends Plant implements InstantKiller, Attacker {
        public Jalapeno(){
            super("Jalapeno", INFINITE, 125);
        }
        
        @Override
        public int attack(){
            System.out.println(name + " attacks");
            System.out.println(super.die() + "while exploding");
            return 5;
        }
        
        @Override
        public int rangeType(){
            return 1;
        }
        
        @Override
        public int killType(){
            return 1;
        }
    }
    
    public static class LilyPad extends Plant implements Upgradable {
        public LilyPad(){
            super("Lily Pad", 25);
        }
        
        @Override
        public PlantUpgrade upgrade(){
            Plant p = new Cattail();
            return (PlantUpgrade)p;
        }
    }
    
    public static class Cattail extends Plant implements Attacker, PlantUpgrade {
        public Cattail(){
            super("Cattail", 225);
        }
        
        @Override
        public int attack(){
            System.out.println(name + " attacks");
            return 1;
        }
        
        @Override
        public int rangeType(){
            return 4;
        }
        
        @Override
        public int concurrentSunCost(){
            return 25;
        }
    }
}
