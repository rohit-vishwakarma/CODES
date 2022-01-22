import java.util.*;
public class oddeven{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        check(n);
    }
    public static void check(int n){
        if(n%2==0)
            System.out.println("Even no.");
            else
               System.out.println("Odd no.");
    }
}