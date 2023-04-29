package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ1920_수찾기 {
    static int N_num[], N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        N_num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            N_num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(N_num);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if(binarySearch(Integer.parseInt(st.nextToken()))){
                sb.append("1").append("\n");
            }
            else{
                sb.append("0").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
    public static boolean binarySearch(int num){
        int top = N-1;
        int bottom = 0;

        while(top >= bottom){
            int mid = (top+bottom)/2;

            if(N_num[mid] > num){
                top = mid - 1;
            }
            else if(N_num[mid] < num){
                bottom = mid + 1;
            }
            else if(N_num[mid] == num){
                return true;
            }
        }
        return false;
    }
}
