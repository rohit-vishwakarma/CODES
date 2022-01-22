import java.util.*;
  
  public class abtab{
  public static Scanner scn = new Scanner(System.in);
  public static void main(String[] args) {
      
      long n = scn.nextInt();
      int b1 = scn.nextInt();
     int  b2= scn.nextInt();
     long ans= anybaseTodecimal(n,b1);
     System.out.println(decimalToanybase(ans,b2));
   } 
   
   public static long anybaseTodecimal(long n, long b){
      long res=0, pow=1;
        while(n!=0){
           long rem=n%10;
           n/=10;
           res+=rem*pow;
           pow*=b;
       }
       return res;
   }
   public static long decimalToanybase(long n, long b){
       long res=0, pow=1;
        while(n!=0){
           long rem=n%b;
           n/=b;
           res+=rem*pow;
           pow*=10;
       }
       return res;
   }
  }