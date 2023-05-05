package BOJ;

import java.io.*;
import java.util.*;

public class BJ10816_숫자카드2 {
    static int N_arr[], N, M_arr[], ans[],cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        ans = new int[20_000_001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ans[Integer.parseInt(st.nextToken()) + 10_000_000]++;
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(ans[Integer.parseInt(st.nextToken()) + 10_000_000]).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
    }

}
/*
N = Integer.parseInt(br.readLine());
        N_arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            N_arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(N_arr);
        int M = Integer.parseInt(br.readLine());
        M_arr = new int[M];

        ans = new int[M];
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            binarySearch(Integer.parseInt(st.nextToken()));
            cnt++;
        }
        for (int i = 0; i < M; i++) {
            sb.append(ans[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void binarySearch(int num) {
        int bottom = 0;
        int top = N-1;

        while(bottom <= top){
            int mid = (bottom+top)/2;
            int cur = N_arr[mid];

            if(cur > num){
                top = mid-1;
            }
            else if(cur < num){
                bottom = mid + 1;
            }
            else{
                ans[cnt]++;
                int add = 1;
                while(mid+add < N && cur == N_arr[mid+add++]){
                    ans[cnt]++;
                }
                add = -1;
                while(mid+add >= 0 && cur == N_arr[mid+add--]){
                    ans[cnt]++;
                }
                break;
            }
        }
    }
 */
