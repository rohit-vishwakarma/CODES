import java.io.*;
import java.util.*;

public class strpermut{

	public static void solution(String str){
		// write your code here
		ArrayList<String> ans = new ArrayList<>();
		ans.add(str.charAt(0)+"");
		
		for(int i=1; i<str.length();i++){
		    char ch= str.charAt(i);
		    ArrayList<String> smallAns = new ArrayList<>();
		    for(String s: ans){
                // smallAns.addAll(function_name(s,ch))
		        for(int j=0;j<=s.length();j++){
		            String ns= s.substring(j)+ ch + s.substring(0,j);
		            smallAns.add(ns);
		        }
		    }
		    ans=smallAns;
		}
		for(String s: ans){
		    System.out.println(s);
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}