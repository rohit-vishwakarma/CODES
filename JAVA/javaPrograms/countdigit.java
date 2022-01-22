import java.util.*;
public class countdigit{
  
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        digits(n);
    }
    public static void digits(int n){
        int c=0;
    while(n!=0){
      n=n/10;
      c++;
    }
    System.out.println(c);
    }
}