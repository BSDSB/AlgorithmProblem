package BOJ;

import java.util.Scanner;

public class BJ1182_부분수열의합 {
    static int N,S;
    static int[] input, numbers;
    static int ans;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        ans = 0;
        input = new int[N];
        for(int i = 0 ; i < N ; i++){
            input[i] = sc.nextInt();
        }
        visited = new boolean[N];
        numbers = new int[N];
        dfs(0, 0);
        System.out.println(ans);

    }
    public static void dfs(int cnt, int sum){
        if(cnt == N) {
            int check = 0;
            for(int i = 0 ; i < N; i++){
                if(!visited[i]) check++;
            }
            if(check == N)
                return;
            if (sum == S){
                ans++;
            }
        }
        else{
            visited[cnt] = true;
            dfs(cnt + 1, sum + input[cnt]);
            visited[cnt] = false;
            dfs(cnt + 1, sum);
        }
    }
}
