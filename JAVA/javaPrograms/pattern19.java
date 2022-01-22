import java.util.*;
public class pattern19{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        int nsp=n/2-1;
        int nst=n/2+1;
        for(int r=1;r<=n;r++){
           if(r==1){
               for(int cst=1;cst<=nst;cst++)
                  System.out.print("*\t");
                for(int csp=1;csp<=nsp;csp++)
                   System.out.print("\t");
                   System.out.print("*");
           }
           else if(r==n){
            System.out.print("*");
            for(int csp=1;csp<=nsp+1;csp++)
            System.out.print("\t");
            for(int cst=1;cst<=nst;cst++)
            System.out.print("*\t");
           }
           else if(r==n/2+1){
            for(int cst=1;cst<=n;cst++)
            System.out.print("*\t");
           }
           else if(r<=n/2){
               for(int csp=1;csp<=nsp+1;csp++)
               System.out.print("\t");
               System.out.print("*");
               for(int csp=1;csp<=nsp+1;csp++)
               System.out.print("\t");
               System.out.print("*");
           }
           else{
               System.out.print("*");
               for(int csp=1;csp<=nsp+1;csp++)
               System.out.print("\t");System.out.print("*");
           }
           System.out.println();
        }
    }
}