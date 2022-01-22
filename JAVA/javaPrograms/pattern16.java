import java.util.*;
public class pattern16{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        int nsp=(n*2)-3;
        int i;
        for(int r=1;r<=n;r++){
            i=1;
            for(int cst=1;cst<=r;cst++){
                System.out.print(i+"\t");
                i++;
            }
            for(int csp=1;csp<=nsp;csp++){
                System.out.print("\t");
            }
            if(r==n){
                i=n-1;
                for(int cst=1;cst<r;cst++){
                    System.out.print(i+"\t");
                    i--;
            }}
            else {
                 i=r;
                for(int cst=1;cst<=r;cst++){
                System.out.print(i+"\t");
                i--;
            }}
            nsp-=2;
            System.out.println();
        }
    }
}