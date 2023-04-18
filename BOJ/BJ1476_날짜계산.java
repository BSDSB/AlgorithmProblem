package BOJ;

import java.util.Scanner;

public class BJ1476_날짜계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = new int[3];
        for(int i =0  ;i < 3; i++)
            input[i] = sc.nextInt();

        int[] tmp = new int[]{1,1,1};
        int cnt = 1;

        while(true){
            if(tmp[0] == input[0] && tmp[1] == input[1] && tmp[2] == input[2]) {
                System.out.println(cnt);
                return;
            }

            tmp[0]++;
            if(tmp[0] > 15) tmp[0] = 1;

            tmp[1]++;
            if(tmp[1] > 28) tmp[1] = 1;

            tmp[2]++;
            if(tmp[2] > 19) tmp[2] = 1;
            cnt++;
        }
    }
}