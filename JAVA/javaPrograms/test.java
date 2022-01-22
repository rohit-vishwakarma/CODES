import java.io.*;
import java.util.*;

public class test{

    public static String compression1(String str) {
        // write your code here
        StringBuilder s = new StringBuilder();
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c < 2 && str.charAt(i) == 'x') {

            } else {
                // System.out.println(str.charAt(i));
                s.append(str.charAt(i));
            }
            c++;
        }

        return s.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t > 0) {
            String str = scn.next();
            System.out.println(compression1(str));
            t--;
        }
        // System.out.println(compression2(str));
    }
/*
7
hi
hiiixxxii
hxi
xhi
xx
x

hixixi
*/ 
}