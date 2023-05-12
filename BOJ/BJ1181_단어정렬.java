package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.*;

public class BJ1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        String[] input = new String[num];
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return Integer.compare(o1.length(), o2.length());
            }
        });

        for (int i = 0; i < num; i++) {
            input[i] = br.readLine();
        }
//        Arrays.sort(input, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1.length() == o2.length()){
//                    return o1.compareTo(o2);
//                }
//                return Integer.compare(o1.length(), o2.length());
//            }
//        });
//        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if (!pq.contains(input[i])) {
                pq.add(input[i]);
            }
        }
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
//        for (String ans : pq) {
//            sb.append(ans).append("\n");
//        }

//        sb.append(input[0]).append("\n");
//        for (int i = 1; i < num; i++) {
//            if (!input[i].equals(input[i-1])) {
//                sb.append(input[i]).append("\n");
//            }
//        }
        bw.write(sb.toString());
        bw.close();
    }
}