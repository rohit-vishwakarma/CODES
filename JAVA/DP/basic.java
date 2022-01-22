package DP;

import java.util.LinkedList;
public class basic {
    
    public static int fibo_memo(int n, int[] dp){
       
        if(n<=1){
            return dp[n]=1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int ans = fibo_memo(n-1, dp) + fibo_memo(n-2, dp);
        return dp[n]=ans;
    }

    public static int fibo_DP(int N, int[] dp){
        for(int n =0 ; n<=N; n++){
            if(n<=1){
                dp[n]=1;
                continue;
            }
            int ans = dp[n-1]+ dp[n-2];
            dp[n]=ans;
        }
        return dp[N];
    }

    public static int fibo_opti(int n){
        int a=0, b=1;
        for(int i=0; i<n ;i++){
            System.out.print(a+" ");
            int sum = a+b;
            a=b; 
            b=sum;
        }
        return a;
    }

    public static void fibo(){
        int n = 6;
        int[] dp = new int[n+1];
        // fibo_memo(n,dp);
        fibo_DP(n,dp);
        System.out.println(fibo_opti(n));
        print(dp);
    }
    public static void print(int[] arr){
        for(int ele: arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
    public static void print2D(int[][] arr) {
        for (int[] a : arr) {
            print(a);
        }
        System.out.println();
    }

    public static int boardpath_memo(int n, int[] dp){
        if(n==0){
            return dp[n]=1;
        }
        if(dp[n]!=0) return dp[n];

        int count =0;
        for(int dice = 1 ; dice <= 6 && n - dice >=0 ; dice++){
            count+= boardpath_memo(n-dice, dp);
        }
        return dp[n] = count;
    }

    public static int boardpath_DP(int N, int[] dp){
       
        for(int n = 0; n<=N ; n++){
        if(n==0){
             dp[n]=1;
             continue;
        }
        // if(dp[n]!=0) return dp[n];

        int count=0;
        for(int dice = 1 ; dice <= 6 && n - dice >=0 ; dice++){
            count+= dp[n-dice];
        }
        dp[n]=count;
     }
        return dp[N];
    }

    public static void boardpath_opti(int n ){
       LinkedList<Integer> ll = new LinkedList<>();
       int a = 1, b=1;
       ll.addLast(a);
       ll.addLast(b);
        for(int i = 2; i<=n ; i++){
             if(ll.size()>=7){
                 int x = ll.removeFirst();
                 ll.addLast(ll.getLast()*2 -x);
             } else{
                 ll.addLast(ll.getLast()*2);
             }  
        }
        System.out.println(ll);
    }


    public static void boardpath(){
        int n = 10;
        int[] dp = new int[n+1];
        // System.out.println(boardpath_memo(n, dp));
        System.out.println(boardpath_DP(n, dp));
        print(dp);
        boardpath_opti(n);
    }


    public static void main(String args[]){
        // fibo();
        boardpath();
    }
}
