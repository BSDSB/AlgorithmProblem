package BOJ;

import java.io.*;
import java.util.*;

public class BJ1197_최소스패닝트리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static Edge[] edgeList;
    static int parents[], V, E;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); //정점
        E = Integer.parseInt(st.nextToken()); //간선

        edgeList = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edgeList);
        makeSet();
        int result = 0, cnt = 0;
        for (Edge e : edgeList) {
            if (union(e.from, e.to)) {
                result += e.weight;
                if (++cnt == V - 1) break;
            }
        }
        System.out.println(result);
    }

    private static boolean union(int from, int to) {
        int aRoot = findSet(from);
        int bRoot = findSet(to);

        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    private static int findSet(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);

    }

    private static void makeSet() {
        parents = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            parents[i] = i;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}