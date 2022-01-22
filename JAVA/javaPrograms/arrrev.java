import java.util.*;
public class arrrev{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        for(int i=n-1;i>=0;i--){
            System.out.print(arr[i]+ " ");
        }
    }
}