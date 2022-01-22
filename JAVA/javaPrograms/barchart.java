import java.io.*;
import java.util.*;

public class barchart{
public static Scanner in=new Scanner(System.in);
public static void main(String[] args) throws Exception {
    // write your code here
    int n=in.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++)
     arr[i]=in.nextInt();
     operation(n,arr);
 }
public static void operation(int n, int[] arr){
    int max=arr[0];
    for(int i=1;i<n;i++){
        if(max<arr[i]) max=arr[i];
    }
    int x=max;
    for(int i=0;i<max;i++){
    for(int j=0;j<n;j++){
        if(arr[j]==x){
            System.out.print("*\t");
            arr[j]--;
        }
        else 
          System.out.print("\t");
       
    }  x--;
    System.out.println();
    }
}
}