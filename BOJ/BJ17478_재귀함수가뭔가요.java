package BOJ;

import java.util.Scanner;

public class BJ17478_재귀함수가뭔가요 {
    static final String FIRST_SENTENCE = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    static final String STR1 = "\"재귀함수가 뭔가요?\"\n";
    static final String STR2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static final String STR3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static final String STR4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    static int num_def;
    static String[] arr = {STR1, STR2, STR3, STR4};
    static final String ANS = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    static final String FINAL_STRING = "라고 답변하였지.\n";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        System.out.print(FIRST_SENTENCE);
        num_def = num;
        recursion(num);
    }

    public static void recursion(int n) {
        if (n == 0) {
            for(int j = 0; j < (num_def - n); j++)
                System.out.print("____");
            System.out.print(STR1);
            for(int j = 0; j < (num_def - n); j++)
                System.out.print("____");
            System.out.print(ANS);
            for(int j = 0; j < (num_def - n); j++)
                System.out.print("____");
            System.out.print(FINAL_STRING);
            return;
        }
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < (num_def - n); j++)
                System.out.print("____");
            System.out.print(arr[i]);
        }
        recursion(n - 1);
        for(int j = 0; j < (num_def - n); j++)
            System.out.print("____");
        System.out.print(FINAL_STRING);
    }
}