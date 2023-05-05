package BOJ;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            if(input.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if (input.equals("pop")) {
                if(stack.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(stack.pop()).append("\n");
            }
            else if(input.equals("size")){
                sb.append(stack.size()).append("\n");
            }
            else if(input.equals("empty")){
                if(stack.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            else if (input.equals("top")) {
                if(stack.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(stack.peek()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
