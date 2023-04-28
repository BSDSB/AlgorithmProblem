package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1654_랜선자르기 {
    static int line[], K, N;
    static long max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        line = new int[K];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, line[i]);
        }

        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long hi = max;
        long lo = 1;

        long result = Integer.MIN_VALUE;
        while(hi >= lo){
            long mid = (hi + lo)/2;

            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += line[i]/mid;
            }
            if(N > sum){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
                result = Math.max(mid, result);
            }
        }
        return result;
    }
}
