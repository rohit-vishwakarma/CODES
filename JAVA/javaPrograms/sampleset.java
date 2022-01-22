import java.io.*;
import java.util.*;

public class sampleset{

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
       int x= printTargetSumSubsets(a, 0, "", 0,"",0);
       System.out.println(x);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static int printTargetSumSubsets(int[] arr, int idx, String setA, int sos1,String setB,int sos2) {

        if (idx == arr.length) {
            if (sos1 == sos2) {
                System.out.println(setA+"\t=\t"+setB);
                return 1;
            }
            return 0;
        }
        int count=0;

        count+=printTargetSumSubsets(arr, idx + 1, setA + arr[idx]+" " , sos1 + arr[idx],setB, sos2 );
        count+=printTargetSumSubsets(arr, idx + 1, setA , sos1 ,setB + arr[idx]+" " , sos2 + arr[idx]);
        
        return count;
    }

}