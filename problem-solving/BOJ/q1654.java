import java.util.*;
import java.io.*;

public class q1654 {
    static int n, k;
    static int[] a = new int[10005];
    public static boolean can(long target) {
        long temp = 0;
        for(int i = 0; i < k; i++) {
            temp += a[i] / target;
        }
        if(temp < n) return false;
        else return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }

        long start = 0;
        long end = Integer.MAX_VALUE;
        while(start < end) {
            long mid = (start + end + 1) / 2;
            if(can(mid)) start = mid;
            else end = mid - 1;
        } 
        System.out.println(start);
    }
}