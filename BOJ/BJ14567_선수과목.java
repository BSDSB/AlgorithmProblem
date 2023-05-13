package BOJ;

import java.io.*;
import java.util.*;

public class BJ14567_선수과목 {
    static int N,M, inDegree[];
    static ArrayList<Node>[] adjList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        inDegree = new int[N+1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to,1));
            inDegree[to]++;
        }
        ArrayList<Node> list = bfs();
        for (int i = 1; i <= N; i++) {
            for (Node ans : list) {
                if(i == ans.to) {
                    sb.append(ans.semester).append(" ");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static ArrayList<Node> bfs() {
        ArrayList<Node> orderList = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0){
                q.add(new Node(i,1));
            }
        }
        while(!q.isEmpty()){
            Node cur = q.poll();
            orderList.add(cur);

            for (Node vertex : adjList[cur.to]) {
                if(--inDegree[vertex.to] == 0){
                    vertex.semester = cur.semester + 1;
                    q.add(vertex);
                }
            }
        }
        return orderList;
    }
    static class Node{
        int to, semester;

        public Node(int to, int semester) {
            this.to = to;
            this.semester = semester;
        }
    }
}
