import java.util.*;
public class fibonacci{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        fibo(n);
    }

    public static void fibo(int n){
      long f1=0,f2=1,f3;
       
      for(int i=1;i<=n;i++){
        System.out.println(f1);
          f3=f1+f2;
          f1=f2;
          f2=f3;
      }
     }
}