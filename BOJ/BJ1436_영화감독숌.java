package BOJ;

import java.util.Scanner;

public class BJ1436_영화감독숌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int ans = 666;
        int cnt = 1;

        while(N > cnt) {
            ans++;
            int tmp = ans;
            while(tmp >= 666){
                if(tmp%1000 == 666){
                    cnt++;
                    break;
                }
                else{
                    tmp /= 10;
                }
            }
        }
        System.out.println(ans);
    }
}