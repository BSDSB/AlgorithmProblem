package BOJ;

import java.io.*;
import java.util.*;

public class BJ10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return 0;
            }
        });
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(list);

        for(Node cur : list){
            sb.append(cur.age).append(" ").append(cur.name).append("\n");
        }
//        while (!list.isEmpty()){
//            Node cur = pq.poll();
//            sb.append(cur.age).append(" ").append(cur.name).append("\n");
//        }
        bw.write(sb.toString());
        bw.close();

    }
    static class Node implements Comparable<Node>{
        int age;
        String name;

        public Node(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.age, o.age);
        }
    }
}
