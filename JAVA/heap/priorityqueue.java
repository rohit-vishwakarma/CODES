package heap;

import java.util.PriorityQueue;
import java.util.*;

public class priorityqueue{
    public static Scanner in = new Scanner(System.in);
    public static void basic(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=10;i>=0;i--){
            pq.add(i);
        }
        while(pq.size()!=0){
            int ele  = pq.remove();
            System.out.print(ele+" ");
        }
    }
    //............MAX
    public static void Maxpq(){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            // return a-b;    //this -- other, default behaviour
            return b-a;  // other - this, reverse of default
        });
        for(int i=10;i>=0;i--){
          pq.add(i);
        }
        while(pq.size()!=0){
            int ele = pq.remove();
            System.out.print(ele+" ");
        }
    }
    //..........Kth largest of array
    public static void Klargest(int[]arr, int k, int n ){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        while(pq.size()!=0){
            int ele = pq.remove();
            System.out.println(ele);
        }
    }
    //.........kth smallest of array
    public static void Ksmallest(int[]arr, int k, int n ){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        while(pq.size()!=0){
            int ele = pq.remove();
            System.out.println(ele);
        }
    }
    //.............top kth frequency in integer array
    public static int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i< arr.length ; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        }
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
           return a[1]-b[1];
       });
        for(Integer ele : hm.keySet()){
            int val = ele;
            int freq = hm.get(val);
            pq.add(new int[]{val, freq});
            if(pq.size()>k){
                pq.remove();
            }
        }
        int[] ans = new int[k];
        int i=0;
        while(pq.size()!=0){
            ans[i++]=pq.remove()[0];
        }
        return ans;
    }
   //..........top kth frequency  in string array
    public static ArrayList<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
       for(int i=0; i< words.length ; i++){
           map.put(words[i], map.getOrDefault(words[i],0)+1);
       }
      PriorityQueue<String> pq = new PriorityQueue<String>((a,b)->{
          if(map.get(a)==map.get(b)){
              return b.compareTo(a);
          }
          return map.get(a)-map.get(b);
      });
       for(String ele : map.keySet()){
           pq.add(ele);
           if(pq.size()>k){
               pq.remove();
           }
       }
       ArrayList<String> ans = new ArrayList<>();
       
       while(pq.size()!=0){
           ans.add(pq.poll());
       }
       Collections.reverse(ans);
       return ans;
   }

   //................surt k sorted arrays.............

   public static void KsortedArr(int[] arr, int k){ 
     PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int ele : arr){
        pq.add(ele);
        if(pq.size() > k){
          int temp = pq.remove(); 
          System.out.println(temp);
        }
    }
    while(pq.size() !=0)
    System.out.println(pq.remove());
}

//    //............................................

//    public static void TestQ(){
//        int[] a1 = {2,3,3,4,5,6,7};
//        int[] a2 = {1,2,2,3,3,4,4};
//        int[] a3 = {-6,-3,-1,0,1,1,1};
//        int[] a4 = {5,8,8,9,11,12,13};
//        int[] a5 = {9,10,100,102,104,110,111};
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
//            return a[0]-b[0];
//        });
//        pq.add(a1);
//        pq.add(a2);
//        pq.add(a3);
//        pq.add(a4);
//        pq.add(a5);
//        while(pq.size()!=0){
//            int[] arr = pq.remove();
//        System.out.println(arr);
       
//     }
//    }
//..........................................................

   public static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> lists){
       ArrayList<Integer> rv = new ArrayList<>();
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
        return a[0] - b[0]; 
     });
     
     for(int i = 0; i < lists.size(); i++){
         pq.add(new int[] {lists.get(i).get(0), 0, i} );
     }
     
     while(pq.size() != 0){
         int[] arr =  pq.remove();
         rv.add(arr[0]);
         
         int idx = arr[1];
         int listsidx = arr[2];
         int length = lists.get(listsidx).size();
         
         if(idx + 1 < length){
             arr[1]++;
             arr[0] = lists.get(listsidx).get(idx + 1);
             pq.add(arr);
         }
     }

     return rv; 
   }



//===========================================================
    public static void main(String args[]){
        // Maxpq();
        // System.out.println();
        // basic();
        // TestQ();
    }
}