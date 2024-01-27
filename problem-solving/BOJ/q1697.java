import java.util.*;

public class q1697 {
    static int n, k;
    static boolean[] vis = new boolean[100005];
    static class Point {
        int point, count;
        public Point(int point, int count) {
            this.point = point;
            this.count = count;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(n, 0)); vis[n] = true;
        int ans = 0;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.point == k) {
                ans = cur.count;
                break;
            }
            for(int i = 0; i < 3; i++) {
                Point nxt;
                if(i == 0) nxt = new Point(cur.point - 1, cur.count + 1);
                else if(i == 1) nxt = new Point(cur.point + 1, cur.count + 1);
                else nxt = new Point(cur.point * 2, cur.count + 1);
                if(nxt.point < 0 || nxt.point > 100000) continue;
                if(vis[nxt.point]) continue;
                q.add(nxt);
                vis[nxt.point] = true;
            }
        }
        System.out.println(ans);
    }
}