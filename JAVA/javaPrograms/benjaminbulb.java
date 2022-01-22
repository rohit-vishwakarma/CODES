import java.util.*;
public class benjaminbulb{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
        for(int i=1;i*i<=n;i++){
            System.out.println(i*i);
            
            
        }
    }
}