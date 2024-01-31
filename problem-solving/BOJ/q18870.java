import java.util.*;
import java.io.*;

public class q18870 {
    static int n;
    static int[] a;
    static int[] b;
    public static int can(int target, int len) {
        int st = 0;
        int end = len;
        while(st < end) {
            int mid = (st + end) / 2;
            if(a[mid] >= target) end = mid;
            else st = mid + 1; 
        }
        return st;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = new int[n];
        b = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = a[i];
        }
        Arrays.sort(a, 0, n);
        a = Arrays.stream(a).distinct().toArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(Integer.toString(can(b[i], a.length)) + " ");
        }
        System.out.println(sb);
    }
}