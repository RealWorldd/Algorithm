import java.util.*;
import java.io.*;

public class q1504 {
    static int n, e, v1, v2;
    static ArrayList<Edge>[] edges;
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

    public static int solve(int start, int end) {
        int[] d = new int[805];
        Arrays.fill(d, Integer.MAX_VALUE);

        Queue<Edge> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Edge(d[start], start));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(d[cur.v] != cur.w) continue;
            for(Edge nxt : edges[cur.v]) {
                if(d[nxt.v] <= d[cur.v] + nxt.w) continue;
                d[nxt.v] = d[cur.v] + nxt.w;
                pq.add(new Edge(d[nxt.v], nxt.v));
            }
        }
        return d[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(weight, to));
            edges[to].add(new Edge(weight, from));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        if(solve(1, n) != Integer.MAX_VALUE) System.out.println(Math.min(solve(1, v1) + solve(v1, v2) + solve(v2, n), solve(1, v2) + solve(v2, v1) + solve(v1, n)));
        else System.out.println(-1);
    }
}