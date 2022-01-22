import java.util.*;
public class pattern13{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        
        for(int num=0;num<n;num++){
            int val=1;
            for(int r=0;r<=num;r++){
                System.out.print(val+"\t");
                val= ((num-r)*val)/(r+1);
             }
          System.out.println();
        }
    }
}