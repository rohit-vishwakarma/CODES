import java.io.*;
import java.util.*;

public class arr2dsear {
public static Scanner in=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
        int n=in.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++)
         for(int j=0;j<n;j++)
             arr[i][j]=in.nextInt();
        int d=in.nextInt();
        operation(n,arr,d);
    }
    public static void operation(int n, int[][] arr, int d){
        int i=n-1, j=0;
        while(i>=0 && j<arr[0].length){
            if(arr[i][j]==d){
                System.out.println(i+"\n"+j);
                return;
            }else if(arr[i][j]<d){ j++;
                
            }
            else i--;
        }
        System.out.println("Not Found");
    }

}