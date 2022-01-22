import java.util.*;
public class prime{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int t=in.nextInt();
        while(t-->0){
        int n=in.nextInt();
        check(n);}
    }
    public static void check(int n){
        boolean prime=true;
        
        for(int i=2;i*i<=n;i++){
         if((n%i)==0){
             prime= false;
             break;
         }
        }
        if(prime==false)
            System.out.println("not prime");
       else
           System.out.println("prime");
            
        
    }
}