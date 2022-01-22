import java.io.*;
import java.util.*;

public class RstrTonum {
public static Scanner in= new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String str=in.nextLine();
        long a=in.nextLong();
        //long sum=0;
        //int x= str.charAt(0);

        long res=strTonum(str,0,0);
        res=res/a;
        System.out.print(res);
    }
    public static long strTonum(String str, int n, long sum ){
        if(n==str.length()) return sum;
        int x= str.charAt(n);
        x-=48;
        sum=x+sum*10;
        return strTonum(str,n+1,sum);
    }
}