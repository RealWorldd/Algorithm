import java.util.*;
import java.io.*;

public class q15486 {
    static int n;
    static int[] t = new int[1500005];
    static int[] p = new int[1500005];
    static int[] d = new int[1500005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            d[i] = Math.max(d[i], d[i - 1]);
            if(i + t[i] - 1 <= n) {
                d[i + t[i]] = Math.max(d[i + t[i]], d[i] + p[i]);
            }
        }
        System.out.println(Math.max(d[n], d[n + 1]));
    }
}