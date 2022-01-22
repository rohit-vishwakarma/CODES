import java.util.*;
public class pattern9{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j || j==n-i+1){
                    System.out.print("*");
                }
                
                   System.out.print("\t");
            }
            System.out.println();

        }
    }
}