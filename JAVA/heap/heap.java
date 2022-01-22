package heap;

import java.util.ArrayList;

public class heap{

    private ArrayList<Integer> arr;
    private int size = 0;
//.............Constructor.........

    private void intialize(){
        this.arr = new ArrayList<>();
        this.size = 0;
    }

    public heap(){
        intialize();
    }

    public heap(int[] arr){
        intialize();
      for(int ele : arr){
          this.arr.add(ele);
      }
      for(int i= this.arr.size()-1; i>=0; i--){
          downHeapify(i);
      }
       this.size = this.arr.size();
    }

//.........Basic Functions..........

    public void add(int data){
        this.arr.add(data);
        this.size++;
        upHeapify(this.arr.size()-1);

    }

    public boolean isEmpty(){  //O(1)
        return this.size == 0;
    }

    public int remove(){  //O(logn)

        int n = this.arr.size();
        int rv = this.arr.get(0);
        swap(0,n-1);
        this.arr.remove(n-1);
        downHeapify(0);
        this.size--;
        return rv;
    }

    public int peek(){  //O(1)
        return this.arr.get(0);
    }

    public void swap(int i, int j){
        int ei = this.arr.get(i);
        int ej = this.arr.get(j);

        this.arr.set(i,ej);
        this.arr.set(j, ei);
    }
     
    public int size(){
        return this.size;
    }

    private void downHeapify(int p){
        int maxIdx = p;
        int l = 2*p+1;
        int r = 2*p+2;

        if(l<this.arr.size() && this.arr.get(maxIdx)< this.arr.get(l)){
            maxIdx = l;
        }
        if(r<this.arr.size() && this.arr.get(maxIdx)< this.arr.get(r)){
            maxIdx = r;
        }
        if(maxIdx != p){
            swap(maxIdx, p);
            downHeapify(maxIdx);
        }
    }

    private void upHeapify(int idx){  //O(logn)
        int maxIdx = idx;
        int p = (idx-1)/2;
        if(p>=0 && this.arr.get(p) < this.arr.get(maxIdx)){
            swap(maxIdx,p);
            upHeapify(p);
        }
    }

}