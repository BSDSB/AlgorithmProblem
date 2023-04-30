package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2231_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int origin = Integer.parseInt(br.readLine());
        int input = origin;
        int ans = Integer.MAX_VALUE;


        while(input > 0){
            input--;
            int tmp = input;
            int sum = 0;

            while(tmp != 0){
                sum += tmp % 10;
                tmp /= 10;
            }
            if(input+sum == origin) {
                ans = Math.min(ans, input);
            }
        }

        if(ans == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(ans);
    }
}
