import java.io.*;
import java.util.*;

public class subarr{
public static Scanner in =new Scanner(System.in);
public static void main(String[] args) throws Exception {
    // write your code here
    int n=in.nextInt();
    int[] arr= new int[n];
    for(int i=0;i<n;i++)
      arr[i]=in.nextInt();
     subarrays(arr, n);
 }
 public static void subarrays(int[] arr, int n){
     int x=0;
     for(int k=0;k<n;k++){
     for(int i=x;i<n;i++){
         for(int j=x;j<=i;j++){
             System.out.print(arr[j]+"\t");
         }
         System.out.println();
     }
         x++;
         
     }
 }

}