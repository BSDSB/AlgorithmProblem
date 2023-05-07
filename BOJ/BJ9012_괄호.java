package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BJ9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            char[] input = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < input.length; i++) {
                if(input[i] == '('){
                    stack.push(input[i]);
                }
                 else{
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }
                    else
                        stack.push(input[i]);
                }
            }
            if(stack.isEmpty())
                sb.append("YES").append("\n");
            else{
                sb.append("NO").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
