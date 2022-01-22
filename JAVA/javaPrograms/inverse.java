import java.util.*;
public class inverse{
    public static Scanner in =new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
    System.out.println(operation(n));
    }
    public static int countDigit(int n){
        int count=0;
        while(n!=0){
            count++;
            n/=10;
        }
        return count;
    }
    public static int operation(int n){
     int len=countDigit(n);
     int res=0;
     for(int i=1;i<=len;i++){
         int digit= n%10;
         n/=10;
         res+= i*Math.pow(10,digit-1);
     }
     return res;
    }
}