import java.util.*;
public class pattern2{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        int nst=1;
        for(int r=1; r<=n; r++){
            for(int cst=1; cst<=nst; cst++){
                System.out.print("*\t");
            }
            nst++;
            System.out.println();
        }
    }
}