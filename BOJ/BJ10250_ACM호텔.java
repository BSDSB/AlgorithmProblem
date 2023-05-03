package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ10250_ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int floor = N % H;
            int number = N / H;

            if(floor == 0){
                sb.append(H * 100 + number).append("\n");
            }
            else{
                sb.append(floor * 100 + number+1).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
/*
int ans_W = 0;
            int ans_H = 0;
            int cnt = 0;
            for (ans_W = 1; ans_W <= W; ans_W++) {
                for (ans_H = 1; ans_H <= H; ans_H++) {
                    cnt++;
                    if(cnt == N)
                        break;
                }
                if(cnt == N)
                    break;
            }
            if(ans_W < 10)
                sb.append(ans_H).append(0).append(ans_W).append("\n");
            else
                sb.append(ans_H).append(ans_W).append("\n");
 */
