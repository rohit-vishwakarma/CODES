import java.util.*;
//ArrayList example
public class sample1{
    public static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        String str = in.nextLine();
      //  char d= in.next().charAt(0);
         String data = in.nextLine();
          char d= data.charAt(0);
        
        checkindex(str,d);
    }
    public static void checkindex(String str, char d){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==d){
                arr.add(i);
            }
        }
       // for(int ele : arr) System.out.print(ele+" ");
     //   for(int i=0;i<arr.size();i++){
         //   System.out.print(arr.get(i)+"\t");
       // }
        if(arr.size()==0){
            System.out.print(d+" is not in the given String.");
        }
        else{
            System.out.println(arr);
        }
    }
}