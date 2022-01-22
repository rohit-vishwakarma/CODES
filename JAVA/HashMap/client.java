package HashMap;

import java.util.Scanner;
public class client{
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        HashMap hm = new HashMap();
        System.out.println("isEmpty functions = "+hm.isEmpty());
        System.out.println("size Before = "+hm.size());
        for(int i =0; i<50 ;i++){
            int key = in.nextInt();
            hm.put(key, hm.getOrDefault(key, 0)+1);
        }
        System.out.println("size after = "+hm.size());
        System.out.println(hm);
        hm.putIfAbsent(20,20);
        System.out.println(hm.get(20));
        System.out.println(hm);
        System.out.println("size after = "+hm.size());
    }
}