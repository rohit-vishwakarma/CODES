import java.util.*;
public class pattern4{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        int nst=n;
        int nsp=0;
        for(int r=1; r<=n; r++){
            for(int cst=1; cst<=nsp; cst++){
                System.out.print("\t");
              
            }
            for(int cst=1; cst<=nst; cst++){
                System.out.print("*\t");
            }
            nst--;
            nsp++;
            System.out.println();
        }
    }
}