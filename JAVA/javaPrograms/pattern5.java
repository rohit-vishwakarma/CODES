import java.util.*;
public class pattern5{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        int nst=1;
        int nsp=n/2;
        for(int r=1; r<=n; r++){
            for(int cst=1; cst<=nsp; cst++){
                System.out.print("\t");
              
            }
            for(int cst=1; cst<=nst; cst++){
                System.out.print("*\t");
            }
            if(r<=n/2){
                nsp--;
                nst+=2;
            }
            else
            {
                nsp++;
                nst-=2;
            }
            System.out.println();
        }
        
    }
}