import java.util.*;
import java.io.*;

public class q1238 {
    static int n, m, start;
    static ArrayList<Edge>[] edges;
    static int[][] d = new int[1005][1005];
    static class Edge implements Comparable<Edge> {
        int w, v;
        public Edge(int w, int v) {
            this.w = w;
            this.v = v; 
        }
        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(weight, to));
        }

        for(int i = 1; i <= n; i++) {
            Queue<Edge> pq = new PriorityQueue<>();
            d[i][i] = 0;
            pq.offer(new Edge(d[i][i], i));
            while(!pq.isEmpty()) {
                Edge cur = pq.poll();
                if(d[i][cur.v] != cur.w) continue;
                for(Edge nxt : edges[cur.v]) {
                    if(d[i][nxt.v] <= d[i][cur.v] + nxt.w) continue;
                    d[i][nxt.v] = d[i][cur.v] + nxt.w;
                    pq.offer(new Edge(d[i][nxt.v], nxt.v));
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        int res = 0;
        for(int i = 1; i <= n; i++) {
            res = Math.max(res, d[i][start] + d[start][i]);
        }
        System.out.println(res);
    }
}
