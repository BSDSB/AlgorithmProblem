package SW_Expert;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW4193_수영대회결승전 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static Node start, end;
    static int N, sea[][], ans_min;
    static int[] d_row = {0,1,0,-1};
    static int[] d_col = {1,0,-1,0};
    static boolean visited[][] ,flag;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine()); //수영장의 크기

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
            visited = new boolean[N][N];
            flag = false;

            bfs();
            if(flag)
                sb.append("#").append(tc).append(" ").append(ans_min).append("\n");
            else
                sb.append("#").append(tc).append(" ").append(-1).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.row][start.col] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            visited[cur.row][cur.col] = true;

            if(cur.row == end.row && cur.col == end.col){
                ans_min = Math.min(ans_min, cur.time);
                flag = true;
            }

            for (int k = 0; k < 4; k++) {
                Node nx = new Node(cur.row + d_row[k], cur.col + d_col[k], cur.time);
                if(!isIn(nx)) continue;
                if(visited[nx.row][nx.col]) continue;
                if(ans_min < cur.time) continue;
                if(sea[nx.row][nx.col] == 1) continue;

                if(sea[nx.row][nx.col] == 2){
                    nx.time += 1 + (2 - cur.time%3);
//                    visited[nx.row][nx.col] = true;
                    q.add(nx);
                    continue;
                }
//                visited[nx.row][nx.col] = true;
                nx.time++;
                q.add(nx);
            }
        }
    }

    private static boolean isIn(Node n){
        return n.row < N && n.row >=0 && n.col < N && n.col >= 0;
    }
    static class Node{
        int row,col,time;

        public Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}