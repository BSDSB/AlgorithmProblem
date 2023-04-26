package SW_Expert;

import java.io.*;
import java.util.StringTokenizer;

public class SW1486_장훈이의높은선반 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static int N,B, tall[], ans_min;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 직원의 수
            B = Integer.parseInt(st.nextToken()); // 탑의 높이

            tall = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                tall[i] = Integer.parseInt(st.nextToken());
            }
            ans_min = Integer.MAX_VALUE;
            dfs(0,0, 0);

            sb.append("#").append(tc).append(" ").append(ans_min-B).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void dfs(int idx, int cnt, int sum) {
        if (sum >= ans_min) return;
        if(cnt == N){
            if(sum >= B)
                ans_min = Math.min(sum, ans_min);
        }
        else{
            dfs(idx+1,cnt+1, sum + tall[idx]);
            dfs(idx+1,cnt+1, sum);
        }
    }
}
