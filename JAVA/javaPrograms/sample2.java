//Sub Sequence
import java.util.*;
public class sample2{
    public static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        String str = in.nextLine();
        subseq(str);
    }
    public static void subseq(String str){
      ArrayList<String> ans = new ArrayList<>();
      ans.add("");
      for(int i=0;i<str.length();i++){
          char ch= str.charAt(i);
          int size = ans.size();
          for(int j=0;j<size;j++){
              ans.add(ans.get(j)+ch);
          }
      }
      System.out.println(ans);
    }
}