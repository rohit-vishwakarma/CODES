// package graphLU;

import java.util.ArrayList;
import  java.util.LinkedList;
public class graph{
    public static class Edge{
        int v=0;
        int w=0;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }
    
    public static void display(ArrayList<Edge>[] graph) {  //O(2E)
        int N = graph.length;
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("( " + e.v + ", " + e.w + ") ");
            }
            System.out.println();
        }
    }
    public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {   // O(E) 
        ArrayList<Edge> list = graph[u];
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);
            if (e.v == v)
                return i;
        }
        return -1;
    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v) {   //O(E)
        int idx = findEdge(graph, u, v);
        graph[u].remove(idx);

        idx = findEdge(graph, v, u);
        graph[v].remove(idx);
    }

    // O(E) :- where E is total no of Edges in that particular component.
    public static boolean dfsfindPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest)
            return true;

        vis[src] = true;
        boolean res = false;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                res = res || dfsfindPath(graph, e.v, dest, vis);
        }

        return res;
    }
// all path
    public static int printAllPath(ArrayList<Edge>[] graph, int src, int dest, String psf, int wsf, boolean[] vis) {
        if (src == dest) {
            System.out.println(psf + dest + " @ " + wsf);
            return 1;
        }

        vis[src] = true;
        int count = 0;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                count += printAllPath(graph, e.v, dest, psf + src, wsf + e.w, vis);
        }
        vis[src] = false;

        return count;
    }

    public static void dfsGCC(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                dfsGCC(graph, e.v, vis);
        }
    }

    // GCC    
    public static void getConnectedComponent(ArrayList<Edge>[] graph) {  //O(E+V)
        int components = 0;
        int n = graph.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                components++;
                dfsGCC(graph, i, vis);
            }
        }

        System.out.println(components);
    }
     // O(E)
     public static void BFS_forCycle(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        LinkedList<Integer> que = new LinkedList<>();
        int level = 0;
        boolean iscycle = false;

        que.add(src);
        while (que.size() != 0) {
            int size = que.size();
            System.out.print("Min No Edges: " + level + " -> ");
            while (size-- > 0) {
                int rvtx = que.removeFirst();

                if (vis[rvtx]) {
                    iscycle = true;
                    continue;
                }

                System.out.print(rvtx + ", ");
                vis[rvtx] = true;
                for (Edge e : graph[rvtx]) {
                    if (!vis[e.v])
                        que.addLast(e.v);
                }
            }
            System.out.println();
            level++;
        }
    }

    // O(v)
    public static void BFS_withoutCycle(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        LinkedList<Integer> que = new LinkedList<>();
        int level = 0;

        que.add(src);
        vis[src] = true;
        while (que.size() != 0) {
            int size = que.size();
            System.out.print("Min No Edges: " + level + " -> ");
            while (size-- > 0) {
                int rvtx = que.removeFirst();

                System.out.print(rvtx + ", ");
                for (Edge e : graph[rvtx]) {
                    if (!vis[e.v]) {
                        vis[e.v] = true;
                        que.addLast(e.v);
                    }
                }
            }
            System.out.println();
            level++;
        }
    }

    public static void constructGraph() {
        int N = 7;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        addEdge(graph, 0,6,7);
        addEdge(graph, 0,1,2);
        addEdge(graph, 1,2,3);
        addEdge(graph, 1,3,3);
        addEdge(graph, 6,3,3);
        addEdge(graph, 3,5,1);
        addEdge(graph, 6,5,1);
        addEdge(graph, 2,5,1);
        addEdge(graph, 0,4,5);
        addEdge(graph,4,6,2);

        display(graph);
        boolean[] vis = new boolean[N];
        // System.out.println(dfsfindPath(graph, 0, 6, vis));
        System.out.println();
        System.out.println(printAllPath(graph, 0, 6, "", 0, vis));
    }

    public static void main(String[] args) {
        constructGraph();
    }
}
