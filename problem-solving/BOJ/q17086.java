import java.util.*;

public class q17086 {
    static int N, M;
    static int[][] board;
    static int[][] dis;
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static List<Point> sharks = new ArrayList<>();
    public static class Point{
        int x;
        int y;
        int dis;
        public Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        dis = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) {
                    sharks.add(new Point(j, i, 0));
                    dis[i][j] = -1;
                }
            }
        }
        for (Point shark : sharks) {
            bfs(shark);
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res = Math.max(res, dis[i][j]);
            }
        }
        System.out.println(res);
    }

    private static void bfs(Point p) {
        boolean[][] vis = new boolean[N][M];
        Queue<Point> q = new ArrayDeque<>();
        q.add(p);
        vis[p.y][p.x] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(vis[ny][nx] || dis[ny][nx] == -1) continue;
                if (dis[ny][nx] != 0) {
                    if (dis[ny][nx] < cur.dis + 1) continue;
                }
                dis[ny][nx] = cur.dis + 1;
                vis[ny][nx] = true;
                q.add(new Point(nx, ny, cur.dis + 1));
            }
        }
    }
}