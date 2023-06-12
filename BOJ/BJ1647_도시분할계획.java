package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1647_도시분할계획 {
    static ArrayList<Node> edgeList;
    static int[] root;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //집의 개수
        M = Integer.parseInt(st.nextToken()); // 길의 개수

        edgeList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edgeList.add(new Node(from,to, cost));
        }
        Collections.sort(edgeList);
        makeSet();

        int result = 0, count = 0;
//        ArrayList<Integer> list = new ArrayList<>();

        for (Node n : edgeList) {
            if(union(n.from, n.to)){
                result += n.cost;
//                list.add(n.cost);
                if(++count == N-2)
                    break;
            }
        }
//        Collections.sort(list);
//        System.out.println(result - list.get(list.size()-1));
        System.out.println(result);
    }
    private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot){
            return false;
        }
        root[bRoot] = aRoot;
        return true;
    }

    private static int findSet(int a) {
        if(root[a] == a) return a;
        return root[a] = findSet(root[a]);
    }

    private static void makeSet() {
        root = new int[N+1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }
    }

    static class Node implements Comparable<Node>{
        int from,to,cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }
}
