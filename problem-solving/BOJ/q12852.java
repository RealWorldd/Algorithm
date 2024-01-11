import java.util.*;

public class q12852 {
    static int n;
    static int[] d = new int[3000005];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(d, Integer.MAX_VALUE);
        d[n] = 0;
        for(int i = n; i > 1; i--) {
            if(i % 3 == 0) d[i / 3] = Math.min(d[i / 3], d[i] + 1);
            if(i % 2 == 0) d[i / 2] = Math.min(d[i / 2], d[i] + 1);
            d[i - 1] = Math.min(d[i - 1], d[i] + 1);
        }
        System.out.println(d[1]);
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= n;) {
            if(d[i * 3] == d[i] - 1) {
                stack.push(i);
                i *= 3;
                continue;
            }
            if(d[i * 2] == d[i] - 1) {
                stack.push(i);
                i *= 2;
                continue;
            }
            stack.push(i);
            i += 1;
        }
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            System.out.print(cur + " ");
        }
    }
}