import java.util.*;

public class q25633 {
    static int n;
    static int[] dominos = new int[1005];
    static int[] d = new int[1005];
    static int[] count = new int[1005];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); sc.nextLine();
        for(int i = 1; i <= n; i++) {
            dominos[i] = sc.nextInt();
        }
        d[1] = dominos[1];
        
        for(int i = 2; i <= n; i++) {
            if(dominos[i] <= d[i - 1]) {
                d[i] = d[i - 1] + dominos[i];
            } else {
                d[i] = dominos[i];
            }
        }

        for(int i = 1; i <= n; i++) {
            count[i] = 1;
            for(int j = 1; j < i; j++) {
                if(dominos[i] <= d[j]) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++) {
            res = Math.max(res, count[i]);
        }
        System.out.println(res);
    }
}
