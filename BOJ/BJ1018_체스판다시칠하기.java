package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1018_체스판다시칠하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static String[][] map, map_B, map_W;
    static int N,M;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];

        map_B = new String[N][M];
        map_W = new String[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = String.valueOf(input.charAt(j));
            }
        }
        //W먼저
        for (int i = 0; i < N; i++) {
            boolean isW = true;
            if(i % 2 == 0){
                isW = !isW;
            }
            for (int j = 0; j < M; j++) {
                isW = !isW;
                if(isW) map_B[i][j] = "W";
                else{
                    map_B[i][j] = "B";
                }
            }
        }
        //B먼저
        for (int i = 0; i < N; i++) {
            boolean isW = false;
            if(i % 2 == 0){
                isW = !isW;
            }
            for (int j = 0; j < M; j++) {
                isW = !isW;
                if(isW) map_W[i][j] = "W";
                else{
                    map_W[i][j] = "B";
                }
            }
        }
        int ans_min = Integer.MAX_VALUE;
        int tmp_min = Integer.MAX_VALUE;
        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                tmp_min = Math.min(check_B(i,j), check_W(i,j));
                ans_min = Math.min(ans_min, tmp_min);
            }
        }
        sb.append(ans_min);
        bw.write(sb.toString());
        bw.close();
    }

    private static int check_B(int row, int col) {
        int cnt_B = 0;
        for (int i = row; i < row+8; i++) {
            for (int j = col; j < col+8; j++) {
                if(!map[i][j].equals(map_B[i][j]))
                    cnt_B++;
            }
        }
        return cnt_B;
    }

    private static int check_W(int row, int col) {
        int cnt_W = 0;
        for (int i = row; i < row+8; i++) {
            for (int j = col; j < col+8; j++) {
                if(!map[i][j].equals(map_W[i][j]))
                    cnt_W++;
            }
        }
        return cnt_W;
    }
}