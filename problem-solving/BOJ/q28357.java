import java.util.*;
import java.io.*;

public class q28357 {
    static int n;
    static long k;
    static long[] candy = new long[500005];

    public static boolean can(long target) {
        long temp = 0;
        for(int i = 0; i < n; i++) {
            if(candy[i] >= target) temp += candy[i] - target;
        }
        if(temp > k) return false;
        else return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            candy[i] = Long.parseLong(st.nextToken());
        }

        long start = 0;
        long end = (long) 1e12;

        while(start < end) {
            long mid = (start + end) / 2;
            if(can(mid)) end = mid;
            else start = mid + 1;
        }
        System.out.println(start);
    }
}