package SW_Expert;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW4192_수영대회 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static int N, sea[][] ,ans_min;
    static Node start, end;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            sea = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    sea[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);

            st = new StringTokenizer(br.readLine());
            end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);

            ans_min = Integer.MAX_VALUE;
            bfs();

            ans_min = Integer.MAX_VALUE == ans_min ? -1 : ans_min;
            sb.append("#").append(tc).append(" ").append(ans_min).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
    static int[] d_row = {0,1,0,-1};
    static int[] d_col = {1,0,-1,0};
    private static void bfs() {
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.time, o2.time);
            }
        });
        visited[start.row][start.col] = true;
        q.add(start);

        while (!q.isEmpty()){
            Node cur = q.poll();

            if(cur.row == end.row && cur.col == end.col){
                ans_min = cur.time;
                break;
            }

            for (int k = 0; k < 4; k++) {
                Node nx = new Node(cur.row + d_row[k], cur.col + d_col[k], cur.time);
                if(!isIn(nx)) continue;
                if(visited[nx.row][nx.col]) continue;
                if(sea[nx.row][nx.col] == 1) continue;

                visited[nx.row][nx.col] = true;
                nx.time++;
                q.add(nx);
            }
        }
    }
    private static boolean isIn(Node n){
        return n.row < N && n.row >=0 && n.col < N && n.col >= 0;
    }
    static class Node{
        int row, col, time;

        public Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

    }
}
