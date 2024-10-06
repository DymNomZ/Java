package interfaces.mathematical_operations;

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
    
    public static void test (Operation someOperation) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter code: ");
        double code = scanner.nextInt();
        if (code == 1) {
            if(Modifier.isAbstract(Operation.class.getModifiers())) {
                System.out.println("SUCCESS");
            }else {
                System.out.println("FAILED");
            }
        }

        else if (code == 2) {
            Field left = getField(someOperation, "left");
            Field right = getField(someOperation, "right");

            if(left != null && right != null) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILED");
            }
        }

        else if (code == 3) {
            try {
                Method performOperation = Operation.class.getDeclaredMethod("performOperation");
       
                if (performOperation != null) {
                    if(!(Modifier.isAbstract(performOperation.getModifiers()))) {
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

        else if (code == 4) {
            double testLeft = 10;
            double testRight = 20;
            Addition newAdditon = new Addition(testLeft, testRight);

            if (newAdditon instanceof Operation) { 
                if (newAdditon.left == testLeft && newAdditon.right == testRight) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } else {
                System.out.println("FAILED");
                return;
            }
        }

        else if (code == 5) {
            double testLeft = 10;
            double testRight = 20;
            Subtraction newSubtraction = new Subtraction(testLeft, testRight);

            if (newSubtraction instanceof Operation) {
                if (newSubtraction.left == testLeft && newSubtraction.right == testRight) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } else {
                System.out.println("FAILED");
                return;
            }
        }

        else if (code == 6) {
            double testLeft = 10;
            double testRight = 20;
            Multiplication newMultiplication = new Multiplication(testLeft, testRight);

            if (newMultiplication instanceof Operation) {
                if (newMultiplication.left == testLeft && newMultiplication.right == testRight) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } else {
                System.out.println("FAILED");
                return;
            }
        }

        else if (code == 7) {
            double testLeft = 10;
            double testRight = 20;
            Division newDivision = new Division(testLeft, testRight);

            if (newDivision instanceof Operation) {
                if (newDivision.left == testLeft && newDivision.right == testRight) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            } else {
                System.out.println("FAILED");
                return;
            }
        }

        else if (code == 8) {
            double testLeft = 143;
            double testRight = 143;
            double testResult = 286;
            Addition newAdditon = new Addition(testLeft, testRight);

            Method performOperation = Tester.getMethod(newAdditon, "performOperation");

            try {
                double result = Double.parseDouble(performOperation.invoke(newAdditon).toString());

                if (result == testResult) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 9) {
            double testLeft = 143;
            double testRight = 143;
            double testResult = 0;
            Subtraction newSubtraction = new Subtraction(testLeft, testRight);

            Method performOperation = Tester.getMethod(newSubtraction, "performOperation");

            try {
                double result = Double.parseDouble(performOperation.invoke(newSubtraction).toString());

                if (result == testResult) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 10) {
            double testLeft = 143;
            double testRight = 143;
            double testResult = 20449;
            Multiplication newMultiplication = new Multiplication(testLeft, testRight);

            Method performOperation = Tester.getMethod(newMultiplication, "performOperation");

            try {
                double result = Double.parseDouble(performOperation.invoke(newMultiplication).toString());

                if (result == testResult) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 11) {
            double testLeft = 143;
            double testRight = 143;
            double testResult = 1;
            Division newDivision = new Division(testLeft, testRight);

            Method performOperation = Tester.getMethod(newDivision, "performOperation");

            try {
                double result = Double.parseDouble(performOperation.invoke(newDivision).toString());

                if (result == testResult) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILED");
                }
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 12) {
            Method printResult = Tester.getMethod(someOperation, "printResult");

            try {
                printResult.invoke(someOperation);
                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }
    }
}
