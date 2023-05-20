package BOJ;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            int num = 0;
            if(!(input.equals("all") || input.equals("empty"))){
                num = Integer.parseInt(st.nextToken());
            }

            if(input.equals("add")){
                set.add(num);
            }
            else if (input.equals("remove")) {
                set.remove(num);
            }
            else if (input.equals("check")) {
                if(set.contains(num)){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else if (input.equals("toggle")) {
                if(set.contains(num)){
                    set.remove(num);
                }
                else {
                    set.add(num);
                }
            }
            else if (input.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if (input.equals("empty")) {
                set.clear();
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
