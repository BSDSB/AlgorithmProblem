package BOJ;

import java.util.Scanner;

public class BJ2292_벌집 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 1;
        int ans = 1;

        while(true) {
            if(N == 1){
                break;
            }
            if (cnt < N && (cnt+6*ans) >= N) {
                ans++;
                break;
            }
            cnt += 6*ans;
            ans++;
        }
        System.out.println(ans);
    }
}
