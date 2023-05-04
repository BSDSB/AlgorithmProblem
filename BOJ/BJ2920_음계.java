package BOJ;

import java.io.*;
import java.util.Scanner;

public class BJ2920_음계 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int[] num = new int[8];
        Scanner sc = new Scanner(System.in);

//        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            num[i] = sc.nextInt();
        }

        if(num[0] == 1) {
            int cnt = 1;
            for (int i = 1; i < 8; i++) {
                if(num[i] == num[i-1] + 1)
                    cnt++;
            }
            if(cnt == 8)
                sb.append("ascending");
            else
                sb.append("mixed");
        }
        else if(num[0] == 8){
            int cnt = 1;
            for (int i = 1; i < 8; i++) {
                if(num[i] == num[i-1] - 1)
                    cnt++;
            }
            if(cnt == 8)
                sb.append("descending");
            else
                sb.append("mixed");
        }
        else{
            sb.append("mixed");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
