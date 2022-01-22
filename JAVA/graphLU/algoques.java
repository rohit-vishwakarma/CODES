// package graphLU;

import java.util.*;
public class algoques{
    public static class Edge{
        int v= 0, w= 0;
        Edge(int v, int w){
            this.v = v;
            this.w=w;
        }
    }
    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    public static void display(ArrayList<Edge>[] graph){
        int n = graph.length;
        for(int i=0; i< n; i++){
            System.out.print(i+" -> ");
            for(Edge e: graph[i]){
                System.out.print("(" + e.v +", "+e.w+")");
            }
            System.out.println();
        }
    }
    public static int[] par, size;
    
    public static int findPar(int u){
        if(par[u] == u)
            return u;
        return par[u] = findPar(par[u]);
    }
    
    public static void union(int p1, int p2){
        if(size[p1]<size[p2]){
            par[p1] = p2;
            size[p2] += size[p1];
        }else{
            par[p2] = p1;
            size[p1] =+ size[p2];
        }
    }
    
        
    public static void unionFind(int[][] edges, ArrayList<Edge>[] graph , int n){
       
        par = new int[n];
        size = new int[n];
    
        for(int i=0; i<n ;i++){
            par[i] = i;
            size[i]=1;
        }
    
        for(int[] e: edges){
            int u = e[0], v= e[1], w = e[2];
            int p1 = findPar(u);
            int p2 = findPar(v);
    
            if(p1!=p2){
                union(p1,p2);
                addEdge(graph, u, v, w);
            }
        }
    }
    public static void kruskalAlgo(int[][] edges, int N){
        Arrays.sort(edges, (a,b)->{
            return a[2]-b[2];
        });
        
        ArrayList<Edge>[] graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        unionFind(edges, graph, N);
    }


    // leetcode - optimize water supply in a village
    //findpar(int u) and int[] par;
    public static int minCostSupplyWater(int n, int[] wells, int[][] pipes){
        ArrayList<int[]> allpipes = new ArrayList<>();
        for(int[] a: pipes) allpipes.add(a);
        for(int i=0; i<wells.length; i++){
            allpipes.add(new int[]{0, i+1, wells[i]});
        }

        Collections.sort(allpipes, (a,b)->{
            return a[2]-b[2]; // weight in 2nd index
        });

        par = new int[n+1];
        int ans = 0;

        for(int i=0; i<=n; i++){
            par[i] = i;
        }
        
        for(int[] e: allpipes){
            int u = e[0], v= e[1], w = e[2];
            int p1 = findPar(u);
            int p2 = findPar(v);
    
            if(p1!=p2){
               par[p1] = p2;
               ans += w;
            }
        }
        return ans ;
    }

    //1192
    public int[] low, disc;
    public boolean[] vis;
    public int time =0, calls = 0;
    
    public void dfs(ArrayList<Integer>[] graph, int src, int par, List<List<Integer>> ans ){
        disc[src] = low[src] =time++;
        vis[src] = true;
        for(Integer v : graph[src]){
            if(!vis[v]){
                if(par == -1)
                    calls++;
                dfs(graph, v, src, ans);
                if(disc[src] < low[v]){
                    List<Integer> edge=new ArrayList<>(Arrays.asList(src,v));
                    ans.add(edge);
                }
                     
                
                low[src] = Math.min(low[src], low[v]);
            }else if(v!= par){
                low[src] = Math.min(low[src], disc[v]);
            }
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
         ArrayList<Integer>[] graph=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(List<Integer> ar:connections){
            graph[ar.get(0)].add(ar.get(1));
            graph[ar.get(1)].add(ar.get(0));
        }
        low = new int[n];
        disc = new int[n];
        vis = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i =0; i<n; i++){
            if(!vis[i]){
                dfs(graph, i, -1, ans);
            }
        }
        return ans;
    }

    //==========================================================
    //743
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] graph = new ArrayList[n+1];
         for(int i= 0 ; i<=n ; i++) graph[i] = new ArrayList<>();
         for(int[] time : times){
             int u = time[0], v = time[1], w = time[2];
             graph[u].add(new int[]{v,w});
         }
         int[] dis = new int[n+1];
         Arrays.fill(dis, (int)1e9);
         
         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
             return a[1]-b[1];
         });
         
         pq.add(new int[]{k,0});
         dis[k] = 0;
         while(pq.size()!=0){
             int[] rq = pq.remove();
             int vtx = rq[0], wsf = rq[1];
             
             if(wsf > dis[vtx]) continue;
             
             for(int[] e : graph[vtx]){
                 int v = e[0], w = e[1];
                 if(wsf + w < dis[v]){
                     dis[v] = wsf + w;
                     pq.add(new int[]{v, wsf + w});
                 }
             }
         }
         int max = 0;
         for(int i =1; i<=n; i++){
             if(dis[i] == (int)1e9) return -1;
             max = Math.max(max, dis[i]);
         }
         return max;
     }

     // 787
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // {v,w}
        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] f : flights) {
            int u = f[0], v = f[1], w = f[2];
            graph[u].add(new int[] { v, w });
        }

        // {vtx,cost,edgesCount}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        pq.add(new int[] { src, 0, k + 1 });
        while (pq.size() != 0) {

            int[] rp = pq.remove();
            int vtx = rp[0], cost = rp[1], edgesCount = rp[2];

            if (edgesCount < 0)
                continue;

            if (vtx == dst)
                return cost;

            for (int[] e : graph[vtx]) {
                int v = e[0], w = e[1];
                pq.add(new int[] { v, cost + w, edgesCount - 1 });
            }
        }

        return -1;
    }

    // 787
    public int findCheapestPrice02(int N, int[][] flights, int src, int dst, int K) {
        int[] prev = new int[N];
        Arrays.fill(prev, (int) 1e9);
        prev[src] = 0;

        for (int i = 1; i <= K + 1; i++) {
            int[] curr = new int[N];
            for (int j = 0; j < N; j++)
                curr[j] = prev[j];

            boolean anyUpdate = false;
            for (int[] e : flights) {
                int u = e[0], v = e[1], w = e[2];
                if (prev[u] != (int) 1e9 && prev[u] + w < curr[v]) {
                    curr[v] = prev[u] + w;
                    anyUpdate = true;
                }
            }

            if (!anyUpdate)
                break;

            prev = curr;
        }

        return prev[dst] != (int) 1e9 ? prev[dst] : -1;
    }

    
}