package BOJ;
import java.util.*;
import java.io.*;
public class BJ1259_팰린드롬수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String num = "";

        while(true){
            num = sc.nextLine();
            if(num.equals("0"))
                break;
            boolean check = true;
            for (int i = 0; i < num.length()/2; i++) {
                if(num.charAt(i) != num.charAt(num.length()-1-i)){
                    check = false;
                }
            }
            if(check){
                sb.append("yes").append("\n");
            }
            else{
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}
