import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q2792 {
    static int N; // 아이들 수
    static int M; // 색상의 수
    static Integer[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        colors = new Integer[M];
        int min = 1;
        int max = 0; // 같은 색깔의 보석 최대 갯수
        for (int i = 0; i < M; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, colors[i]);
        }
        Arrays.sort(colors, Comparator.reverseOrder());

        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 0;
            for (int i = 0; i < M; i++) {
                count += colors[i] / mid; // 질투심만큼 나눈 몫은 나눠줄 할생 수
                if(colors[i] % mid != 0) count++; //질투심으로 나눴을 때 나머지가 있다면 이 또한 학생한테 나눠줘야 함
            }
            if(count > N) min = mid + 1; // 만약 count가 N보다 크다면 학생 수를 넘긴 것 이므로 더 많이 나눠줘야 함.
            else {
                max = mid - 1; // 아니라면 더 적게 나눠줘도 되므로 max를 줄인다.
            }
        }
        System.out.println(min);
    }
}