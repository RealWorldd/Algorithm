import java.util.*;
import java.io.*;

public class q2295 {
    static int n;
    static int[] a = new int[1005];
    static ArrayList<Integer> b = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, 0, n);
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                b.add(a[i] + a[j]);
            }
        }
        Collections.sort(b);
        for(int i = n - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(Collections.binarySearch(b, a[i] - a[j]) >= 0) {
                    System.out.println(a[i]);
                    return;
                }
            }
        }
    }
}