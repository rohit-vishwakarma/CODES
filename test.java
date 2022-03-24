import java.util.*;
public class test{
    public static Scanner in = new Scanner(System.in);

    // public static String helper(String s){
    //     if(s.length() < 3) return s;
    //     String ans = s;
    //     for(int i=0; i<s.length()-3; i++){
    //         String ss = s.substring(i,i+3);
    //         // System.out.println("ss "+ss);
    //         if(ss.equals("AWS")){
    //             String fp = s.substring(0,i);
                
    //         // System.out.println("fp "+fp);
    //             String sp = s.substring(i+3);
                
    //         // System.out.println("sp "+sp);
    //             ans = helper(fp+sp);
    //             break;
    //         }
    //     }
    //     // System.out.println("ans"+ans);
    //     return ans.equals("AWS") ? "-1" : ans;
    // }

    // public static String removeAWS(){
    //     String str = in.nextLine();

    //     String ans = helper(str);

    //     return ans;
    // }
        
    public static void zen(){
        String str = "ROHITROHIT";
        solvezen(str, 0, "");
    }

    public static void solvezen(String s, int idx, String asf){
        if(s.length() <= idx){
            System.out.println(asf);
            return;
        }
        char pc = ']';
        if(asf.length() > 0) pc = asf.charAt(asf.length()-1);
        char curr = s.charAt(idx);
        if(idx == 0 || curr <= pc){
            solvezen(s, idx + 1, asf + curr);
        }else{
            int count = 1;
            int i = 0;
            for(i = idx + 1 ; i<s.length(); i++){
                if(curr == s.charAt(i)){
                    count++;
                }else{
                    break;
                }
            }
            if(count == 1){
                solvezen(s, idx + 1, asf + curr);
            }else{
                solvezen(s, i, asf);
            }
        }
    }

    public static long prison(int n, int m, int[] hor, int[] ver){
        boolean[] xs = new boolean[n+1];
        boolean[] ys = new boolean[m+1];
        for(int ele: hor) xs[ele] = true;
        for(int ele : ver) ys[ele] = true;
        int xm = 0, ym =0;
        for(int i =1, j=0; i<=n; i++){
            if(!xs[i]) j=0;
            else xm = Math.max(xm, ++j);
        }
        for(int i =1, j=0; i<=m; i++){
            if(!ys[i]) j=0;
            else ym = Math.max(ym, ++j);
        }

        return (long)(xm +1) * (ym+1);

    }


    public static void main(String[] args){
        // System.out.println(removeAWS());
        zen();
    }
}