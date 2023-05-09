package BOJ;

import java.io.*;

public class BJ10989_수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //카운팅 정렬
        int[] cnt = new int[10001];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(br.readLine())] ++;
        }

        for(int i = 1; i < 10001; i++){
            while(cnt[i] > 0){
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}