import java.util.*;
import java.io.*;

public class q10844 {
    static int n;
    static long[][] d = new long[105][10]; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int k = 1; k <= 9; k++) d[1][k] = 1;

        for(int i = 2; i <= n; i++) {
            for(int k = 0; k <= 9; k++) {
                if(k != 0) d[i][k] += d[i - 1][k - 1];
                if(k != 9) d[i][k] += d[i - 1][k + 1];
                d[i][k] = d[i][k] % (int) 1e9;
            }
        }
        long ans = 0;
        for(int k = 0; k <= 9; k++) ans += d[n][k];
        System.out.println(ans % (int) 1e9);
    }
}