import java.util.*;
import java.io.*;

public class q11055 {
    static int n;
    static int[] nums = new int[1005];
    static int[] d = new int[1005];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            d[i] = nums[i];
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(nums[i] > nums[j]) d[i] = Math.max(d[i], d[j] + nums[i]);
            }
        }
        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}