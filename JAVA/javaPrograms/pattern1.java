import java.util.*;
public class pattern1{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        int nst=n;
        for(int r=1; r<=nst; r++){
            for(int cst=1; cst<=nst; cst++){
                System.out.print("*\t");
            }
            
            System.out.println();
        }
    }
}