package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2908_상수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        String re_A = "";
        String re_B = "";

        for (int i = 2; i >= 0; i--) {
            re_A += String.valueOf(A.charAt(i));
            re_B += String.valueOf(B.charAt(i));
        }
        int result = Math.max(Integer.parseInt(re_A), Integer.parseInt(re_B));
        System.out.println(result);


    }
}
