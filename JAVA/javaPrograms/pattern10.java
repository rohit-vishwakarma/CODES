import java.util.*;
public class pattern10{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        int nsp1=n/2;
        int nsp2=-1;
        for(int r=1;r<=n;r++){
            for(int csp1=1;csp1<=nsp1;csp1++){
                System.out.print("\t");
            }
            System.out.print("*\t");
            for(int csp2=1;csp2<=nsp2;csp2++){
                System.out.print("\t");
            }
            if(nsp2!=-1){
                System.out.print("*\t");
            }
            if(r<=n/2){
                nsp1--;
                nsp2+=2;
            }
            else{
                nsp1++;
                nsp2-=2;
            }
            System.out.println();
        }
    }
}