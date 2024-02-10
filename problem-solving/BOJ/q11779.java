import java.util.*;
import java.io.*;

public class q11779 {
    static int n, m, start, end;
    static ArrayList<Edge> edges[];
    static int[] d = new int[1005];
    static int[] pre = new int[1005];
        static class Edge implements Comparable<Edge> {
        int v, w;
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
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        edges = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        Arrays.fill(d, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(weight, to));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Queue<Edge> pq = new PriorityQueue<>();
        
        d[start] = 0;
        pq.add(new Edge(d[start], start));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(d[cur.v] != cur.w) continue;
            for(Edge nxt : edges[cur.v]) {
                if(d[nxt.v] <= d[cur.v] + nxt.w) continue;
                d[nxt.v] = d[cur.v] + nxt.w;
                pq.add(new Edge(d[nxt.v], nxt.v));
                pre[nxt.v] = cur.v;
            }
        }
        System.out.println(d[end]);
        ArrayList<Integer> path = new ArrayList<>();
        int cur = end;
        while(cur != start) {
            path.add(cur);
            cur = pre[cur];
        }
        path.add(cur);
        Collections.reverse(path);
        System.out.println(path.size());
        for(int i : path) System.out.print(i + " ");
    }
}