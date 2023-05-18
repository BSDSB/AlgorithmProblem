package SW_Expert;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW2105_디저트카페 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static int[][] map, dire = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}}; //우하, 좌하, 좌상, 우상
    static boolean[][] visited;
    static int N, ans_max;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans_max = Integer.MIN_VALUE; //결과를 담을 변수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N]; //방문처리
                    list = new ArrayList<>();
                    list.add(map[i][j]);
                    simulation(new Node(i, j, 1), 1, new Node(i, j, 1), 0); //시계 방향으로 회전
                }
            }
            sb.append("#").append(tc).append(" ");
            if (ans_max == Integer.MIN_VALUE)
                sb.append(-1).append("\n");
            else
                sb.append(ans_max).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void simulation(Node n, int d, Node origin, int r_d) { //d는 신경쓰지 말자. r_d의 경우 dfs 진입하면서 왔던 방향을 기억하기 위함

        for (int k = r_d; k < 4; k++) {
            Node nx = new Node(n.row + (dire[k][0]*d), n.col + (dire[k][1]*d), n.depth); //음 d는 신경쓰지 말자 필요없어졌는데 고치기 귀찮아서 안고침

            if(origin.row == nx.row && origin.col == nx.col && nx.depth>=4){ //최소 4가 되어야 다른 디저트 집을 갔다가 나에게 돌아온다.
                ans_max = Math.max(ans_max, nx.depth); //갱신
                return;
            }

            if(!isIn(nx)) continue;
            if(visited[nx.row][nx.col]) continue;;
            if(list.contains(map[nx.row][nx.col])) continue;; //이미 먹었던 디저트인지 확인

            list.add(map[nx.row][nx.col]); //오면서 먹었던 디저트와 중복이 되는지 체크하기 위해서
            nx.depth++;
            visited[nx.row][nx.col] = true;
            simulation(nx, d, origin, k);
            visited[nx.row][nx.col] = false; //새로운 경로를 가기 위해 이미 지니갔던 경로를 지워준다.
            list.remove(list.indexOf(map[nx.row][nx.col])); //다시 돌아왔으므로 삭제
        }
    }

    private static boolean isIn(Node n){
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

