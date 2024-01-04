import java.util.*;

public class q13702 {
    static int N, K;
    static int[] kettles;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        kettles = new int[N];
        int start = 0;
        int end = 0;
        for(int i = 0; i < N; i++) {
            kettles[i] = sc.nextInt();
            end = Math.max(end, kettles[i]);
        }
        if(K == 0 || K == 1){
            System.out.println(end);
            return;
        }
        long res = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0;

            for(int kettle: kettles){
                cnt += (int) (kettle / mid);
            }
            if(cnt >= K){
                start = (int) mid + 1;
                res = mid;
            } else {
                end = (int) mid - 1;
            }
        }
        System.out.println(res);
    }
}