import java.util.*;
public class questions {
    public static void EqualDistance(){
        int n = in.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i =0; i<n; i++){
            arr[i] = in.nextInt();
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }
        int min = -(int)1e9;
        for(int e: hm.keySet()){
            int x = hm.get(e);
            if(x>min){
                min = x;
                // System.out.println(e);
            }
        }
        int res = n-min;
        if(n<=2){
            res =0;
        }
        else if(min == 1){ res= n-2;}
        System.out.println(res);

    }
    public static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        int t = in.nextInt();
        while(t-->0)
          EqualDistance();
    }
}
