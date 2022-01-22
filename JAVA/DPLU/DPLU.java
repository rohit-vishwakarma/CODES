
// package DPLU;
import java.util.Arrays;
import java.util.LinkedList;

public class DPLU {
    /*
     * Rules to Follow 1. faith of each question with comments 2. Recursion tree
     * (dry run) 3. recursion code 4. memoization 5. observation 6. tabulation 7.
     * Optimization if possible
     */

    public static void display(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] arr) {
        for (int[] ar : arr) {
            display(ar);
        }
        System.out.println();
    }

    // faith -> fun(n) = fun(n-1) + fun(n-2)
    public static int fibo_memo(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = n;
        }

        if (dp[n] != 0)
            return dp[n];

        int ans = fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
        return dp[n] = ans;
    }

    public static int fibo_tabu(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];// fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
            dp[n] = ans;
        }

        return dp[N];
    }

    public static int fibo_opti(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void fibo_Set() {
        int n = 5;
        int[] dp = new int[n + 1];
        // System.out.println(fibo_memo(n, dp));
        // System.out.println(fibo_tabu(n, dp));
        System.out.println(fibo_opti(n));

        display(dp);
    }
    // ========================================================================================================

    // 2. A faith -> count += fun(sr,sc,dr,dc,dir,dp) and when sr==dr && sc = dc
    // dp[sr][sc] = 1
    // dir = {{1,0}, {0,1},{1,1}}
    public static int mazePath_memo(int sr, int sc, int dr, int dc, int[][] dir, int[][] dp) {
        if (sr == dr && sc == dc)
            return dp[sr][sc] = 1;

        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r <= dr && c <= dc) {
                count += mazePath_memo(r, c, dr, dc, dir, dp);
            }
        }
        return dp[sr][sc] = count;
    }

    public static int mazePath_tabu(int SR, int SC, int dr, int dc, int[][] dir, int[][] dp) {

        for (int sr = dr; sr >= SR; sr--) {
            for (int sc = dc; sc >= SC; sc--) {
                if (sr == dr && sc == dc) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if (r <= dr && c <= dc) {
                        count += dp[r][c];
                    }
                }
                dp[sr][sc] = count;
            }

        }
        return dp[SR][SC];

    }

    // =============================================================================================================
    public static int mazePathJump_memo(int sr, int sc, int dr, int dc, int[][] dir, int[][] dp) {
        if (sr == dr && sc == dc)
            return dp[sr][sc] = 1;

        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            while (r <= dr && c <= dc) {
                count += mazePath_memo(r, c, dr, dc, dir, dp);
                r += dir[d][0];
                c += dir[d][1];
            }
        }
        return dp[sr][sc] = count;
    }

    public static int mazePathJump_tabu(int SR, int SC, int dr, int dc, int[][] dir, int[][] dp) {

        for (int sr = dr; sr >= SR; sr--) {
            for (int sc = dc; sc >= SC; sc--) {
                if (sr == dr && sc == dc) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    while (r <= dr && c <= dc) {
                        count += dp[r][c];
                        r += dir[d][0];
                        c += dir[d][1];
                    }
                }
                dp[sr][sc] = count;
            }

        }
        return dp[SR][SC];

    }

    public static void mazePath() {
        // int n = arr.length;
        // int m = arr[0].length;
        int n = 7, m = 5;
        int[][] dir = { { 1, 0 }, { 0, 1 }, { 1, 1 } };
        int[][] dp = new int[n][m];
        // int ans = mazePath_memo(0, 0, n-1, m-1, dir, dp);
        // System.out.println(ans);
        // System.out.println(mazePath_tabu(0, 0, n-1, m-1, dir, dp));
        // System.out.println(mazePathJump_tabu(0, 0, n-1, m-1, dir, dp));
        System.out.println(mazePathJump_memo(0, 0, n - 1, m - 1, dir, dp));
        display2D(dp);
    }

    // =======================================================================================================

    // 3.

    public static int climbStairs_memo(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int a = climbStairs_memo(n - 1, dp);
        int b = climbStairs_memo(n - 2, dp);
        return dp[n] = a + b;
    }

    public static int climbStairs_tabu(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            int a = dp[n - 1];
            int b = dp[n - 2];
            dp[n] = a + b;
        }
        return dp[N];
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return climbStairs_memo(n, dp);
    }

    // =======================================================================================================
    // 4.
    public static int minCostClimbingStairs_memo(int[] cost, int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = cost[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int s1 = minCostClimbingStairs_memo(cost, n - 1, dp);
        int s2 = minCostClimbingStairs_memo(cost, n - 2, dp);
        int ans = Math.min(s1, s2) + (n != cost.length ? cost[n] : 0);
        return dp[n] = ans;
    }

    public static int minCostClimbingStairs_tabu(int[] cost, int N, int[] dp) {

        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = cost[n];
                continue;
            }

            int s1 = dp[n - 1];
            int s2 = dp[n - 2];
            int ans = Math.min(s1, s2) + (n != cost.length ? cost[n] : 0);
            dp[n] = ans;
        }
        return dp[N];

    }

    public static int minCostClimbingStairs_opti(int[] cost, int n) {
        int a = cost[0], b = cost[1];
        for (int i = 0; i <= n; i++) {
            int res = Math.min(a, b) + (i < n ? cost[n] : 0);
            a = b;
            b = res;
        }
        return b;
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        return minCostClimbingStairs_memo(cost, n, dp);
    }

    // =====================================================================================

    public static int boardPath_memo(int n, int[] dp) {
        if (n == 0) {
            return dp[n] = 1;
        }

        if (dp[n] != 0)
            return dp[n];

        int count = 0;
        for (int dice = 1; dice <= 6 && n - dice >= 0; dice++) {
            count += boardPath_memo(n - dice, dp);
        }

        return dp[n] = count;
    }

    public static int boardPath_tabu(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n == 0) {
                dp[n] = 1;
                continue;
            }

            int count = 0;
            for (int dice = 1; dice <= 6 && n - dice >= 0; dice++) {
                count += dp[n - dice];// boardPath_memo(n - dice, dp);
            }

            dp[n] = count;
        }
        return dp[N];
    }

    public static int boardPath_Opti(int n) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addLast(1);
        ll.addLast(1);
        for (int i = 2; i <= n; i++) {
            if (ll.size() <= 6)
                ll.addLast(ll.getLast() * 2);
            else
                ll.addLast(ll.getLast() * 2 - ll.removeFirst());
        }

        return ll.getLast();
    }

    public static int boardPath_memo02(int n, int[] arr, int[] dp) {
        if (n == 0) {
            return dp[n] = 1;
        }

        if (dp[n] != 0)
            return dp[n];

        int count = 0;
        for (int dice = 0; dice < arr.length && n - arr[dice] >= 0; dice++) {
            count += boardPath_memo02(n - arr[dice], arr, dp);
        }

        return dp[n] = count;
    }

    public static int boardPath_tabu02(int N, int[] arr, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n == 0) {
                dp[n] = 1;
                continue;
            }

            int count = 0;
            for (int dice = 0; dice < arr.length && n - arr[dice] >= 0; dice++) {
                count += dp[n - arr[dice]];// boardPath_memo(n - dice, dp);
            }

            dp[n] = count;
        }
        return dp[N];
    }

    public static void boardPath() {
        int n = 20;
        int[] dp = new int[n + 1];
        // System.out.println(boardPath_memo(n, dp));
        // System.out.println(boardPath_tabu(n, dp));
        // System.out.println(boardPath_Opti(n));
        int[] arr = { 1, 5, 6 };
        // System.out.println(boardPath_memo02(n, arr,dp));
        System.out.println(boardPath_tabu02(n, arr, dp));
        display(dp);
    }

    // =============================================================================

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // return ways_memo(s,n, dp);
        return ways_tabu(s, n, dp);
    }

    public int ways_memo(String s, int n, int[] dp) {
        if (n == 0) {
            return dp[n] = 1;
        }
        if (dp[n - 1] != -1) {
            return dp[n];
        }

        int count = 0;
        if (s.charAt(n - 1) > '0')
            count += ways_memo(s, n - 1, dp);

        if (n > 1) {
            int num = ((s.charAt(n - 2) - '0') * 10) + (s.charAt(n - 1) - '0');
            if (num <= 26 && num >= 10) {
                count += ways_memo(s, n - 2, dp);
            }
        }
        return dp[n] = count;

    }

    public int ways_tabu(String s, int N, int[] dp) {

        for (int n = 0; n <= N; n++) {
            if (n == 0) {
                dp[n] = 1;
                continue;
            }

            int count = 0;
            if (s.charAt(n - 1) > '0')
                count += dp[n - 1];

            if (n > 1) {
                int num = ((s.charAt(n - 2) - '0') * 10) + (s.charAt(n - 1) - '0');
                if (num <= 26 && num >= 10) {
                    count += dp[n - 2];
                }
            }
            dp[n] = count;
        }
        return dp[N];

    }

    // =======================================================================
    public long numDecodingsStar(String s, int idx, long[] dp) {
        if (idx == s.length()) {
            return dp[idx] = 1;
        }

        if (dp[idx] != -1)
            return dp[idx];

        if (s.charAt(idx) == '0') {
            return dp[idx] = 0;
        }

        long count = 0;
        int mod = (int) 1e9 + 7;
        char ch1 = s.charAt(idx);
        if (ch1 == '*') {
            count = (count + 9 * numDecodingsStar(s, idx + 1, dp)) % mod;

            if (idx < s.length() - 1) {
                if (s.charAt(idx + 1) == '*')
                    count = (count + 15 * numDecodingsStar(s, idx + 2, dp)) % mod;
                else if (s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '6')
                    count = (count + 2 * numDecodingsStar(s, idx + 2, dp)) % mod;
                else if (s.charAt(idx + 1) >= '7')
                    count = (count + numDecodingsStar(s, idx + 2, dp)) % mod;
            }
        } else {
            count = (count + numDecodingsStar(s, idx + 1, dp)) % mod;

            if (idx < s.length() - 1) {
                if (s.charAt(idx + 1) != '*') {
                    int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
                    if (num <= 26)
                        count = (count + 1 * numDecodingsStar(s, idx + 2, dp)) % mod;
                } else {
                    if (ch1 == '1')
                        count = (count + 9 * numDecodingsStar(s, idx + 2, dp)) % mod;
                    else if (ch1 == '2')
                        count = (count + 6 * numDecodingsStar(s, idx + 2, dp)) % mod;
                }
            }
        }

        return dp[idx] = count;
    }

    public int numDecodings02(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        long ans = numDecodingsStar(s, 0, dp);

        // for (int ele : dp)
        // System.out.print(ele + " ");
        return (int) ans;
    }

    // =========================================================================

    public long friendsPairing(int n, long[] dp) {
        if (n <= 1) {
            return dp[n] = 1;
        }
        if (dp[n] != 0)
            return dp[n];

        int mod = (int) 1e9 + 7;
        long single = friendsPairing(n - 1, dp);
        long pairup = friendsPairing(n - 2, dp) * (n - 1);

        return dp[n] = (single + pairup % mod) % mod;
    }

    public long friendsPairing_tabu(int N, long[] dp) {
        int mod = (int) 1e9 + 7;
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            long single = dp[n - 1];
            long pairup = dp[n - 2] * (n - 1);

            dp[n] = (single + pairup % mod) % mod;
        }

        return dp[N];
    }

    public long countFriendsPairings(int n) {
        long[] dp = new long[n + 1];
        return friendsPairing_tabu(n, dp);
    }

    // =====================================================

    public static int NKgroups_dp(int n, int k, int[][] dp) {
        if (k == 1 || k == n)
            return dp[n][k] = 1;

        if (dp[n][k] != -1) {
            return dp[n][k];
        }
        int count1 = NKgroups_dp(n - 1, k - 1, dp);
        int count2 = NKgroups_dp(n - 1, k, dp) * k;

        return dp[n][k] = count1 + count2;
    }

    public static int NKgroups_tabu(int N, int K, int[][] dp) {
        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= K; k++) {
                if (k > n)
                    break;
                if (k == 1 || k == n) {
                    dp[n][k] = 1;
                    continue;
                }

                int count1 = dp[n - 1][k - 1];
                int count2 = dp[n - 1][k] * k;

                dp[n][k] = count1 + count2;
            }
        }
        return dp[N][K];
    }

    public static void NKgroups() {
        int n = 5, k = 3;
        int[][] dp = new int[n + 1][k + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(NKgroups_tabu(n, k, dp));
        display2D(dp);
    }

    //=============================================================================

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        int ans = findP(nums1, nums2, n, m , dp);
        display2D(dp);
        return ans;
    }

    public int findP(int[] a, int[] b, int N , int M , int[][] dp){
        for(int n=0; n<N; n++){
            for(int m = 0 ; m<M; m++){
                dp[n][m] = a[n]* b[m];
                if(n>0 && m >0){
                    dp[n][m] += Math.max(dp[n-1][m-1] , 0);
                }
                if(n>0){
                    dp[n][m] = Math.max(dp[n][m], dp[n-1][m]);
                }
                if(m>0){
                    dp[n][m] = Math.max(dp[n][m], dp[n][m-1]);
                }
            }
        }
        return dp[N-1][M-1];
    }

    // =======================================================================================================

    public static void main(String[] args) {
        // fibo_Set();
        // mazePath();
        // boardPath();
        NKgroups();
    }

}