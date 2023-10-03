package reeruryu.baekjoon.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2503 {
    static int N;
    static boolean[] check = new boolean[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 가능한 정답의 경우 check 배열을 true로, 가능하지 않은 경우 false로 설정
        for (int i = 123; i < 1000; i++){
            String str = String.valueOf(i);

            if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') continue;
            if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2)
                    || str.charAt(1) == str.charAt(2)) continue;
            check[i] = true;
        }

        for (int i = 0; i < N; i++) {
            // 입력받은 값과 정답과의 스트라이크와 볼 값
            st = new StringTokenizer(br.readLine());
            int req = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 예상 가능한 모든 정답을 탐색
            for (int ans = 123; ans < 1000; ans++) {
                // 만약 정답 가능성이 있는 수라면
                if (check[ans]) {
                    int ns = 0;
                    int nb = 0;

                    // 정답 가능성이 있는 수와 입력받은 수와 스트라이크와 볼 비교
                    // 이 때 입력받은 수, 정답 가능성이 있는 수 각각을 반복문을 돌려 각 자리수와 값을 비교
                    for (int first = 0; first < 3; first++) {
                        char req_split = String.valueOf(req).charAt(first); // 356

                        for (int second = 0; second < 3; second++) {
                            char ans_split = String.valueOf(ans).charAt(second); // 123 (정답 가능성)

                            // 자리수도 같고 값도 같다면 스트라이크
                            // 자리수는 다른데 값은 같다면 볼
                            if (req_split == ans_split && first == second) ns++;
                            else if (req_split == ans_split && first != second) nb++;
                        }
                    }

                    // 개수가 다르다면 false
                    check[ans] = ns == s && nb == b;
                }
            }
        }

        // 정답 가능성이 있는 수를 세서 카운트 및 출력
        int ans = 0;
        for (int i=123; i < 1000; i++) {
            if (check[i]) ans++;
        }

        System.out.println(ans);
    }
}
