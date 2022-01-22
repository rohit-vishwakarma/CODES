import java.io.*;
import java.util.*;

public class mergeTwosortedArr{

    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        //write your code here
        if(a.length==0 || b.length==0){
            if(a.length!=0) return a;
            else return b;
        }
        int n=a.length,m=b.length;
        int[] res= new int[n+m];
        int i=0,j=0,k=0;
        while(i<n && j<m){
             if(a[i]<b[j])
                res[k++]=a[i++];
            else
                res[k++]=b[j++];
                // System.out.print("->"+res[k-1]);
        }
        while(i<n){
            res[k++]=a[i++];
        }
        while(j<m){
            res[k++]=b[j++];
        }
        
        return res;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }

}