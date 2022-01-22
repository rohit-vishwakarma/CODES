import java.util.*;
  
  public class abadd{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n, int m){
       // write ur code here
       int res=0,pow=1, carry=0;
       while(n!=0 || m!=0 || carry!=0){
           int r1=n%10;
           int r2=m%10;
           
           n/=10;
           m/=10;
           
           int sum= r1+r2+carry;
           int r=sum%b;
           carry =sum/b;
           res+=r*pow;
           pow*=10;
       }
      return res;
   }
  }