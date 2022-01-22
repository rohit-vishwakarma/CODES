import java.util.*;
public class pattern17{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
      //  int nst=1;
        int nst2=1;
        int nsp=n/2;
        for(int r=1; r<=n; r++){
            
            if(r==n/2+1){
                
                for(int cst=1; cst<r; cst++){
                    System.out.print("*\t");
                }
            }
            else {
                for(int csp=1; csp<=nsp; csp++){
                    System.out.print("\t");
                  
                }
           // for(int cst=1; cst<=nst; cst++){
             //   System.out.print("*\t");
       //     }
        }
            for(int cst=1;cst<=nst2;cst++){
                System.out.print("*\t");
            }
            if(r<=n/2){
                nst2++;
            }
            else nst2--;
            System.out.println();
        }
        
    }
}