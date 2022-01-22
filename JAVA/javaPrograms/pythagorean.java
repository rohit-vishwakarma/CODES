import java.util.*;
public class pythagorean{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        operation(a,b,c);
    }
    public static void operation(int a, int b, int c){
        
        if(a*a==(b*b+c*c)|| b*b==(a*a+c*c) || c*c==(a*a+b*b)){
            System.out.println("True");
        }
     else
        System.out.println("False");
    }
}