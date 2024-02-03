import java.util.*;
import java.io.*;

public class q16401 {
    static int m, n;
    static int[] a = new int[1000005];
    public static boolean can(int target) {
        long temp = 0;
        for(int i = 0; i < n; i++) {
            temp += a[i] / target;
        }
        if(temp >= m) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = (int) 1e9;
        while(start < end) {
            int mid = (start + end + 1) / 2;
            if(can(mid)) start = mid;
            else end = mid - 1;
        }
        System.out.println(start);
    }
}