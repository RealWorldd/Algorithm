import java.util.*;
import java.io.*;

public class q11404 {

    static final int INF = 0x3f3f3f3f;
    static int n, m;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], INF);
        }

        for (int i = 0; i < m; i++) {
            int a, b, c;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d[a][b] = Math.min(d[a][b], c);
        }

        for(int i = 1; i<= n; i++) d[i][i] = 0;

        for(int k = 1; k <= n; k++)
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <=n; j++)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(d[i][j] == INF) System.out.print("0 ");
                else System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
    }
}