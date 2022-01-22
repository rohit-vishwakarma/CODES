import java.io.*;
import java.util.*;

public class palsubstr {
    public static boolean isPalindrome(String s){
        int i=0;
        int j= s.length()-1;
        while(i<=j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
           
        }
        return true;
    }
    
    public static void solution(String str) {
        //write your code here
        for(int i=0;i<str.length();i++){
            for(int j=i+1; j<=str.length(); j++){
                String s= str.substring(i,j);
                if(isPalindrome(s)==true){
                    System.out.println(s);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }

}