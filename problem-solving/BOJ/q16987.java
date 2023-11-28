import java.util.*;
import java.io.*;

class q16987 {
    static int n;
    static int res;
    static ArrayList<Egg> eggs = new ArrayList<>();
    static class Egg {
        int d, w;
        public Egg (int durability, int weight) {
            this.d = durability;
            this.w = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            eggs.add(new Egg(a, b));
        }
        dfs(0, 0);
        System.out.println(res);
    }

    private static void dfs(int index, int count) {
        if(index == n) {
            res = Math.max(res, count);
            return;
        }
        Egg cur = eggs.get(index);
        if(cur.d <= 0) {
            dfs(index+1, count);
            return;
        }
        boolean flag = false;
        for(Egg egg : eggs) {
            if(cur.equals(egg)) continue;
            if(egg.d <= 0) continue;
            flag = true;
            int tempC = cur.d;
            int tempE = egg.d;
            int tempCount = count;
            cur.d -= egg.w;
            egg.d -= cur.w;
            if(cur.d <= 0) {
                tempCount++;
            }
            if(egg.d <= 0) {
                tempCount++;
            }
            dfs(index + 1, tempCount);
            cur.d = tempC;
            egg.d = tempE;
        }
        if(!flag) res = Math.max(res, count);
    }
}