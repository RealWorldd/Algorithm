import java.util.*;
import java.io.*;

public class q2579 {
    static int n, res;
    static int[] stairs = new int[302];
    static int[][] dp = new int[302][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            stairs[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][1] = stairs[1]; dp[1][2] = 0;
        dp[2][1] = stairs[2]; dp[2][2] = stairs[1] + stairs[2];

        for(int i = 3; i <= n; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];
            dp[i][2] = dp[i - 1][1] + stairs[i];
        }
        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}