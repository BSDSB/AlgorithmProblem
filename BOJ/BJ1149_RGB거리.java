package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1149_RGB거리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken()); //레드
            dp[i][1] = Integer.parseInt(st.nextToken()); //그린
            dp[i][2] = Integer.parseInt(st.nextToken()); //블루
        }

        for (int i = 1; i < N; i++) { //0은 처음 비용이 담겨있다.
            //전 색상이 현재 색상과 같지만 않으면 된다.
            //왜냐하면 현재 색이 초록색이고 전 집 색상이 빨강, 파랑이라면 n-1과 겹치지 않는다.
            //또한 내 현재 색이 초록이고 전전집에 대해서는 전집이 나랑만 같지 않다면 빨강,파랑,초록 무엇이 와도 상관없기 때문이다.
            //겹치지 않게 누적값이 계속 쌓인다.현집이 초록이고 전집에서 파랑이라면 누적값을 가져올 때 그 누적값은 전전집과 겹치지 않는
            //초록, 빨강에 대해서 비용을 계산하기 때문에 계속해서 누적값을 쌓아도 겹치는 집은 존재하지 않는다.
            dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int tmp = Math.min(dp[N-1][0], dp[N-1][1]);
        System.out.println(Math.min(tmp, dp[N-1][2]));
    }
}
