import java.io.*;
import java.util.*;

public class arrot{
public static Scanner in=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
        int n=in.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++)
         for(int j=0;j<n;j++)
           arr[i][j]=in.nextInt();
          display(arr);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = arr[0].length -1 ; j >=0; j--){
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }

}