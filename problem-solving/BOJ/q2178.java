package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2178 {
    static int N, M;
    static int[][] board;
    static int[][] dist;
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
        board = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = line.charAt(j - 1) - '0';
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));
        dist[1][1] = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx > M || nx < 1 || ny > N || ny < 1) continue;
                if(board[ny][nx] == 0 || dist[ny][nx] != 0) continue;
                q.add(new Point(nx, ny));
                dist[ny][nx] = dist[cur.y][cur.x] + 1;
            }
        }
        System.out.print(dist[N][M]);
    }
}
