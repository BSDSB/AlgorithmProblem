package SW_Expert;

import java.util.Scanner;

public class SW1209_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++) {
            int T = sc.nextInt();
            int[][] matrix = new int[100][100];

            for (int i = 0; i < 100; i++)
                for (int j = 0; j < 100; j++)
                    matrix[i][j] = sc.nextInt();

            int row_sum = 0;
            int col_sum = 0;
            int dia_sum = 0;
            int re_dia_sum = 0;
            int max = 0;
            for (int i = 0; i < 100; i++) {
                row_sum = 0;
                col_sum = 0;
                for (int j = 0; j < 100; j++) {
                    row_sum += matrix[i][j];
                    col_sum += matrix[j][i];
                }
                if (max < row_sum) max = row_sum;
                if (max < col_sum) max = col_sum;
            }
            for (int i = 0; i < 100; i++) {
                dia_sum += matrix[i][i];
                re_dia_sum += matrix[99 - i][i];
            }
            if (max < dia_sum) max = dia_sum;
            if (max < re_dia_sum) max = re_dia_sum;

            System.out.println("#" + T + " " + max);
        }
    }
}
