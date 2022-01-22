import java.util.*;
public class reverse{
  public static Scanner in=new Scanner(System.in);
  public static void main(String args[]){
      int n=in.nextInt();
      operation(n);
  }
  public static void operation(int n){
   int temp;
   while(n!=0){
       temp=n%10;
       System.out.println(temp);
       n/=10;
   }
  
  }
}