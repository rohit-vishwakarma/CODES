import java.util.*;
public class stack{
    protected int[] arr = null;
    protected int size =0;
    protected int capacity = 0;
    protected int tos = -1;

    // Intialising stack ..............................................
    protected void intiVar(int capacity){
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.size= 0;
        this.tos = -1;
    }
    //constructors of stack............................................
    public stack(){
        intiVar(10);
    }
    public stack(int capacity){
        intiVar(capacity);
    }
    //Exceptions of stack...............................................
     private void underFlow() throws Exception {
         if(this.tos == -1){
             throw new Exception("StackIsEmpty");
         }
     }
     private void overFlow() throws Exception{
         if(this.capacity == this.size){
             throw new Exception("StackIsFull");
         }
     }

    //basic functions of stack...........................................
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.capacity==0;
    }
    public void display(){
        for(int p=this.tos ; p>=0; p--){
            System.out.print(this.arr[p]+" ");
        }
    }
    public int top(){
        // underFlow();
        return this.arr[this.tos];
    }
    //stack functions....................................................
    public void push(int data) throws Exception{
        overFlow();
        pushD(data);
    }
    protected void pushD(int data){
        this.arr[++this.tos]= data;
        this.size++;
    }
    public int pop() throws Exception{
        underFlow();
        return poped();
    }
    protected int poped(){
    int val = this.arr[this.tos];
    this.arr[this.tos]=0;
       this.tos--;
       this.size--;
       return val;
    }
}