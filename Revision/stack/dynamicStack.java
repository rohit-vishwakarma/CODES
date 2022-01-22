public class dynamicStack extends stack{
    public dynamicStack(){
        super();
    }
    public dynamicStack(int capacity){
        super(capacity);
    }
    public void dynamicPush(int[] arr){
        super.intiVar(2*arr.length);
        for(int ele : arr){
            super.pushD(ele);
        }
    }
    public void display(){
    super.display();}
}