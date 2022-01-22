import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class graph {
    public static class Edge {
        int v = 0, w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public String toString() {
            return "(" + this.v + ", " + this.w + ")";
        }
    }

    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int v, int u, int w) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static void display() {
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

    public static int findEdge(int u, int v) {
        for (int i = 0; i < graph[u].size(); i++) {
            Edge e = graph[u].get(i);
            if (e.v == v) {
                return i;
            }
        }
        return -1;
    }

    public static void removeEdge(int u, int v) {
        int idx1 = findEdge(u, v);
        int idx2 = findEdge(v, u);
        if (idx1 == -1 || idx2 == -1) {
            return;
        }
        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }

    public static void removeVtx(int u) {
        while (graph[u].size() != 0) {
            int n = graph[u].size();
            Edge e = graph[u].get(n - 1);
            removeEdge(u, e.v);
        }
    }

    public static boolean hasPath(int src, int dest, boolean[] vis) {
        if (src == dest)
            return true;
        vis[src] = true;
        boolean res = false;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                res = res || hasPath(e.v, dest, vis);
            }
        }
        return res;
    }

    public static int allPath(int src, int dest, boolean[] vis, String ans) {
        if (src == dest) {
            System.out.println(ans + dest);
            return 1;
        }
        vis[src] = true;
        int count = 0;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                count += allPath(e.v, dest, vis, ans + src);
            }
        }
        vis[src] = false;
        return count;
    }

    public static void preOrder(int src, boolean[] vis, String ans, int wsf) {
        System.out.println(src + " -> " + ans + src + "@" + wsf);
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                preOrder(e.v, vis, ans + src, wsf + e.w);
            }
        }
        vis[src] = false;
    }

    public static void postOrder(int src, boolean[] vis, String ans, int wsf) {

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                postOrder(e.v, vis, ans + src, wsf + e.w);
            }
        }
        System.out.println(src + " -> " + ans + src + "@" + wsf);
        vis[src] = false;
    }

    public static class Pair {
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

    public static PriorityQueue<pqPair> pq = new PriorityQueue<>((a, b) -> {
        return a.wsf - b.wsf;
    });

    public static void allSolution(int src, int dest, boolean[] vis, Pair p, String psf, int wsf, int givenWeight,
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
            if (wsf < givenWeight) {
                if (p.floor < wsf) {
                    p.floor = wsf;
                    p.floorPath = psf + dest;
                }
            }
            if (wsf > givenWeight) {
                if (p.ceil > wsf) {
                    p.ceil = wsf;
                    p.ceilPath = psf + dest;
                }
            }
            pq.add(new pqPair(wsf, psf + dest));
            if (pq.size() > k)
                pq.remove();
            return;
        }
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                allSolution(e.v, dest, vis, p, psf + src, wsf + e.w, givenWeight, k);
            }
        }
        vis[src] = false;
    }

    public static void dfs(int src, boolean[] vis) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                dfs(e.v, vis);
            }
        }
    }

    public static void gcc() {

        boolean[] vis = new boolean[N];
        int components = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                components++;
                dfs(i, vis);
            }
        }
        System.out.println(components);

    }

    public static void dfsIsland(int[][] mat, int i, int j, int[][] dir) {

        mat[i][j] = 0;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            if (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == 1) {
                dfsIsland(mat, r, c, dir);
            }
        }
    }

    public static int numberIsland(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    dfsIsland(mat, i, j, dir);
                    count++;
                }
            }
        }
        return count;
    }

    public static void hamiltonian_dfs(int src, int osrc, boolean[] vis, int noOfEdges, String ans) {
        if (noOfEdges == N - 1) {
            System.out.print(ans + src);
            int idx = findEdge(src, osrc);
            if (idx != -1)
                System.out.print("*");
            System.out.println();
            return;
        }
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                hamiltonian_dfs(e.v, osrc, vis, noOfEdges + 1, ans + src);
            }
        }
        vis[src] = false;
    }

    public static void hamiltonian() {
        boolean[] vis = new boolean[N];
        hamiltonian_dfs(0, 0, vis, 0, "");
    }

    public static int moonDFS(ArrayList<Integer>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        int size = 0;
        for (Integer i : graph[src]) {
            if (!vis[i]) {
                size += moonDFS(graph, i, vis);
            }
        }
        return size + 1;
    }

    public static long journeyToMoon(int n, int[][] astronaut) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] ele : astronaut) {
            graph[ele[0]].add(ele[1]);
            graph[ele[1]].add(ele[0]);
        }
        ArrayList<Integer> allsize = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                allsize.add(moonDFS(graph, i, vis));
            }
        }
        long ssf = 0, res = 0;
        for (int ele : allsize) {
            res += ele * ssf;
            ssf += ele;
        }
        return res;
    }

    public static void BFS(int src, boolean[] vis) {
        int level = 0, cycleCount = 0;
        LinkedList<Integer> que = new LinkedList<>();
        que.add(src);
        while (que.size() != 0) {
            int size = que.size();
            System.out.print(level + " -> ");
            while (size-- > 0) {
                int rm = que.removeFirst();
                if (vis[rm]) {
                    cycleCount++;
                    continue;
                }
                System.out.print(rm+" ");
                if (!vis[rm]) {
                    vis[rm] = true;
                    for (Edge e : graph[rm]) {
                        if (!vis[e.v])
                            que.add(e.v);
                    }
                }
            }
            System.out.println();
            level++;
        }
        System.out.println(cycleCount);
    }
    
    public static boolean isTree(){
        // one gcc and no cycle
        return true;
    }
    public static boolean isForest(){
        //gcc >1 and no cycle
        return true;
    }

    public static boolean isBipartite(){

        return true;
    }
    public static void main(String args[]) {
        int N = 7;
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        addEdge(0, 1, 10);
        addEdge(0, 3, 5);
        addEdge(1, 2, 2);
        addEdge(2, 3, 5);
        addEdge(3, 4, 3);
        addEdge(4, 5, 8);
        addEdge(4, 6, 4);
        addEdge(5, 6, 3);
        addEdge(0, 6, 5);
        addEdge(2, 5, 6);
        // display();
        // System.out.println(findEdge(0,3));
        // removeEdge(0, 1);
        // display();
        // System.out.println();
        // removeVtx(6);
        // display();
        boolean[] vis = new boolean[N];
        // System.out.println(hasPath(0,5,vis));
        // System.out.println(allPath(0, 3, vis,""));
        // preOrder(0, vis,"", 0);
        // postOrder(0, vis, "", 0);
        // Pair p = new Pair();
        // allSolution(0, 6, vis, p, "", 0, 19, 4);
        // System.out.println("Smallest Path : " + p.smallestPath + "@" +
        // p.smallestWeight);
        // System.out.println("Largest Path : " + p.largestPath + "@" +
        // p.largestWeight);
        // System.out.println("ceil of 12 : " + p.ceilPath + "@" + p.ceil);
        // System.out.println("floor of 12 : " + p.floorPath + "@" + p.floor);
        // System.out.println("Kth largest path : " + pq.peek().psf + "@" +
        // pq.peek().wsf);

        // hamiltonian();
        BFS(0,vis);
    }
}
