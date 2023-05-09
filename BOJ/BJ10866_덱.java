package BOJ;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            if(input.equals("push_front")){
                q.addFirst(Integer.parseInt(st.nextToken()));
            }
            if(input.equals("push_back")){
                q.addLast(Integer.parseInt(st.nextToken()));
            }
            else if (input.equals("pop_front")) {
                if(q.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(q.pollFirst()).append("\n");
            }
            else if (input.equals("pop_back")) {
                if(q.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(q.pollLast()).append("\n");
            }
            else if(input.equals("size")){
                sb.append(q.size()).append("\n");
            }
            else if(input.equals("empty")){
                if(q.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            else if (input.equals("front")) {
                if(q.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(q.getFirst()).append("\n");
            }
            else if (input.equals("back")) {
                if(q.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(q.getLast()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
