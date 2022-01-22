package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class graph{

    public static class Edge{
        int v=0;
        int w=0;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        public String toString(){
            return "("+ this.v +", "+ this.w +")";
        }
    }

    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    public static void display(){
        for(int i =0 ; i<N; i++){
            System.out.print(i+" -> ");
            for(Edge e: graph[i]){
                System.out.print(e);
            }
            System.out.println();
        }
    }

    public static int findEdge(int u, int v){
        int i =0;
       for(Edge e: graph[u]){
        if(e.v == v){
            return i;
        }
        i++;
       }
       return -1;
    }

    public static void removeEdge(int u, int v){
        int idx1 = findEdge(u,v);
        int idx2 = findEdge(v,u);

        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }

    public static void removeVertex(int u){
        while(graph[u].size()!= 0){
            int n = graph[u].size();
            Edge e = graph[u].get(n-1);
            removeEdge(u,e.v);
        }
    }

    public static boolean hasPath(int src, int des, boolean[] vis){
        if(src == des) return true;
        boolean res = false;
        vis[src] = true;
        for(Edge e: graph[src]){
            if(!vis[e.v]){
                res = res || hasPath(e.v, des, vis);
            }
        }
        return res;
    }

    public static int allPath(int src, int des, boolean[] vis, String ans){
        if(src == des){
            System.out.println(ans + des);
            return 1;
        }
        int count=0;  
        vis[src] = true;
        for(Edge e: graph[src]){
            if(!vis[e.v]){
                count += allPath(e.v, des, vis, ans + src);
            }
        }
        vis[src]= false;
        return count;
    }

    public static void printPreOrder(int src, boolean[] vis, String ans, int wsf){
        System.out.print(src + " -> " + ans + src + "@" + wsf);
        vis[src] = true;
        for(Edge e: graph[src]){
            if(!vis[e.v]){
                printPreOrder(e.v,vis, ans+ vis, e.w);
            }
        }
        vis[src]= false;
    }

    public static void printPostOrder(int src, boolean[] vis, String ans, int wsf){
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
            printPostOrder(e.v, vis, ans + src, wsf + e.w);
        }
        System.out.print(src + " -> " + ans + src + "@" + wsf);
        vis[src] = false;
    }

    public static void getConnectedComponent(ArrayList<Edge>[] graph) {  
        int components = 0, N = graph.length;
        boolean[] vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                components++;
                dfsGCC(graph, i, vis);
            }
        }

        System.out.println(components);
    }

    public static void dfsGCC(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                dfsGCC(graph, e.v, vis);
        }
    }

    public static class Pair{
        int largestWeight = -(int)1e9;
        String largestPath = "";
        int smallestWeight = (int)1e9;
        String smallestPath = "";

        int ceil = (int)1e9;
        int floor = -(int)1e9;
    }

    public static class pair {
        int largestWeight = -(int) 1e9;
        String largestPath = "";
        int smallestWeight = (int) 1e9;
        String smallestPath = "";

        int ceil = (int) 1e9;
        String ceilPath = "";
        int floor = -(int) 1e9;
        String floorPath = "";

    }

    public static class pqPair {
        int wsf = 0;
        String psf = "";

        pqPair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }
    }

    static PriorityQueue<pqPair> pq = new PriorityQueue<>((a, b) -> {
        return a.wsf - b.wsf;
    });

    public static void allSolution(int src, int dest, boolean[] vis, pair p, String psf, int wsf, int givenWeight,
            int k) {

        if (src == dest) {
            if (wsf > p.largestWeight) {
                p.largestWeight = wsf;
                p.largestPath = psf + dest;
            }

            if (wsf < p.smallestWeight) {
                p.smallestWeight = wsf;
                p.smallestPath = psf + dest;
            }

            if (wsf < givenWeight)
                if (wsf > p.floor) {
                    p.floor = wsf;
                    p.floorPath = psf + dest;
                }
            if (wsf > givenWeight)
                if (wsf < p.ceil) {
                    p.ceil = wsf;
                    p.ceilPath = psf + dest;
                }

            pq.add(new pqPair(wsf, psf + dest));
            if (pq.size() > k)
                pq.remove();

            return;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                allSolution(e.v, dest, vis, p, psf + src, wsf + e.w, givenWeight, k);
        }

        vis[src] = false;
    }

    public static void main(String[] args){
        for(int i =0 ;i<N ; i++) graph[i] = new ArrayList<>();
        addEdge(0, 1, 10);
        addEdge(0, 3, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(3, 4, 10);
        addEdge(4, 5, 10);
        addEdge(4, 6, 10);
        addEdge(5, 6, 10);
        boolean[] vis = new boolean[N];
        // printPreOrder(0, vis);
        System.out.println();
        System.out.println(findEdge(1,6));
        display();
        removeEdge(0,1);
        System.out.println();
        display();
        // removeVertex(0);
        System.out.println();
        display(); 
        // boolean[] vis = new boolean[N];
        System.out.println(hasPath(1, 6, vis));
    }
}