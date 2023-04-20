package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1916_최소비용구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 도시 정점 개수
        int M = Integer.parseInt(br.readLine()); //버스 간선 개수

        ArrayList<Node>[] adjList = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        boolean visited[] = new boolean[N+1];

        int cur, min;
        for (int i = 0; i < N; i++) {
            cur = -1;
            min = Integer.MAX_VALUE;

            for (int j = 1; j <= N; j++) {
                if(!visited[j] && min > distance[j]) {
                    min = distance[j];
                    cur = j;
                }
            }
            if(cur == -1)
                break;

            visited[cur] = true;
            if(cur == end) break;
            for (Node n : adjList[cur]) {
                if(!visited[n.to] && distance[n.to] > min + n.cost){
                    distance[n.to] = min + n.cost;
                }
            }
        }
        sb.append(distance[end]);
        bw.write(sb.toString());
        bw.close();


    }
    static class Node{
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
