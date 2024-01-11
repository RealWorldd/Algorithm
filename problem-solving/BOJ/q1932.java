import java.util.*;
import java.io.*;

public class q1932 {
    static int n;
    static int[][] graph = new int[505][505];
    static int[][] d = new int[505][505];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        d[1][1] = graph[1][1];
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + graph[i][j];
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++) {
            res = Math.max(res, d[n][i]);
        }
        System.out.println(res);
    }
}