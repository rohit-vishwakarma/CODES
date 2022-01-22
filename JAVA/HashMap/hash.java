package HashMap;

import java.util.HashMap;
import java.util.ArrayList;

public class hash{
    public static void basic(){
        HashMap<String , Integer> hash = new HashMap<>();
        hash.put("Anmol Kumar", 1);
        hash.put("Rohit Vishwakarma", 3);
        hash.put("Umang Aggarwal", 5);
        hash.put("Saud Akhtar", 7);
        hash.put("Vipin Kumar", 9);
// put(key,value)
//containsKey(key)
//keySet()
//get(key)
//forEach
//getOrDefault(ch, default_value)
// putIfAbsent(ch, new ArrayList<>())
        for(String keys : hash.keySet()){
             System.out.println(keys+"->"+hash.get(keys));
        }
    }
   
    public static void printFrequency(String str){
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            // if(freq.containsKey(ch)){
            //     int x = freq.get(ch) + 1;
            //     freq.put(ch, x);
            // }else{
            //     freq.put(ch,1);
            // }
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }
        for(Character keys : freq.keySet()){
            System.out.println(keys+"->"+freq.get(keys));
        }
    }

    public static void highestFreqchar(String str){
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(freq.containsKey(ch)){
                int x = freq.get(ch) + 1;
                freq.put(ch, x);
            }else{
                freq.put(ch,1);
            }
        }
        char temp = str.charAt(0);
        for(Character keys : freq.keySet()){
            if(freq.get(keys)>freq.get(temp)){
                temp= keys;
            }
        }
        System.out.println(temp+"->"+freq.get(temp));
    }

    public static void positionOfAllChar(String str){
     HashMap<Character, ArrayList<Integer>> pos = new HashMap<>();

     for(int i=0 ; i<str.length(); i++){
         char ch = str.charAt(i);
         pos.putIfAbsent(ch, new ArrayList<>());
         pos.get(ch).add(i);
     }
     for(Character ch : pos.keySet()){
         System.out.println(ch+"->"+ pos.get(ch));
     }
    }
    
    public static void commonElementOne(int[] a1,int[] a2){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : a1){
            if(map.containsKey(i)){
                int x = map.get(i) + 1;
                map.put(i,x);
            }else{
                map.put(i,1);
            }
        }
        for(int ele : a2){
            if(map.containsKey(ele)){
                System.out.println(ele);
                map.remove(ele);
            }
        }
    }
    
     public static void commonElementTwo(int[] a1,int[] a2){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : a1){
            if(map.containsKey(i)){
                int x = map.get(i) + 1;
                map.put(i,x);
            }else{
                map.put(i,1);
            }
        }
        for(int ele : a2){
            if(map.containsKey(ele)){
                System.out.println(ele);
                int x = map.get(ele)-1;
                if(x==0){
                    map.remove(ele);
                }else
                map.put(ele,x);
            }
        }
     }
     
     public static void longestConsecutiveSequence(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int sp = 0, maxLen = 0;

        for (int ele : arr) {
            if (!map.containsKey(ele))
                continue;

            map.remove(ele);
            int le = ele - 1;
            int re = ele + 1;

            while (map.containsKey(le)) {
                map.remove(le);
                le--;
            }

            while (map.containsKey(re)) {
                map.remove(re);
                re++;
            }

            int len = re - le - 1;
            if (len > maxLen) {
                maxLen = len;
                sp = le + 1;
            }
        }

        for (int i = 0; i < maxLen; i++)
            System.out.println(sp + i);

    }

    public static void main(String[] args){
        basic();
        // printFrequency("hello how are you");
        // System.out.println("******");
        // highestFreqchar("Rohit Vishwakarma");
        // positionOfAllChar("akjdfjshajhfdueueujdshfhhak");
    }
}
