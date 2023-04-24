package BOJ;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ4889_안정적인문자열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        while(true){
            char[] input = br.readLine().toCharArray();

            if(input[0] == '-' ){
                break;
            }
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < input.length; i++) {
                if (input[i] == '{'){
                    stack.push(input[i]);
                }
                else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){

            }

        }
    }
}
