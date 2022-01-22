import java.util.*;
public class pattern7{
    public static Scanner in =new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        int nsp=n-1;
        for(int r=1;r<=n;r++){
         System.out.print('*');  
         System.out.println();
         for(int csp=nsp;csp<=n-1;csp++){
             System.out.print("\t");
         }  
         nsp--;
        }
    }
}