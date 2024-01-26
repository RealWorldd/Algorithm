import java.util.*;
import java.io.*;

public class q17503 {
    static int n, k;
    static long m;
    static Beer[] beers;
    static class Beer {
        int prefer;
        long level;
        public Beer(int prefer, long level) {
            this.prefer = prefer;
            this.level = level;
        }
    }

    public static boolean can(long target) {
        long temp = 0;
        int cnt = 0;
        for(int i = 0; i < k; i++) {
            if(beers[i].level <= target && cnt < n) {
                temp += beers[i].prefer;
                cnt++;
            }
        }
        if(cnt < n) return false;
        if(temp < m) return false;
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        beers = new Beer[k];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int prefer = Integer.parseInt(st.nextToken());
            long level = Long.parseLong(st.nextToken());
            beers[i] = new Beer(prefer, level);
        }

        Arrays.sort(beers, new Comparator<Beer>() {
            @Override
            public int compare(Beer b1, Beer b2) {
                return Long.compare(b2.prefer, b1.prefer);
            }
        });

        long start = 0;
        long end = Integer.MAX_VALUE;

        while(start < end) {
            long mid = (start + end) / 2;
            if(can(mid)) end = mid;
            else start = mid + 1;
        }
        if(can(start)) System.out.println(start);
        else System.out.println("-1");
    }
}
