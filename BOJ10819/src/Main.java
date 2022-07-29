import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] seq;
    static boolean[] checked;
    static int[] minuses;

    static int maxRes = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        seq = new int[N];
        checked = new boolean[N];
        minuses = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0);

        System.out.println(maxRes);
    }


    public static void backtracking(int cnt) {

        if (cnt == N - 1) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += minuses[i];
            }

            maxRes = Math.max(sum, maxRes);
            reset();
            return;
        }

        for (int i = 0; i < N - 1; i++) {

            if(checked[i]) continue;

            checked[i] = true;
            minuses[cnt] = seq[i] - seq[i + 1];
            backtracking(cnt + 1);
            checked[i] = false;

        }
    }

    public static void reset() {
        Arrays.fill(checked, false);
    }
}
