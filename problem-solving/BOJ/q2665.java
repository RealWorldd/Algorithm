import java.util.*;
import java.io.*;

public class q2665 {
    static int n;
    static int board[][];
    static int dis[][];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Point {
        int x, y, weight;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n + 2][n + 2];
        dis = new int[n + 2][n + 2];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 1; j <= n; j++) {
                board[i][j] = s.charAt(j - 1) - '0';
            }
        }
        for(int i = 0; i < n + 2; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));
        dis[1][1] = 0;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int nxt = 0; nxt < 4; nxt++) {
                int nx = cur.x + dx[nxt];
                int ny = cur.y + dy[nxt];
                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if(board[ny][nx] == 1) {
                    if(dis[ny][nx] != Integer.MAX_VALUE) {
                        if(dis[ny][nx] <= dis[cur.y][cur.x]) continue;
                    }
                    q.add(new Point(nx, ny));
                    dis[ny][nx] = dis[cur.y][cur.x];
                }
                if(board[ny][nx] == 0) {
                    if(dis[ny][nx] != Integer.MAX_VALUE) {
                        if(dis[ny][nx] <= dis[cur.y][cur.x] + 1) continue;
                    }
                    q.add(new Point(nx, ny));
                    dis[ny][nx] = dis[cur.y][cur.x] + 1;
                }
            }
        }
        System.out.println(dis[n][n]);
    }
} 