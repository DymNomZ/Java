package LeetCode.groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<String> words = new ArrayList<>();
        int[] hash_arr = new int[strs.length];
        HashMap<Integer, Integer> m = new HashMap<>();

        int idx = 0, n = 0;
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < strs[i].length(); j++){
                hash_arr[i] += 
                ((strs[i].charAt(j) * strs[i].charAt(j)) % 101 * 79) +
                ((strs[i].charAt(j) * strs[i].charAt(j)) % 59 * 41) *
                ((strs[i].charAt(j) * strs[i].charAt(j)) % 29 * 13);
            }
            if(m.get(hash_arr[i]) == null) m.put(hash_arr[i], idx++);
        }
        while(n < idx){
            for(int i = 0; i < hash_arr.length; i++){
                if(m.get(hash_arr[i]) == n) words.add(strs[i]);
            }
            ans.add(new ArrayList<>(words));
            words.clear();
            n++;
        }
        return ans;
    }
}
