package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1952_수영장 {
    static int[] plan;
    static int[] price;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++){

            price = new int[4];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 4 ; i++){
                price[i] = Integer.parseInt(st.nextToken());
            }

            plan = new int[13];
            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= 12 ; i++){
                plan[i] = Integer.parseInt(st.nextToken());
            }
            min = price[3];
            recursion(0, 1);
            System.out.println("#" + test_case + " " + min);
        }
    }
    public static void recursion(int cost, int month){
        if(month > 12) {
            min = Math.min(cost, min);
            return;
        }

        if(plan[month] > 0) {
            recursion(cost + price[0] * plan[month], month + 1); //1일 이용권
            recursion(cost + price[1], month + 1); //1달 이용권
            recursion(cost + price[2], month + 3); //3달 이용권
        }
        else{
            recursion(cost, month + 1);
        }
    }
}
