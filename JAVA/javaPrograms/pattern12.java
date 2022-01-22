import java.util.*;
public class pattern12{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n = in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        long f1=0,f2=1,f3;
       
        int nst=1;
       
        for(int r=1; r<=n; r++){
            for(int cst=1; cst<=nst; cst++){
                System.out.print(f1+"\t");
                f3=f1+f2;
          f1=f2;
          f2=f3;
            }
            nst++;
            
            
            System.out.println();
        }
    }
}