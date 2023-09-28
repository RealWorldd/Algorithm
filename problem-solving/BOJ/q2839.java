import java.util.Scanner;

public class q2839 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int copyN = N;

        int res = 0;
        if (N >= 5) {
            res += copyN / 5;
            copyN -= 5 * (copyN / 5);
            if (copyN % 3 == 0) {
                res += copyN / 3;
                System.out.print(res);
                return;
            }
            while (copyN < N) {
                copyN += 5;
                if (copyN > N) {
                    System.out.print(-1);
                    return;
                }
                res--;
                if (copyN % 3 == 0) {
                    res += copyN / 3;
                    System.out.print(res);
                    return;
                }
            }
        }
        if (copyN % 3 != 0) {
            System.out.print(-1);
            return;
        }
        System.out.print(copyN / 3);
    }
}
