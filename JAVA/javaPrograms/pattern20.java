import java.util.*;
public class pattern20{
    public static Scanner in=new Scanner (System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
       int x=2;
       int y=1;
    for(int i=1;i<=n;i++){
        
        for(int j=1;j<=n;j++){
           
                if(j==1 || j==n ||(i>=n/2+1 && j==n/2+x )|| ( i>n/2 && j==n/2+y) )
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            if(i>=n/2){
                x--;
                
            }
            if(i>n/2){
                y++;
            }
            
            System.out.println();        
        } 
        
        
           
       
    }
    
}