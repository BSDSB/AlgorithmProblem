package BOJ;

import java.io.*;
import java.util.*;

public class BJ1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new LinkedHashMap<>();

        for (int i = 1; i <= N; i++) {
            map.put(br.readLine(), i);
        }

        Object[] Key = map.keySet().toArray();

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if(Character.isDigit(input.charAt(0))){
                sb.append(Key[Integer.parseInt(input)-1]).append("\n");
            }
            else{
                sb.append(map.get(input)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}
