package BOJ;

import java.util.Scanner;

public class BJ1157_단어공부 {
    static String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[26];

        String input = sc.nextLine();
        input = input.toUpperCase();

        for (int i = 0; i < input.length(); i++) {
            cnt[alph.indexOf(input.charAt(i))]++;
        }
        int result = Integer.MIN_VALUE;
        char re_idx = '?';

        for (int i = 0; i < 26; i++) {
            if(result < cnt[i]){
                result = cnt[i];
                re_idx = alph.charAt(i);
            }
            else if (result == cnt[i]) {
                re_idx = '?';
            }
        }
        System.out.println(re_idx);
    }
}
