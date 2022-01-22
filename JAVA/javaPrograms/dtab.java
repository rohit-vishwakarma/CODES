import java.util.*;
public class dtab{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        int b=in.nextInt();
        operation(n,b);
    }
    public static void operation(int n, int b){
       
     if (n == 0)
        return;
  int x = n % b;
  n /= b;
  if (x < 0)
     n += 1; 
  operation(n, b);
     x=x < 0 ? x + (b * -1) : x;
  
           System.out.print(x);
    }
}