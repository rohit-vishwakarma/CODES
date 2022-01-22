
import  java.util.*;
public class unionquestion{
    //695

    public static int[] par,size;
    
    public static int findPar(int u){
        return par[u]==u?u:(par[u]=findPar(par[u]));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        if(n==0 || m==0) return 0;
        
        par=new int[n*m];
        size=new int[n*m];
        
        // int count=0;
        int maxSize=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // if(grid[i][j]==1){
                //     count++;
                // }
                par[i*m+j]=i*m+j;
                size[i*m+j]=1;
            }
        }
        
        int[][] dir={{1,0},{0,1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int p1=findPar(i*m+j);
                    for(int d=0;d<2;d++){
                        int r=i+dir[d][0];
                        int c=j+dir[d][1];
                        
                        
                        if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1){
                            int p2=findPar(r*m+c);
                            if(p1!=p2){
                                par[p2]=p1;
                                size[p1]+=size[p2];
                                // count--;
                            }
                        }
                    }
                    
                    maxSize=Math.max(maxSize,size[p1]);
                }
            }
        }
        
        return maxSize;
    }
    //1061
    // public static int[] par;

    public static String smallestEquivalentString(String A,String B,String S){
            par=new int[26];
            for(int i=0; i<26; i++){
                par[i]=i;
               
            }
            for(int i=0;i<A.length();i++){
                int a=A.charAt(i) - 'a';
                int b=B.charAt(i) -'a';
                int p1=findPar(a);
                int p2=findPar(b);

                if(p1!=p2){
                    union(a,b);
                }
        }

        String str ="";
            for(int i=0;i<S.length();i++){
                int c=findPar(S.charAt(i) -'a');
                str+= (char)('a' +c);
            }

            return str;
        }

    // public static int findPar(int u){
    //         if(par[u]==u){
    //             return u;
    //         }
    //         par[u]=findPar(par[u]);
    //         return par[u];
    // }

    public static void union(int a,int b){
            int p1=findPar(a);
            int p2=findPar(b);
            if(p1<p2){
                par[p2]=p1;
            }else{
                par[p1]=p2;
            }
    }
    // 990
    public static boolean equationsPossible(String[] equations) {
        int n = equations.length;
        par = new int[26];
        size = new int[26];
        for(int i=0; i<26; i++){
            par[i]=i;
            size[i] =1;
        }
        
        for (int i = 0; i < n; i++) {
		    String str = equations[i];
		     int val1 = str.charAt(0) - 'a';
		     int val2 = str.charAt(3) - 'a';
		     if (str.substring(1, 3).equals("==")) {
		    	unionfind(val1, val2);
		     }
		 
	     }
	    for (int i = 0; i < n; i++) {
		     String str = equations[i];
		     int val1 = str.charAt(0) - 'a';
		     int val2 = str.charAt(3) - 'a';
		     if (str.substring(1, 3).equals("!=")) {
		    	int x = findPar(val1);
		    	int y = findPar(val2);
			    if (x == y) {
			       return false;
			    }
		     }
	      }
	  return true;
        
    }
    
    public static void unionfind(int x, int y) {
	  int i = findPar(x);
	  int j = findPar(y);
	  if (i != j) {
		 if (size[i] > size[j]) {
			par[j] = i;
		 } else if (size[j] > size[i]) {
			par[i] = j;
		 } else {
			par[i] = j;
			size[j]++;
		 }
	  }
   }
// 839
public int numSimilarGroups(String[] strs) {
    if(strs.length ==0) return 0;
    int n = strs.length;
    par =  new int[n]; int group =n;
    for(int i=0; i<strs.length; i++){
        par[i] = i;
    }
    for(int i = 0; i < strs.length; i++) {
        String X = strs[i];
        for(int j = i + 1; j < strs.length; j++) {
            String Y = strs[j];
            if(isSim(X, Y)) {
                int p1 = findPar(i);
                int p2 = findPar(j);
                
                if(p1 != p2) {
                    par[p2] = p1;
                    group--;
                }
            }
        }
    }
    
    return group;
}

public boolean isSim(String X, String Y) { 
    int count = 0;
    
    for(int i = 0; i < X.length(); i++) {
        if(X.charAt(i) != Y.charAt(i)) {
            count++;
            if(count > 2) {
                return false;
            }
        }
    }
    return true;
}
// 684 
public int[] findRedundantConnection(int[][] edges) {
    int n=edges.length;
    
    par=new int[n+1];
    int ans[] = null;
    for(int i = 0; i < par.length; i++)
        par[i] = i;        
    
    
    for(int e[] : edges)
    {
        int u = e[0];
        int v = e[1];
        
        int p1 = findPar(u);
        int p2 = findPar(v);
        
        if(p1 != p2)   
            par[p2] = p1;
        else{
            ans = e;
           break;}
    }
    return ans;

}

// MR. President hackerearth

public int mrPresident(int[][] edges, int N, int K) {
    par = new int[N + 1];
    for (int i = 0; i <= N; i++) {
        par[i] = i;
    }

    Arrays.sort(edges, (a, b) -> {
        return a[2] - b[2];
    });

    ArrayList<Integer> roads = new ArrayList<>();

    int components = N, mcost = 0;
    for (int[] e : edges) {
        int u = e[0], v = e[1], w = e[2];
        int p1 = findPar(u), p2 = findPar(v);
        if (p1 != p2) {
            par[p1] = p2;
            components--;
            mcost += w;
            roads.add(w);
        }
    }

    if (components > 1)
        return -1;

    int superroad = 0;
    for (int i = roads.size() - 1; i >= 0; i--) {
        if (mcost <= K)
            break;
        mcost = mcost - roads.get(i) + 1;
        superroad++;
    }

    return mcost <= K ? superroad : -1;
}

    //959 - regions cut by slashes
    public int regionsBySlashes(String[] grid) {
        int n = grid.length, m = n+1, region =1 ;
        par = new int[m*m];
        for(int i=0; i<par.length; i++){
            par[i] = i;
            int r = i/m, c= i%m;
            if(r==0 || c==0 || r==m-1 || c== m-1){
                par[i] =0;
            }
        }
        for(int i=0; i<n; i++){
            String str = grid[i];
            for(int j=0; j<str.length(); j++){
                char ch = str.charAt(j);
                int p1 = 0, p2 = 0; 
                if(ch == '/'){
                    p1 = findPar((i*m)+ j+1);
                    p2 = findPar((i+1)*m + j);
                }else if(ch == '\\'){
                    p1 = findPar(i*m+j);
                    p2 = findPar((i+1)*m + j+1);
                }else{
                    continue;
                }
                if(p1!=p2){
                    par[p1] = p2;
                }
                else{
                    region++;
                }
            }
        }
        return region;
    }



   public static void main(String[] args){
       String A ="parker";
       String b ="morris";
       String base ="parser";
       String ans = smallestEquivalentString(A,b,base);
       System.out.println(ans);
   }
}