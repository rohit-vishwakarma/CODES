import java.util.*;
public class numdigit{
    public static Scanner in=new Scanner(System.in);
    public static void main(String[] args){
        int n=in.nextInt();
        operation(n);
    }
    public static void operation(int n){
       int len=digit(n);
        int div=1;
        while(len!=1){
            div*=10;
            len--;
        }
        len=digit(n);
        while(len-->0){
            System.out.println(n/div);
            n=n%div;
            div=div/10;
        }
        
    }
    public static int digit(int n){
         int c=0;
        int x=n;
        while(x!=0){
            x=x/10;
            c++;
        }
        return c;
    }
   
}