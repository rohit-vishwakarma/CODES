import java.util.*;
import java.lang.Math;
public class abtd{
    public static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        int b=in.nextInt();
        conversion(n,b);
    }
    public static void conversion(int n,int b){
        int sum=0,p=0;
        while(n!=0){
            int r=n%10;
            sum+=r*(Math.pow(b,p));
            p++;
            n/=10;
        }
        System.out.print(sum);
    }
}