package BOJ;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1874_스택수열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int start = 0;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num > start) {
                for (int j = start+1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                start = num;
            }
            else if(stack.peek() != num){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
