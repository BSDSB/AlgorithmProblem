package SW_Expert;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW2382_미생물격리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //셀의 개수
            int M = Integer.parseInt(st.nextToken()); //격리 시간
            int K = Integer.parseInt(st.nextToken()); //미생물 군집의 수

            int[][] info = new int[K][4];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    info[i][j] = Integer.parseInt(st.nextToken());
                    // 0: 세로위치(행)   1: 가로위치(열)   2: 미생물 수  3: 이동방향(1(상),2(하),3(좌),4(우))
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < K; j++) {
                    if(info[j][0] == -1) continue;

                    if (info[j][3] == 1) { //상
                        if((info[j][0] - 1) == 0){ //경계지역 진입

                            info[j][0] -= 1; // 좌표 이동
                            info[j][2] /= 2; // 경계지역에 왔기 때문에 반은 죽는다.
                            info[j][3] = 2; //방향전환
                        }
                        else {
                            info[j][0] -= 1;
                        }
                    }
                    else if (info[j][3] == 2) { //하
                        if((info[j][0] + 1) == N-1) { //경계지역 진입

                            info[j][0] += 1; // 좌표 이동
                            info[j][2] /= 2; // 경계지역에 왔기 때문에 반은 죽는다.
                            info[j][3] = 1; //방향전환
                        }
                        else {
                            info[j][0] += 1;
                        }
                    }
                    else if (info[j][3] == 3) { //좌
                        if((info[j][1] - 1) == 0) { //경계지역 진입

                            info[j][1] -= 1; // 좌표 이동
                            info[j][2] /= 2; // 경계지역에 왔기 때문에 반은 죽는다.
                            info[j][3] = 4; //방향전환
                        }
                        else {
                            info[j][1] -= 1;
                        }
                    }
                    else if (info[j][3] == 4) { //우
                        if((info[j][1] + 1) == N-1) { //경계지역 진입

                            info[j][1] += 1; // 좌표 이동
                            info[j][2] /= 2; // 경계지역에 왔기 때문에 반은 죽는다.
                            info[j][3] = 3; //방향전환
                        }
                        else {
                            info[j][1] += 1;
                        }
                    }
                }
                for (int j = 0; j < K; j++) { //중복이라면 합친다.
                    if(info[j][0] == -1) continue;

                    int row = info[j][0]; //행
                    int col = info[j][1]; //열
                    ArrayList<Integer> list = new ArrayList<>(); //같은 좌표에 있는 군집들을 모은다.
                    list.add(j);
                    for (int k = 0; k < K; k++) {
                        if(j != k) {
                            if (row == info[k][0] && col == info[k][1]) {
                                list.add(k);
                            }
                        }
                    }
                    int max = Integer.MIN_VALUE;
                    int max_pos = 0;
                    for(int pos : list){ //하나의 좌표에 모여있는 군집들 중 제일 큰 무리를 찾는다.
                        if(max < info[pos][2]){
                            max = info[pos][2];
                            max_pos = pos; //가장 큰 군집의 번호
                        }
                    }
                    for (int pos : list) {
                        if(max_pos != pos){
                            info[max_pos][2] += info[pos][2]; //제일큰 무리로 군집을 다 합친다.
                            Arrays.fill(info[pos], -1); //흡수 당한 무리는 다 -1로 바꾼다.
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < K; i++) { //무리의 합을 구한다.
                if(info[i][0] == -1) continue;
                ans += info[i][2];
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
