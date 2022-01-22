import java.io.*;
import java.util.*;

public class arrinver{
  public static Scanner in=new Scanner(System.in);
  public static void main(String args[]){
      int n=in.nextInt();
      int[] arr= new int[n];
      int[] temp=new int[n];
      for(int i=0;i<n;i++){
          arr[i]=in.nextInt();
          temp[i]=i;
      }
       for(int i=0;i<n;i++){
       for(int j=0;j<n;j++){
           if(i==arr[j]){
               temp[i]=j;
           }
       }
   }
   for(int i=0;i<n;i++){
      System.out.println(temp[i]);
   }
  }
}