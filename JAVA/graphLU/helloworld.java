
// import java.util.Scanner;
// import java.util.PriorityQueue;
// public class helloworld{
//     public static Scanner in = new Scanner(System.in);

//      public static void main(String []args){
       
//         int t = in.nextInt();
//         while(t-->0){
//             int n = in.nextInt();
//             int m = in.nextInt();
//             PriorityQueue<Integer> pq = new PriorityQueue<>();
//             for(int i=0 ; i<=m; i++){
//                 pq.add(n^i);
//             }
//             int i=0;
//             int ans = 0;
//             while(pq.size()>0){
//                 if(pq.poll()!=i){
//                     ans = i;
//                     break;
//                 }
//                 i++;
//             }
//             System.out.println(ans);
//         }
//      }
// }

/* package codechef; // don't place package name! */

import java.util.*;
// import java.lang.*;
import java.io.*;
// #define ll long long
/* Name of the class has to be "Main" only if the class is public. */
public class helloworld
{
    public static Scanner in = new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int t = in.nextInt();
		while(t-->0){
		    int n = in.nextInt();
		    int[] arr = new int[n];
		     HashMap<Integer, Integer> hm = new HashMap<>();
		    for(int i=0; i<n; i++){
		        arr[i] = in.nextInt();
		        
		    }
            for (int ele : arr) {
                hm.put(ele, hm.getOrDefault(ele, 0) + 1);
            }
		    int z=0;
		    for(int r : hm.keySet()){
                System.out.println(hm.get(r)+" "+r);
		        if(hm.get(r)>1){
                    // System.out.println(hm.get(r)+" "+r);
		            z+=hm.get(r)-1;
		        }
		    }
		    int ans = n*(n-1) - 2*z;
		    // ans = 2*ans;
		    System.out.println(ans);
		   
		}
	}
}
