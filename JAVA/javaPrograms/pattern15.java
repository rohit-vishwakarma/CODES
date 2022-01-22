import java.util.*;
public class pattern15{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        int nst=1;
        int nsp=n/2;
        int i;
        for(int r=1; r<=n; r++){
             if(r>n/2)
                i=n-r+1;
            else
               i=r;
            for(int cst=1; cst<=nsp; cst++){
                System.out.print("\t");
              
            }
            for(int cst=1; cst<=nst/2+1; cst++){
                 System.out.print(i+"\t");
                i++;
            }
           i--;
           for(int cst=1; cst<=nst/2; cst++){
               i--;
                System.out.print(i+"\t");
                
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