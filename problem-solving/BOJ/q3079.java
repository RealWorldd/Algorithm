import java.util.*;
import java.io.*;

public class q3079 {
    static int n, m;
    static long bound;
    static int[] t = new int[100005];
    public static boolean can(long target) {
        long temp = 0;
        for(int i = 0; i < n; i++) {
            if(temp > bound) continue;
            temp += target / t[i];
        }
        if(temp >= m) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        long max = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, t[i]);
        }
        long start = 0;
        long end = max * m + 1;
        bound = end;
        while(start < end) {
            long mid = (start + end) / 2;
            if(can(mid)) end = mid;
            else start = mid + 1;
        }
        System.out.println(start);
    }
}