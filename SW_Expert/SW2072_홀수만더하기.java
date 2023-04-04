package SW_Expert;

import java.util.Scanner;

public class SW2072_홀수만더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t_case = sc.nextInt();

        for (int i = 0; i < t_case; i++) {
            int sum = 0;

            int[] list = new int[10];
            for(int j = 0 ; j < list.length; j++) {
                list[j] = sc.nextInt();
                if(list[j] % 2 != 0){
                    sum += list[j];
                }
            }
            System.out.printf("#%d %d",i + 1, sum);
            System.out.println();
        }
    }
}
