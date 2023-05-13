package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11724_연결요소의개수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int ver = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        list = new ArrayList[ver+1];
        for (int i = 1; i <= ver; i++) {
            list[i] = new ArrayList<>();
        }

        visited = new boolean[ver+1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        int ans = 0;
        for (int vertex = 1; vertex <= ver; vertex++) {
            if(!visited[vertex]){
                bfs(vertex);
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static void bfs(int vertex) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[vertex] = true;
        q.add(vertex);

        while (!q.isEmpty()){
            int cur = q.poll();

            for (int ver : list[cur]) {
                if(visited[ver]) continue;
                q.add(ver);
                visited[ver] = true;
            }
        }
    }
}
