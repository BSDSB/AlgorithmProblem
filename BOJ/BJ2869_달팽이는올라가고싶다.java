package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2869_달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = (V-B)/(A-B);

        if((V-B) % (A-B) != 0){
            day++;
        }

        sb.append(day);
        bw.write(sb.toString());
        bw.close();
    }
}