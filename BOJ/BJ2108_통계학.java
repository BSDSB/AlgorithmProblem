package BOJ;

import java.io.*;
import java.util.*;

public class BJ2108_통계학 {
    static int N, num[], cnt[],max;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        cnt = new int[8001];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
            cnt[num[i]+4000]++;
            max = Math.max(cnt[num[i]+4000],max);
        }
        Avg();

        Arrays.sort(num);
        Median();
        Mode();
        Around();


        System.out.println(sb);
    }

    private static void Around() {
        sb.append(num[N-1] - num[0]).append("\n");
    }

    private static void Mode() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if(cnt[i] == max){
                list.add(i-4000);
            }
        }
        if(list.size() == 1)
            sb.append(list.get(0)).append("\n");
        else {
            Collections.sort(list);
            sb.append(list.get(1)).append("\n");
        }
    }

    private static void Median() {
        sb.append(num[N/2]).append("\n");
    }

    private static void Avg() {
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += num[i];
        }
        sb.append(Math.round(sum/N)).append("\n");
    }
}
