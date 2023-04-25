package BOJ;

import java.util.Scanner;

public class BJ1085_직사각형에서탈출 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int ans_x = 0;
        int ans_y = 0;
        ans_x = Math.min(Math.abs(w-x), x);
        ans_y = Math.min(Math.abs(h-y), y);

        System.out.println(Math.min(ans_x,ans_y));
    }
}
