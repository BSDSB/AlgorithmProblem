package BOJ;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1012_유기농배추 {
    static StringTokenizer st = null;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map, dire = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean[][] visited;
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //열
            N = Integer.parseInt(st.nextToken()); //행
            K = Integer.parseInt(st.nextToken()); //배추의 개수

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                map[row][col] = 1;
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && !visited[i][j]){
                        bfs(new Node(i,j));
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void bfs(Node n) {
        Queue<Node> q = new ArrayDeque<>();
        visited[n.row][n.col] = true;
        q.add(n);

        while(!q.isEmpty()){
            Node cur = q.poll();

            for (int k = 0; k < 4; k++) {
                Node nx = new Node(cur.row + dire[k][0], cur.col + dire[k][1]);

                if(nx.row < 0 || nx.row >= N || nx.col < 0 || nx.col >= M) continue;
                if(map[nx.row][nx.col] == 0) continue;
                if(visited[nx.row][nx.col]) continue;

                visited[nx.row][nx.col] = true;
                q.add(nx);
            }
        }

    }
    static class Node{
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
