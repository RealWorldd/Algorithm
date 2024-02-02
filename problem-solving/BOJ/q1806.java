import java.util.*;
import java.io.*;

public class q1806 {
    static int n, s;
    static Integer[] a = new Integer[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int res = Integer.MAX_VALUE;
        int end = 0;
        int temp = a[0];
        for(int start = 0; start < n; start++) {
            while(end < n && temp < s) {
                end++;
                if(end != n) temp += a[end];
            }
            if(end == n) break;
            res = Math.min(res, end - start + 1);
            temp -= a[start];  
        }
        if(res == Integer.MAX_VALUE) res = 0;
        System.out.println(res);
    }
}