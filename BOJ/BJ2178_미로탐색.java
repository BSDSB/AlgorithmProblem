package BOJ;

import java.io.*;
import java.util.*;

public class BJ2178_미로탐색 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int[][] map, distance, dire = {{0,1},{1,0},{0,-1},{-1,0}};//우하 좌상
    static int N,M;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        bfs(new Node(0,0,1));
        System.out.println(distance[N-1][M-1]);
    }
    public static void bfs(Node n) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(n);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                Node nx = new Node(cur.row + dire[i][0], cur.col + dire[i][1], cur.count + 1);

                if (nx.row < 0 || nx.row >= N || nx.col < 0 || nx.col >= M) continue;
                if (distance[nx.row][nx.col] <= nx.count) continue;

                if (map[nx.row][nx.col] == 1) {
                    distance[nx.row][nx.col] = nx.count;
                    q.add(nx);
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int row, col, count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.count, o.count);
        }


    }
}
