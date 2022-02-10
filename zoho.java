// package question;

import java.util.*;

public class zoho{

    public static void printPattern(int[][] arr, int sr, int sc){
        int n = arr.length, m = arr[0].length;
        boolean flag = false;
        int r = sr, c= sc;
        for(int i = c; i<m; i++){
            if(i == sc && flag){
                if(sr <= n/2){
                    for(int j =0 ;j<sr; j++){
                        System.out.print(arr[j][sc]+" ");
                    }
                }else{
                    for(int j = n-1; j>sr; j--){
                        System.out.print(arr[j][sc]+" ");
                    }
                }
                break;
            }
            flag = true;
            if(r <= n/2){
                while(r<n){
                    System.out.print(arr[r++][i]+" ");
                }
                r = n-1;
            }else{
                while(r>=0){
                    System.out.print(arr[r--][i] +" ");
                }
                r = 0;
            }
            if(i == m-1){
                i = -1;
            }
        }
       
    }

    public static int[] mergetwosortedarray(int[] a, int[] b){
        int n = a.length, m = b.length;
        int[] narr = new int[n+m];
        int t = n+m, i=0, j =0;
        int k =0;
        while(t-->0){
            if(i!=n && j!=m){
                if(a[i] <= b[j]){
                    narr[k++] = a[i++];
                }else{
                    narr[k++] = b[j++];
                }
            }else if(i!=n){
                narr[k++] = a[i++];
            }else if(j!=m){
                narr[k++] = b[j++];
            }
            
        }
        return narr;
    }
    public static int[] mergesort(int[] arr, int lo, int hi){
        if(lo == hi){
            return new int[lo];
        }
        int mid = (lo+hi)/2;
        int[] lf = mergesort(arr, lo, mid );
        int[] rg = mergesort(arr, mid + 1, hi);

        return mergetwosortedarray(lf, rg);
    }

    public static int IQR(int[] arr){
        // arr = mergesort(arr, 0, arr.length-1);
        if(arr.length<=2) return -1;
        Arrays.sort(arr);
        int median = arr.length/2 + (arr.length % 2 == 0 ? -1 : 0);
        int q1 = ((median - 1)/2) + (((median -1 != 0) && (median - 1)% 2 == 0) ? 1 : 0);
        int q3 = (arr.length - median + 1)/ 2 + median +((arr.length - median + 1)%2 ==0 ? -1 : 0); 
        System.out.println(arr[q1]+" "+ arr[q3]);

        return arr[q3] - arr[q1];
    }

    public static void swap(int[] arr ,int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] =t;
    }

    public static int[] oddEven(int[] arr){
        int lo = -1, ptr = 0, n = arr.length;
        while(ptr < n){
            if(arr[ptr] % 2 == 1){
                swap(arr, ++lo, ptr);
            }
            ptr++;
        }
        for(int i=0; i<=lo; i++){
            for(int j=0; j<= lo; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
        for(int i=lo+1; i<n; i++ ){
            for(int j= lo+ 1; j<n; j++){
                if(arr[i] < arr[j]){
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int sr = in.nextInt(),  sc = in.nextInt();
        printPattern(arr, sr, sc);
        int m = in.nextInt();
        int[] arr1 = new int[m];
        for(int i=0; i<m; i++){
            arr1[i] = in.nextInt();
        }
        System.out.println();
        oddEven(arr1);
        for(int i=0; i<m; i++){
            System.out.print(arr1[i]+" ");
        }
    }
}