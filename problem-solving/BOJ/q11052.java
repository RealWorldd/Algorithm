import java.util.*;

public class q11052 {

    static int N;
    static int[] cardPrice;
    static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N= sc.nextInt();
        cardPrice = new int[N + 1];
        d = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            cardPrice[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++) {
            int maxVal = 0;
            for (int j = 1; j <= i; j++) {
                maxVal = Math.max(maxVal, cardPrice[j] + d[i-j]);
            }
            d[i] = maxVal;
        }
        System.out.print(d[N]);
    }
}
