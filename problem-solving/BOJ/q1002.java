import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1002 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            int x1, y1, r1, x2, y2, r2;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());

            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            int maxR = Math.max(r1, r2);
            int minR = Math.min(r1, r2);
            if (r1 == r2) {
                if (distance == 0) {
                    System.out.println(-1);
                } else if (distance > r1 + r2) {
                    System.out.println(0);
                } else if (distance == r1 + r2) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            } else {
                if (distance <= maxR) {
                    if (distance == 0) {
                        System.out.println(0);
                    } else if (maxR - minR > distance) {
                        System.out.println(0);
                    } else if (maxR - minR == distance) {
                        System.out.println(1);
                    } else {
                        System.out.println(2);
                    }
                } else {
                    if (r1 + r2 > distance) {
                        System.out.println(2);
                    } else if (r1 + r2 == distance) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                }
            }
            T--;
        }
    }
}
