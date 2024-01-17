import java.util.*;

public class q13301 {
    static int n;
    static long[] d = new long[85];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        d[1] = 4;
        d[2] = 6;

        for(int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        System.out.println(d[n]);
    }
}