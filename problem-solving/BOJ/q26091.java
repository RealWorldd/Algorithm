import java.util.*;
import java.io.*;

public class q26091 {
    static int n, m;
    static Integer[] a = new Integer[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, 0, n, Collections.reverseOrder());
        int end = n - 1;
        int res = 0;
        for(int start = 0; start < n; start++) {
            if(start >= end) break;
            while(end > 0) {
                if(end != start && end < n && a[start] + a[end] >=m) {
                    res++;
                    end--;
                    break;
                }
                end--;
            }
        }
        System.out.println(res);
    }
}