package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2057_작업 {
    static ArrayList<Integer>[] adjList;
    static int[] inDegree, time;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N+1];
        inDegree = new int[N+1];
        time = new int[N+1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int edge_cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < edge_cnt; j++) {
                int to = Integer.parseInt(st.nextToken());
                inDegree[to]++;
                adjList[i].add(to);
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> orderList = new ArrayList<>();

        int[] result = time.clone();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            orderList.add(cur);

            for (int vertex : adjList[cur]) {
                //1. 선행작업이 없다면 주어진 시간 그대로 수행
                //2. 선행작업이 있다면, 선행 작업을 끝낸 시간 + 지금 작업의 시간
                result[vertex] = Math.max(result[vertex], result[cur] + time[vertex]);
                if(--inDegree[vertex] == 0){
                    q.add(vertex);
                }
            }
        }
        int ans = 0;
        if(orderList.size() == N){
            for (int vertex : orderList) {
                ans = Math.max(result[vertex], ans);
            }
        }
        return ans;
    }
}