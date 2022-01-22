import java.util.*;
public class arrspan{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        operation(n,arr);
    }
    public static void operation(int n, int[] arr){
        int max=arr[0],min=arr[0];
        for(int i=0;i<n;i++){
            if(max<=arr[i]){
                max=arr[i];
            }
            else if(min>=arr[i]){
                min=arr[i];
            }
        }
        int x=max-min;
        System.out.print(x);
    }
}