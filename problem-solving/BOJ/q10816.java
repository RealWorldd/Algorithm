import java.util.*;
import java.io.*;

public class q10816 {
    static int n, m;
    static int[] cards;

    public static int lowerIdx(int target) {
        int start = 0;
        int end = n;
        while(start < end) {
            int mid = (start + end) / 2;
            if(cards[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
    public static int upperIdx(int target) {
        int start = 0;
        int end = n;
        while(start < end) {
            int mid = (start + end) / 2;
            if(cards[mid] > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        st= new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(Integer.toString(upperIdx(target) - lowerIdx(target)) + " ");
        }
        System.out.println(sb);
    }
}