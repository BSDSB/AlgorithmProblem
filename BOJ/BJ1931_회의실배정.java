package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1931_회의실배정 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;
    public static void main(String[] args) throws IOException {
        int cnt = Integer.parseInt(br.readLine());
        int ans = 1;
        meeting[] meet = new meeting[cnt];
        for(int i = 0 ; i < cnt ; i++) {
            st = new StringTokenizer(br.readLine());
            meet[i] = new meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meet);
        ArrayList<meeting> list = new ArrayList<>();
        list.add(meet[0]);

        for(int i = 1 ; i < cnt ; i++){
            if(list.get(list.size() - 1).end <= meet[i].start){
                list.add(meet[i]);
                ans++;
            }
        }
        System.out.println(ans);
    }

    static class meeting implements Comparable<meeting>{
        int start;
        int end;

        public meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(meeting o) {
            return this.end != o.end ?
                    Integer.compare(this.end, o.end) : Integer.compare(this.start, o.start);
        }
    }
}
