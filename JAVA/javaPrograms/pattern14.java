import java.util.*;
public class pattern14{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        multiplication(n);
    }
    public static void multiplication(int n){
        for(int i=1;i<=10;i++){
            System.out.println(n+" * "+i+" = "+(n*i));
        }
    }
}