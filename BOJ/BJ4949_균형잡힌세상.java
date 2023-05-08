package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        String start = br.readLine();
        while(!start.equals(".")){
            Stack<Character> stack = new Stack<>();

            char[] input = start.toCharArray();

            for (int i = 0; i < input.length; i++) {
                if(input[i] == '(' || input[i] == '['){
                    stack.push(input[i]);
                }
                else if(!stack.isEmpty() && (input[i] == ')' || input[i] == ']')){
                    if(input[i] == ')'){
                        if(stack.peek() == '(') {
                            stack.pop();
                        }
                        else{
                            stack.push(input[i]);
                        }
                    }
                    else{
                        if(stack.peek() == '[') {
                            stack.pop();
                        }
                        else{
                            stack.push(input[i]);
                        }
                    }
                } else if ((input[i] == ')' || input[i] == ']')) {
                    stack.push(input[i]);
                }
            }
            if(stack.isEmpty()){
                sb.append("yes").append("\n");
            }
            else{
                sb.append("no").append("\n");
            }
            start = br.readLine();
        }
        System.out.println(sb);
    }
}
