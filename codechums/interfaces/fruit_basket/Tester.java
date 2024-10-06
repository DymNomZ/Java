package interfaces.fruit_basket;

import java.util.*;
import java.lang.reflect.*;

class Tester {
    private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));
    
        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }
    
        return fields;
    }
    
    private static Field getField(Object obj, String fieldName) {
        List<Field> fields = getAllFields(new LinkedList<Field>(), obj.getClass());
        for(Field f : fields){
            if (f.getName().equals(fieldName)) {
                return f;
            }
        }
        return null;
    }

    private static Method getMethod(Object obj, String methodName) {
        Method[] methods = obj.getClass().getMethods();
        for (Method m : methods) {
            if (m.getName().equals(methodName)) {
                return m;
            }
        }
        return null;
    }
    
    public static void test (FruitBasket fruitBasket) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter code: ");
        int code = scanner.nextInt();
        if (code == 1) {
            if(Modifier.isAbstract(Fruit.class.getModifiers())) {
                System.out.println("SUCCESS");
            }else {
                System.out.println("FAILED");
            }
        }
        else if (code == 2) {
            try {
                Method getTaste = Fruit.class.getDeclaredMethod("getTaste");
                Method getTexture = Fruit.class.getDeclaredMethod("getTexture");
       
                if (getTaste != null) {
                    if(!(Modifier.isAbstract(getTaste.getModifiers()))) {
                        System.out.println("FAILED");
                        return;
                    }
                }else {
                     System.out.println("FAILED");
                }

                if (getTexture != null) {
                    if(!(Modifier.isAbstract(getTexture.getModifiers()))) {
                        System.out.println("FAILED");
                        return;
                    }
                }else {
                     System.out.println("FAILED");
                }

                System.out.println("SUCCESS");
            } 
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 3) {
            Apple newApple = new Apple();

            if (newApple instanceof Fruit) {
                
                Method getTaste = getMethod(newApple, "getTaste");
                Method getTexture = getMethod(newApple, "getTexture");

                try {
                    getTaste.invoke(newApple);
                    getTexture.invoke(newApple);

                    System.out.println("SUCCESS");
                }   
                catch(Exception e) {
                    System.out.println("FAILED");
                } 
            }else {
                System.out.println("FAILED");
            }
        }

        else if (code == 4) {
            Orange newOrange = new Orange();

            if (newOrange instanceof Fruit) {

                Method getTaste = getMethod(newOrange, "getTaste");
                Method getTexture = getMethod(newOrange, "getTexture");

                try {
                    getTaste.invoke(newOrange);
                    getTexture.invoke(newOrange);

                    System.out.println("SUCCESS");
                }   
                catch(Exception e) {
                    System.out.println("FAILED");
                }
            }else {
                System.out.println("FAILED");
            }
        }

        else if (code == 5) {
            Banana newBanana = new Banana();

            if (newBanana instanceof Fruit) {

                Method getTaste = getMethod(newBanana, "getTaste");
                Method getTexture = getMethod(newBanana, "getTexture");

                try {
                    getTaste.invoke(newBanana);
                    getTexture.invoke(newBanana);

                    System.out.println("SUCCESS");
                }   
                catch(Exception e) {
                    System.out.println("FAILED");
                }
            }else {
                System.out.println("FAILED");
            }
        }

        else if (code == 6) {
            Field fruits = getField(fruitBasket, "fruits");

            if(
                (fruits != null && Modifier.isPrivate(fruits.getModifiers())) 
            ) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILED");
            }
        }

        else if (code == 7) {
            Apple apple = new Apple();
            Orange orange = new Orange();
            Banana banana = new Banana();

            Field fruits = getField(fruitBasket, "fruits");
            Method addFruit = getMethod(fruitBasket, "addFruit");

            if (fruits != null) {
                fruits.setAccessible(true);
                try {
                    addFruit.invoke(fruitBasket, apple);    
                    addFruit.invoke(fruitBasket, orange);
                    addFruit.invoke(fruitBasket, banana);

                   @SuppressWarnings("unchecked")
                    ArrayList<Fruit> fruitsList = (ArrayList<Fruit>) fruits.get(fruitBasket);

                    if (fruitsList.size() == 3) {
                        System.out.println("SUCCESS");
                    }else {
                        System.out.println("FAILED");
                    }
                }catch(Exception e) {
                    System.out.println("FAILED");
                }
            }else {
                System.out.println("FAILED");
            }
        }

        else if (code == 8) {
            Method addFruit = getMethod(fruitBasket, "addFruit");
            Method countOrange = getMethod(fruitBasket, "countOrange");

            try {
                Apple apple = new Apple();
                Orange orange1 = new Orange();
                Orange orange2 = new Orange();
                Orange orange3 = new Orange();
                Banana banana = new Banana();

                addFruit.invoke(fruitBasket, apple);    
                addFruit.invoke(fruitBasket, orange1);
                addFruit.invoke(fruitBasket, orange2);
                addFruit.invoke(fruitBasket, orange3);
                addFruit.invoke(fruitBasket, banana);

                countOrange.invoke(fruitBasket);

                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 9) {
            Method addFruit = getMethod(fruitBasket, "addFruit");
            Method countApple = getMethod(fruitBasket, "countApple");

            try {
                Apple apple1 = new Apple();
                Apple apple2 = new Apple();
                Apple apple3 = new Apple();
                Apple apple4 = new Apple();
                Orange orange = new Orange();
                Banana banana = new Banana();

                addFruit.invoke(fruitBasket, apple1);
                addFruit.invoke(fruitBasket, apple2);
                addFruit.invoke(fruitBasket, apple3);
                addFruit.invoke(fruitBasket, apple4);
                addFruit.invoke(fruitBasket, orange);
                addFruit.invoke(fruitBasket, banana);

                countApple.invoke(fruitBasket);

                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 10) {
            Method addFruit = getMethod(fruitBasket, "addFruit");
            Method countBanana = getMethod(fruitBasket, "countBanana");

            try {
                Apple apple = new Apple();
                Orange orange = new Orange();
                Banana banana1 = new Banana();
                Banana banana2 = new Banana();
                Banana banana3 = new Banana();

                addFruit.invoke(fruitBasket, apple);
                addFruit.invoke(fruitBasket, orange);
                addFruit.invoke(fruitBasket, banana1);
                addFruit.invoke(fruitBasket, banana2);
                addFruit.invoke(fruitBasket, banana3);

                countBanana.invoke(fruitBasket);

                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 11) {
            Method addFruit = getMethod(fruitBasket, "addFruit");
            Method fruitBasketTastes = getMethod(fruitBasket, "fruitBasketTastes");

            try {
                Apple apple = new Apple();
                Orange orange = new Orange();
                Banana banana = new Banana();

                addFruit.invoke(fruitBasket, apple);
                addFruit.invoke(fruitBasket, orange);
                addFruit.invoke(fruitBasket, banana);

                fruitBasketTastes.invoke(fruitBasket);

                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 12) {
            Method addFruit = getMethod(fruitBasket, "addFruit");
            Method fruitBasketTextures = getMethod(fruitBasket, "fruitBasketTextures");

            try {
                Apple apple = new Apple();
                Orange orange = new Orange();
                Banana banana = new Banana();

                addFruit.invoke(fruitBasket, apple);
                addFruit.invoke(fruitBasket, orange);
                addFruit.invoke(fruitBasket, banana);

                fruitBasketTextures.invoke(fruitBasket);

                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 13) {
            Method addFruit = getMethod(fruitBasket, "addFruit");
            Method countApple = getMethod(fruitBasket, "countApple");
            Method countOrange = getMethod(fruitBasket, "countOrange");
            Method countBanana = getMethod(fruitBasket, "countBanana");
            Method fruitBasketTastes = getMethod(fruitBasket, "fruitBasketTastes");
            Method fruitBasketTextures = getMethod(fruitBasket, "fruitBasketTextures");

            try {
                Apple apple1 = new Apple();
                Apple apple2 = new Apple();
                Apple apple3 = new Apple();
                Orange orange1 = new Orange();
                Orange orange2 = new Orange();
                Banana banana1 = new Banana();
                Banana banana2 = new Banana();

                addFruit.invoke(fruitBasket, apple1);
                addFruit.invoke(fruitBasket, apple2);
                addFruit.invoke(fruitBasket, apple3);
                addFruit.invoke(fruitBasket, orange1);
                addFruit.invoke(fruitBasket, orange2);
                addFruit.invoke(fruitBasket, banana1);
                addFruit.invoke(fruitBasket, banana2);

                countApple.invoke(fruitBasket);
                countOrange.invoke(fruitBasket);
                countBanana.invoke(fruitBasket);

                fruitBasketTastes.invoke(fruitBasket);
                fruitBasketTextures.invoke(fruitBasket);

                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }
    }
}
