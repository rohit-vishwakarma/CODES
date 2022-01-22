import java.util.*;
public class pattern6{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        int nst=1+n/2;
        int nsp=1;
        for(int r=1; r<=n; r++){
            for(int cst=1; cst<=nst; cst++){
                System.out.print("*\t");
            }
            for(int cst=1; cst<=nsp; cst++){
                System.out.print("\t");
              
            }
            for(int cst=1; cst<=nst; cst++){
                System.out.print("*\t");
            }
           
            if(r<=n/2){
                nsp+=2;
                nst-=1;
            }
            else
            {
                nsp-=2;
                nst+=1;
            }
            System.out.println();
        }
        
    }
}