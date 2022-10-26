import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : PACKAGE_NAME
 * fileName       : Main2
 * author         : home
 * date           : 22. 10. 26.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 10. 26.        home       최초 생성
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] miro = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];



        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                miro[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                dp[i][j] = Math.max(dp[i - 1][j] + miro[i][j], dp[i][j - 1] + miro[i][j]);
            }
        }

        /*for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/

        System.out.println(dp[N][M]);

    }
}
