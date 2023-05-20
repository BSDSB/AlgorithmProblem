package BOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ15829_Hashing {
    static String alph = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int r = 31;
        int M = 1234567891;
        long pow = 1;
        char[] input = sc.next().toCharArray();

        long sum = 0;
        for (int i = 0; i < L; i++) {
            sum += (alph.indexOf(input[i])+1)*pow % M;
            pow = pow*31 %M;
        }
        System.out.println(sum%M);
    }
}
