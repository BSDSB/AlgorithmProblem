package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15903_카드합체놀이 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean visited[];
    static int n,m, numbers[], ans_min;
    static int[] new_num;
    static int[] tmp_num;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 카드 개수
        m = Integer.parseInt(st.nextToken()); // 카드 합체가 몇번인지.

        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            ans_min = Integer.MAX_VALUE;
            dfs(0);
            numbers = tmp_num;
        }
        sb.append(ans_min);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static void dfs(int cnt) {
        if(cnt == n){
            int select_cnt = 0;
            for (int i = 0; i < n; i++) {
                if(visited[i]) {
                    select_cnt++;
                }
            }
            if(select_cnt == 2) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        sum += numbers[i];
                    }
                }
                new_num = Arrays.copyOf(numbers, n);
                int tmp = 0;
                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        new_num[i] = sum;
                    }
                    tmp += new_num[i];
                }
                if(ans_min > tmp){
                    ans_min = tmp;
                    tmp_num = new_num;
                }
            }
        }
        else{
            visited[cnt] = true;
            dfs(cnt+1);
            visited[cnt] = false;
            dfs(cnt+1);
        }
    }
}
