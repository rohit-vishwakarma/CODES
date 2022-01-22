package heap;

public class heapSort{

    public static void HeapSort(int[] arr, boolean order){
        int n = arr.length;
        for(int i= n/2-1; i>=0; i--){
            heapify(arr,n,i,order);
        }
        for(int i= n-1; i>0; i--){
            swap(arr,i,0);
            heapify(arr,i, 0,order);
        }       
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void display(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }

    public static int compareTo(int[] arr, int a,int b, boolean isMax){
        if(isMax){
            return arr[a] - arr[b];
        }else{
            return arr[b] - arr[a];
        }
    }

    public static void heapify(int[] arr,int n, int i, boolean isMax){
      
        int max = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l < n && compareTo(arr,max,l, isMax)>0)
         max = l;
        if(r< n && compareTo(arr,max,r, isMax)>0)
        max = r;
        if(max!=i){
            swap(arr,max,i);
            heapify(arr,n,max,isMax);
        }
    }

    public static void main(String[] args){
        int[] arr = {10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13};
        HeapSort(arr,false); // true = Descending .... false = Ascending
        display(arr);
       
    }

}