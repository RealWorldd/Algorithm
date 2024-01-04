import java.util.*;

public class q25418 {
    static int A, K;
    static int[] dis = new int[1000 * 1000 + 1];
    static class State {
        int value;
        int count;

        State(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        K = sc.nextInt();

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(A, 0));
        dis[A] = 0;

        while(!queue.isEmpty()) {
            State cur = queue.poll();
            if(cur.value == K) {
                System.out.println(cur.count);
                return;
            }
            if(cur.value * 2 <= K && dis[cur.value * 2] == 0) {
                queue.add(new State(cur.value * 2, cur.count + 1));
                dis[cur.value * 2] = cur.count + 1;
            }
            if(cur.value + 1 <= K && dis[cur.value + 1] == 0) {
                queue.add(new State(cur.value + 1, cur.count + 1));
                dis[cur.value + 1] = cur.count + 1;
            }
        }
    }
}