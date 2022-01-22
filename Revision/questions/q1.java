import java.util.*;
public class q1{
    public static Scanner in  = new Scanner(System.in);

    public static void solve(int cap, int[][] f, int[][] b,ArrayList<ArrayList<Integer>> ans){

    }
    public static ArrayList<int[]> solution(ArrayList<int[]> a, ArrayList<int[]> b, int target){
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();//key is sum , value is list of ids from a and b.

        for (int i = 0; i < a.size(); i ++){
            for (int j = 0; j < b.size(); j ++){
                ArrayList<int[]> sums = map.getOrDefault(a.get(i)[1] + b.get(j)[1], new ArrayList<int[]>());
                sums.add(new int[] {a.get(i)[0], b.get(j)[0]});
                map.put(a.get(i)[1] + b.get(j)[1], sums);
            }
        }

        ArrayList<Integer> allSums = new ArrayList<>();
        for (Integer i : map.keySet()){
            if (i < target){
                allSums.add(i);
            } else if (i == target){
                return map.get(target);
            }
        }
        if (allSums.size() == 0){
            return new ArrayList<>();//target is less than every possible sums.
        }
        return map.get(Collections.max(allSums));
    }


    public static void main(String args[]){
        int t = in.nextInt();
        while(t-->0){
            int capacity = in.nextInt();
            int r1 = in.nextInt();
            ArrayList<int[]> arr1 = new ArrayList<>();
            for(int i=0; i<r1; i++){
                int[] arr = new int[2];
                arr[0]= in.nextInt();
                arr[1]= in.nextInt();
                arr1.add(arr);
            }
            int r2 = in.nextInt();
            ArrayList<int[]> arr2 = new ArrayList<>();
            for(int i=0; i<r2; i++){
                int[] arr = new int[2];
                arr[0]= in.nextInt();
                arr[1]= in.nextInt();
                arr2.add(arr);
            }
            ArrayList<int[]> ans = solution(arr1, arr2, capacity);
            
            for(int i=0; i<ans.size(); i++){
                System.out.print("["+ans.get(i)[0]+", "+ans.get(i)[1]+"], ");
            }
            System.out.println();
            System.out.println();
        }
        
    }
}