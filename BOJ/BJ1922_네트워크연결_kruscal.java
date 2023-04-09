package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1922_네트워크연결_kruscal {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] parents;
    static int com, E;
    static Edge[] edgeList;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        com = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());

        edgeList = new Edge[E];

        for(int i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(edgeList);

        makeSet();
        int result = 0, count = 0; // result는 신장 비용 저장, count는 신장트리 만드느라 쓴 간선의 개수

        for(Edge edge : edgeList){
            if(union(edge.from, edge.to)) { // union 시도.
                result += edge.weight;
                if (++count == com - 1) break; // 사용한 간선의 개수가 v-1이 되면 더이상 반복문을 돌 필요가 없음.
            }
        }
        System.out.println(result);
    }

    static void makeSet(){ //단위 서로 집합으로 만듬
        parents = new int[com+1];
        for (int i = 0 ; i <= com ; i++){
            parents[i] = i; //루트의 부모는 루트 자기 자신
        }
    }

    static int findSet(int a){
        if(a == parents[a]) return a; //자신의 자기의 부모와 같다라는건 root 라는 거다.
        return parents[a] = findSet(parents[a]); //path 압축을 통해 자신의 짱을 부모로 바꿔준다.
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight); //나의 가중치랑 상대 가중치 비교.
        }
    }
}
