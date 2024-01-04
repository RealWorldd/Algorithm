import java.util.*;
import java.io.*;

public class q12865 {
    static int N, M;
    static int[] W, V;
    static int[][] K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = new int[N + 1][M + 1];
        W = new int[N + 1];
        V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            W[i] = w;
            V[i] = v;
        }

        for (int i = 0; i <= N; i++) Arrays.fill(K[i], 0);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(W[i] > j) {
                    K[i][j] = K[i - 1][j];
                } else{
                    K[i][j] = Math.max(V[i] + K[i - 1][j - W[i]], K[i - 1][j]);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                res = Math.max(res, K[i][j]);
            }
        }
        System.out.println(res);
    }

}
