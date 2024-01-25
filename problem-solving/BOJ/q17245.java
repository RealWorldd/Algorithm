import java.util.*;
import java.io.*;

public class q17245 {
    static int n;
    static long total;
    static int[][] computers = new int[1005][1005];

    public static boolean can(int target) {
        long temp = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(target > computers[i][j]) temp += computers[i][j];
                else temp += target;
            }
        }
        if(temp >= (total + 1) / 2) return true;
        else return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                computers[i][j] = Integer.parseInt(st.nextToken());
                total += computers[i][j];
            }
        }
        
        int start = 0;
        int end = 1000 * 1000 * 10;
        while(start < end) {
            int mid = (start + end) / 2;
            if(can(mid)) end = mid;
            else start = mid + 1;
        }
        System.out.println(start);
    }
}