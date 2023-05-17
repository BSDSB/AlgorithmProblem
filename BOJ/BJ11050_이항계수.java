package BOJ;

import java.util.Scanner;

public class BJ11050_이항계수 {
    static int N, R, ans_cnt;
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();

        visited = new boolean[N];
        dfs(0,0);
        System.out.println(ans_cnt);
    }

    private static void dfs(int cnt, int start) {
        if(cnt == R){
            ans_cnt++;
        }
        for (int i = start; i < N; i++) {
            dfs(cnt+1, i+1);
        }
    }
}
