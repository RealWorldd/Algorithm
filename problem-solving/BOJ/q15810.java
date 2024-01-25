import java.util.*;
import java.io.*;

public class q15810 {
    static int n, m;
    static int[] map;

    public static boolean can(long target) {
        long temp = 0;
        for(int i = 0; i < n; i++) {
            temp += target / map[i];
        }
        if(temp >= m) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stn.nextToken());
        m = Integer.parseInt(stn.nextToken());
        
        map = new int[n];
        stn = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(stn.nextToken());
        }

        long st = 0;
        long en = (long) 1e12;
        while(st < en) {
            long mid = (st + en) / 2;
            if(can(mid)) en = mid;
            else st = mid + 1;
        }
        System.out.println(st);
    }
}