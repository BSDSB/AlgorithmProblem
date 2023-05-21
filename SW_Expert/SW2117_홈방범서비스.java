package SW_Expert;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW2117_홈방범서비스 {
    static int[][] map, dire = {{0,1},{1,0},{0,-1},{-1,0}};//우하좌상
    static int N, M, ans, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //도시의 크기
            M = Integer.parseInt(st.nextToken()); //하나의 집이 지불 할 수 있는 비용

            map = new int[N][N];
            ans = 1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Simulation(new Node(i, j, 1));
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
    static boolean[][] visited;
    private static void Simulation(Node n) {
        int home_cnt = 0;
        K = 1;
        visited = new boolean[N][N];
        Queue<Node> q = new ArrayDeque<>();
        visited[n.row][n.col] = true;
        q.add(n);

        if(map[n.row][n.col] == 1) {
            home_cnt++;
        }
        while(!q.isEmpty()){
            Node cur = q.poll();

             if(K != cur.depth){
                 K++;
                 if (0 <= (home_cnt * M) - ((K * K + (K - 1) * (K - 1))))
                     ans = Math.max(ans, home_cnt);
            }

            for (int i = 0; i < 4; i++) {
                Node nx = new Node(cur.row + dire[i][0], cur.col + dire[i][1], cur.depth+1);
                if(!isIn(nx)) continue;
                if(visited[nx.row][nx.col]) continue;
                if(map[nx.row][nx.col] == 1) home_cnt++;

                q.add(nx);
                visited[nx.row][nx.col] = true;
            }
        }
    }

    private static boolean isIn(Node n) {
        return n.row >= 0 && n.row < N && n.col >= 0 && n.col < N;
    }

    static class Node{
        int row, col, depth;

        public Node(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
}