import java.io.*;
import java.util.*;

public class Main{
public static Scanner in=new Scanner(System.in);
public static void main(String[] args) throws Exception {
    // write your code here
    int n=in.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++)
       arr[i]=in.nextInt();
    int d=in.nextInt();
    operation(n,arr,d);
 }
  public static void operation(int n, int[] arr, int d){
      int x=0;
      for(int i=0;i<n;i++){
          if(arr[i]>d){
              x=i;
              break;
          }
      }
      System.out.println(arr[x]+"\n"+arr[x-1]);
  }

}