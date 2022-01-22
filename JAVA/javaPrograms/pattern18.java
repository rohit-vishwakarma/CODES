import java.util.*;
public class pattern18{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        for(int i=1;i<=n/2+1;i++){
            if(i==1){
            for(int cst=1;cst<=n;cst++)
                System.out.print("*\t");
             System.out.println();}
        
            for(int j=2;j<n;j++){
                System.out.print("\t");
                if(i==j || j==n-i+1){
                    System.out.print("*");
                } 
            }
            System.out.println();
        }
        int nsp=n/2-1;
        int nst=3;
        for(int i=1;i<=n/2;i++){
            for(int csp=1;csp<=nsp;csp++){
                System.out.print("\t");
            }
            for(int cst=1;cst<=nst;cst++){
                System.out.print("*\t");
            }
            nst+=2;
            nsp--;
            System.out.println();
        }
    }
}