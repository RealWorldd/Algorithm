import java.util.*;
import java.io.*;

public class q27211 {
    static int N, M;
    static int[][] board = new int[1005][1005];
    static boolean[][] vis = new boolean[1005][1005];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Point> q = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(vis[i][j] || board[i][j] == 1) continue;
                q.add(new Point(j, i));
                vis[i][j] = true;
                while(!q.isEmpty()) {
                    Point cur = q.poll();
                    for(int nxt = 0; nxt < 4; nxt++) {
                        int nx = cur.x + dx[nxt];
                        int ny = cur.y + dy[nxt];
                        if(nx < 0) nx = M - 1;
                        if(ny < 0) ny = N - 1;
                        if(nx >= M) nx = 0;
                        if(ny >= N) ny = 0;
                        if(vis[ny][nx] || board[ny][nx] == 1) continue;
                        q.add(new Point(nx, ny));
                        vis[ny][nx] = true; 
                    }
                }
                res++;
            }
        }
        System.out.println(res);
    }
}