import java.util.*;
public class pattern8{
    public static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        int nsp=n-1;
        for(int r=1;r<=n;r++){
            for(int csp=1;csp<=nsp;csp++){
                System.out.print("\t");
            }
            System.out.print("*\n");
            nsp--;
        }
    }
}