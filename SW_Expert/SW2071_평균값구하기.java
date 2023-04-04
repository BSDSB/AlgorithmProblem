package SW_Expert;

import java.util.ArrayList;
import java.util.Scanner;

public class SW2071_평균값구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0 ; i < T; i++){
            ArrayList<Float> list = new ArrayList<Float>();
            float sum = 0;

            for(int j = 0 ; j < 10 ; j++) {
                list.add(sc.nextFloat());
                sum += list.get(j);
            }
            System.out.println("#" + (i+1) + " " + Math.round(sum/10));
        }
    }
}
