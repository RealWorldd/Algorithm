import java.util.*;
import java.io.*;

public class q26598 {
    static int N, M;
    static char[][] board;
    static boolean[][] vis;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class State {
        int x, y;
        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N + 1][M + 1];
        vis = new boolean[N + 1][M + 1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        char curChar;
        Queue<State> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                if(vis[i][j]) continue;
                curChar = board[i][j];
                int tempI = i;
                while(board[tempI + 1][j] == curChar) tempI++;
                int tempJ = j;
                while(board[i][tempJ + 1] == curChar) tempJ++;
                queue.add(new State(j, i));
                vis[i][j] = true;
                while(!queue.isEmpty()) {
                    State cur = queue.poll();
                    for(int nxt = 0; nxt < 4; nxt++) {
                        int nx = cur.x + dx[nxt];
                        int ny = cur.y + dy[nxt];
                        if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                        if(vis[ny][nx]) continue;
                        if((nx >= j && nx <= tempJ) && (ny >= i && ny <= tempI) && board[ny][nx] != curChar) {
                            System.out.println("BaboBabo");
                            return;
                        }
                        if(board[ny][nx] != curChar) continue;
                        if(nx > tempJ || ny > tempI || nx < j || ny < i) {
                            System.out.println("BaboBabo");
                            return;
                        }
                        queue.add(new State(nx, ny));
                        vis[ny][nx] = true;
                    }
                }   
            }
        }
        System.out.println("dd");
    }
}