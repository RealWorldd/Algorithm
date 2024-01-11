import java.util.*;
import java.io.*;

public class q11659 {
    static int n, m;
    static int[] numbers = new int[100005];
    static int[] d = new int[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        d[1] = numbers[1];
        for(int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + numbers[i];
        }

        for(int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(d[j] - d[i - 1]);
        }
    }
}