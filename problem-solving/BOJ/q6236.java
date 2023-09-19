package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q6236 {
    static int n;
    static int m;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        money = new int[n];
        int min = 1, max = 0;

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(in.readLine());
            min = Math.max(min, money[i]); // money 중 가장 큰 값이 이분탐색 범위의 최소이다. 이 값보다 작아지면 새로운 돈은 꺼낼 때 그 날의 목표치를 다 못쓰는 경우가 발생하기 떄문이다.
            max += money[i]; // money의 모든 값을 더한 값이 이분탐색 범위의 최대.
        }

        int res = max;
        int mid;
        while (min <= max) {
            mid = (min + max) / 2;
            if(solution(mid) > m) min = mid + 1; // 꺼낸 횟수가 m보다 크면 꺼내는 횟수를 줄여야 하므로 min 값을 올린다.
            else {
                max = mid - 1; // 아니라면 max를 줄여가면서 최솟값 탐색
                res = Math.min(res, mid); //res와 비교하여 최솟값 탐색
            }
        }
        System.out.println(res);
    }

    private static int solution(int price) {
        int count = 1; // 첫 번째 꺼내는 것을 미리 1로 더해놓는다. (꺼낸 횟수)
        int currentPrice = price;
        for (int i = 0; i < n; i++) {
            if (money[i] > currentPrice) { // 그 날의 목표치가 남은 금액보다 크면 넣고 다시 꺼낸 후 꺼낸 횟수++
                currentPrice = price;
                count++;
                currentPrice -= money[i]; // 그 날의 목표치만큼 삭감
                continue;
            }
            if (money[i] <= currentPrice) { // 그 날의 목표치보다 남은 금액이 크면 그 액수만큽만 삭감
                currentPrice -= money[i];
            }
        }
        return count;
    }
}