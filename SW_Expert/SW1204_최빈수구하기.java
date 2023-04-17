package SW_Expert;

import java.util.Scanner;

public class SW1204_최빈수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case < T; test_case++){

            int t_num = sc.nextInt();

            int[] std = new int[1000];
            int[] check = new int[101];

            for(int i = 0; i < std.length ; i++){
                std[i] = sc.nextInt();
                check[std[i]]++;
            }
            int max = 0;
            int max_idx = 0;

            for(int i = 0; i < check.length ; i++) {
                if (max <= check[i]) {
                    max = check[i];
                    max_idx = i;
                }
            }
            System.out.println("#" + test_case + " " + max_idx);
        }
    }
}
