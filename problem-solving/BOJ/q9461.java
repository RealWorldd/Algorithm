import java.util.*;

public class q9461 {
    static int n;
    static long[] d = new long[105];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d[1] = 1; d[2] = 1; d[3] = 1;
        for(int i = 4; i <= 100; i++) {
            d[i] = d[i - 3] + d[i - 2];
        }
        for(int i = 0; i < n; i++) {
            sc.nextLine();
            int req = sc.nextInt();
            System.out.println(d[req]);
        }
    }
}