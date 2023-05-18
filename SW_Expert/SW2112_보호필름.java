package SW_Expert;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW2112_보호필름 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static int D, W ,K, cell[][], tmp[], ans_cnt;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken()); //막 깊이
            W = Integer.parseInt(st.nextToken()); //바 개수
            K = Integer.parseInt(st.nextToken()); //합격 기준

            cell = new int[D][W]; //보호필름 설질
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    cell[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            tmp = new int[D];
            Arrays.fill(tmp, -1);
            ans_cnt = Integer.MAX_VALUE;

            dfs(0, 0);
            sb.append("#").append(tc).append(" ").append(ans_cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void dfs(int depth, int cnt) { // depth는 깊이, cnt는 시약을 몇번 사용했는지
        if(depth == D) { //깊이가 D와 같아지면 조건 진입
            if (check()) { // 같은 성질이 연속해서 K개만큼 있는지 확인
                ans_cnt = Math.min(ans_cnt, cnt); // 최소 시약 개수 갱신
            }
            return;
        }
        if(cnt >= ans_cnt) return;

        //1
        tmp[depth] = -1;
        dfs(depth+1, cnt);

        //2
        tmp[depth] = 0;
        dfs(depth+1, cnt+1);

        //3
        tmp[depth] = 1;
        dfs(depth+1, cnt+1);
    }
    private static boolean check() {
        int a,b;
        for (int i = 0; i < W; i++) {
            int count = 1;
            for (int j = 0; j < D-1; j++) {
                a = cell[j][i];
                b = cell[j+1][i];

                if(tmp[j] != -1){
                    a = tmp[j];
                }
                if(tmp[j+1] != -1){
                    b = tmp[j+1];
                }
                if(a == b){
                    count++;
                    if(count >= K) {
                        break;
                    }
                }
                else
                    count = 1;
            }
            if(count < K)
                return false;
        }
        return true;
    }
}

/*
int a, b;
        int cnt = 0;
        for(int j = 0; j < W;j++) {
            cnt = 1;
            for(int i = 0; i < D-1 ; i++) {
                a = cell[i][j];
                b = cell[i+1][j];
                //화약 약품 사용했는지 안했는지
                if(tmp[i] != -1) {
                    a = tmp[i];
                }
                if(tmp[i+1] != -1) {
                    b = tmp[i+1];
                }
                if(a == b) {
                    cnt++;
                    if(cnt >= K) {
                        break;
                    }
                }else {
                    cnt = 1;
                }
            }
            if(cnt < K) {
                return false;
            }
        }
        return true;
    }
 */
