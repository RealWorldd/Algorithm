import java.util.*;
import java.io.*;

public class q2230 {
    static int n, m;
    static int[] a = new int[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, 0, n);
        int end = 0;
        int res = Integer.MAX_VALUE;
        for(int start = 0; start < n; start++) {
            while(end < n && a[end] - a[start] < m) end++;
            if(end == n) break;
            res = Math.min(res, a[end] - a[start]);
        }
        System.out.println(res);
    }
}