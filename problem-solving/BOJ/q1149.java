import java.util.*;
import java.io.*;

public class q1149 {
    static int N;
    static House[] houses = new House[1001];
    static int d[][] = new int[1001][4];
    static class House {
        int red, green, blue;
        public House(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;       
        }
    }
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            houses[i] = new House(red, green, blue);
        }
        d[1][1] = houses[1].red; d[1][2] = houses[1].green; d[1][3] = houses[1].blue;
        for(int i = 2; i <= N; i++) {
            d[i][1] = Math.min(d[i - 1][2], d[i - 1][3]) + houses[i].red;
            d[i][2] = Math.min(d[i - 1][1], d[i - 1][3]) + houses[i].green;
            d[i][3] = Math.min(d[i - 1][1], d[i - 1][2]) + houses[i].blue;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= 3; i++) {
            res = Math.min(res, d[N][i]);
        }
        System.out.println(res);
    }
}