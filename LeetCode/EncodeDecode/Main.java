package LeetCode.EncodeDecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//LeetCode problem is only available to premium members, so I am implementing based on my understanding
//Used personal hash function
public class Main {

    static HashMap<String, String>db = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] list = new String[4];
        String[] encoded_l = new String[4];
        String[] decoded_l = new String[4];
        int j = 0;
        while(j < 4){
            System.out.println("Input string: ");
            list[j] = sc.nextLine();
            j++;
        } 
        sc.close();
        //System.out.print(Arrays.toString(list));
        encoded_l = encode(list);
        for(int i = 0; i < 4; i++) db.put(encoded_l[i], list[i]);
        decoded_l = decode(encoded_l);

    }

    public static String[] encode(String[] l){
        String[] encoded_l = new String[4];
        int hash = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < l[i].length(); j++){
                hash += 
                ((l[i].charAt(i) * l[i].charAt(i)) % 101 * 79) +
                ((l[i].charAt(i) * l[i].charAt(i)) % 59 * 41) *
                ((l[i].charAt(i) * l[i].charAt(i)) % 29 * 13);
            }
            encoded_l[i] = String.valueOf(hash);
        }
        //System.out.print(Arrays.toString(encoded_l));
        return encoded_l;
    }

    public static String[] decode(String[] l){
        String[] decoded_l = new String[4];
        for(int i = 0; i < 4; i++) decoded_l[i] = db.get(l[i]);
        //System.out.print(Arrays.toString(decoded_l));
        return decoded_l;
    }
}
