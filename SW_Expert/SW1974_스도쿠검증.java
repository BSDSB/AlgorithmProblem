package SW_Expert;

import java.util.Scanner;

public class SW1974_스도쿠검증 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1 ; test_case <= T ; test_case++) {
            int result = 1;

            int[][] sudo = new int[9][9];

            for(int i = 0 ; i < 9 ; i++)
                for(int j = 0 ; j < 9 ; j++)
                    sudo[i][j] = sc.nextInt();

            // 행, 열 확인
            for(int i = 0 ; i < 9 ; i++){
                int[] row_check = new int[10];
                int[] col_check = new int[10];

                for(int j = 0 ; j < 9 ; j++) {
                    row_check[sudo[i][j]]++;
                    col_check[sudo[j][i]]++;
                }

                for (int check = 1; check < 10; check++) {
                    if(row_check[check] > 1)
                        result = 0;
                    if(col_check[check] > 1)
                        result = 0;
                }
            }
            // 3x3 확인
            for(int k = 0; k < 7; k += 3) {
                for(int l = 0 ; l < 7 ; l += 3) {
                    int[] idx = new int[10];
                    for (int i = k; i < k + 3; i++)
                        for (int j = l; j < l + 3; j++)
                            idx[sudo[i][j]]++;

                    for (int check = 1; check < 10; check++) {
                        if (idx[check] > 1)
                            result = 0;
                    }
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}
