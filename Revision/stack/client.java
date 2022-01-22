public class client extends dynamicStack{
    public static void main(String args[]) throws Exception{
        // dynamicStack st = new dynamicStack();
        // for(int i =0;i<111; i++){
        //     st.push(i);
        // }
        int[] arr = {1,2,3,3,4,5,6,6,4,1,2,3,3,4,5,6,6,4,1,2,3,3,4,5,6,6,4};
        // st.dynamicPush
        dynamicStack st = new dynamicStack(arr.length);
        st.dynamicPush(arr);

        st.display();
        // System.out.print(st);
    }
}