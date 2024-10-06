package bootleg_cli_pvz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean awake = false;
        System.out.print("Game Mode: ");
        String mode = sc.nextLine();
        
        int idx = 0, n = 0, x = 0;
        
        if(mode.equals("Night") || mode.equals("Fog")) awake = true;

        String input;
        do {
            idx = 0;
            System.out.print("Add a plant: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Wall Nut":
                    plants.add(new Plant.WallNut());
                    break;
                case "Sun-shroom":
                    plants.add(new Mushroom.SunShroom(awake));
                    break;
                // add more plants here
                case "Puff-shroom":
                    plants.add(new Mushroom.PuffShroom(awake));
                    break;
                case "Doom-shroom":
                    plants.add(new Mushroom.DoomShroom(awake));
                    break;
                case "Sunflower":
                    plants.add(new Plant.Sunflower());
                    break;
                case "Twin Sunflower":
                    for(Plant p : plants){
                        if(p instanceof Plant.Sunflower){
                            break;
                        }
                        idx++;
                    }
                    plants.remove(idx);
                    plants.add(idx, new Plant.TwinSunflower());
                    break;
                case "Lily Pad":
                    plants.add(new Plant.LilyPad());
                    break;
                case "Cattail":
                    for(Plant p : plants){
                        if(p instanceof Plant.LilyPad){
                            break;
                        }
                        idx++;
                    }
                    plants.remove(idx);
                    plants.add(idx, new Plant.Cattail());
                    break;
                case "Peashooter":
                    plants.add(new Plant.Peashooter());
                    break;
                case "Squash":
                    plants.add(new Plant.Squash());
                    break;
                case "Jalapeno":
                    plants.add(new Plant.Jalapeno());
                    break;
                case "Coffee Bean":
                    for(Plant p : plants){
                        if(p instanceof Mushroom && ((Mushroom) p).isAwake() == false){
                            ((Mushroom) p).awaken(new Plant.CoffeeBean());
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println(input + " is not a plant");
            }
        } while (!input.equals("DONE"));

        do {
            n = 0;
            x = 0;
            System.out.print("Do something: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Produce Sun":
                    // add implementation here
                    for(Plant p : plants){
                        if(p instanceof SunProducer){
                            n++;
                            x += ((SunProducer) p).produce_sun();
                        }
                    }
                    if(n == 0){
                        System.out.println("You have no sun producers");
                    }
                    else {
                        System.out.println(n + " sun producers gather " + x + " suns");
                    }
                    break;
                case "Attack":
                    // add implementation here
                    for(Plant p : plants){
                        if(p instanceof Attacker && p.get_hp() > 0){
                            n++;
                            x += ((Attacker) p).attack();
                        }
                    }
                    if(n == 0){
                        System.out.println("You have no attackers");
                    }
                    else {
                        System.out.println(n + " attackers dealing " + x + " damage");
                    }
                    break;
                // add more cases here
                case "Instant Kill Status":
                    for(Plant p : plants){
                        if(p instanceof InstantKiller && p.get_hp() > 0){
                            n++;
                            if(((InstantKiller) p).killType() == 1){
                                System.out.println(p.get_name() + " can kill instantly");
                            }else if(((InstantKiller) p).killType() == 2){
                                System.out.println(p.get_name() + " can kill on contact");
                            }
                        }
                    }
                    if(n == 0){
                        System.out.println("You have no plants which can kill instantly");
                    }
                    break;
                case "Attacker Status":
                    for(Plant p : plants){
                        if(p instanceof Attacker && p.get_hp() > 0){
                            n++;
                            if(((Attacker) p).rangeType() == 1){
                                System.out.println(p.get_name() + " can attack on a single line");
                            }else if(((Attacker) p).rangeType() == 2){
                                System.out.println(p.get_name() + " can attack using area-of-effect");
                            }else if(((Attacker) p).rangeType() == 3){
                                System.out.println(p.get_name() + " can attack only when enemy is nearby");
                            }else if(((Attacker) p).rangeType() == 4){
                                System.out.println(p.get_name() + " can attack any enemies from anywhere");
                            }
                        }
                    }
                    if(n == 0){
                        System.out.println("You have no attackers");
                    }
                    break;
                case "Sort by Name":
                    Collections.sort(plants);
                    for(Plant p : plants){
                        System.out.println(p.toString());
                    }
                    break;
                case "Sort by HP":
                    Collections.sort(plants);
                    plants.sort(new Plant.HpComparator());
                    for(Plant p : plants){
                        System.out.println(p.toString());
                    }
                    break;
                case "Sort by Sun Cost":
                    Collections.sort(plants);
                    plants.sort(new Plant.SunCostComparator());
                    for(Plant p : plants){
                        System.out.println(p.toString());
                    }
                    break;
                default:
                    System.out.println("Unknown action: " + input);
            }
        } while (!input.equals("DONE"));
    }
}
