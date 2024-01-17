import java.util.*;

public class q15489 {
    static int r, c, w;
    static int[][] board = new int[35][35];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        w = sc.nextInt();
        board[1][1] = 1;
        for(int i = 2; i <= r + w - 1; i++) {
            for(int j = 1; j <= i; j++) {
                board[i][j] = board[i - 1][j - 1] + board[i - 1][j];
            }
        }
        int res = 0;
        for(int i = r; i <= r + w - 1; i++) {
            for(int j = c; j <= c + i - r; j++) {
                res += board[i][j];
            }
        }
        System.out.println(res);
    }
}