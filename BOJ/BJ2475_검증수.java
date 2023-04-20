package BOJ;

import java.util.Scanner;

public class BJ2475_검증수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += Math.pow(sc.nextDouble(), 2);
        }
        System.out.println(sum%10);
    }
}
