import java.util.*;
public class gcdlcm{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int a=in.nextInt();
        int b=in.nextInt();
        gcd(a,b);
        lcm(a,b);
    }
    public static void gcd(int a,int b){
       int i, hcf = 0;
         for(i = 1; i <= a || i <= b; i++) {
            if( a%i == 0 && b%i == 0 )
            hcf = i;
         }
         System.out.println("gcd of given two numbers is ::"+hcf);
    }
    public static void lcm(int a,int b){
        int max, step, lcm = 0;
      if(a > b){
         max = step = a;
      } else{
         max = step = b;
      }
      while(a!= 0) {
         if(max%a == 0 && max%b == 0) {
            lcm = max;
            break;
         }
         max += step;
        
      }
      System.out.println("LCM of given numbers is :: "+lcm);
    }
}