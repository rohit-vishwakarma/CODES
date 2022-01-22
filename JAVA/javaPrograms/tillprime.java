import java.util.*;
public class tillprime{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int t=in.nextInt();
        int n=in.nextInt();
        for(int i=t;i<=n;i++){
        
        check(i);}
    }
    public static void check(int n){
        boolean prime=true;
        
        for(int i=2;i*i<=n;i++){
         if((n%i)==0){
             prime= false;
             break;
         }
        }
        if(prime==true)
            System.out.println(n);
       
            
        
    }
}