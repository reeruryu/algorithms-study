package leeseungyeol.day6.q1062;

import java.util.*;

// ## 백트래킹 문제 (완전탐색)
//        7 6
//        anta rc  tica
//        anta z   tica
//        anta rcz tica
//        anta xxx tica
//        anta pc  tica
//        anta zxx tica
//        anta z   tica
public class Main {
    static int N, K;
    static String[] word;
    static boolean[] learnedWord;
    static int maxWord;

    static void learn(int index, int count) {

        // 1. 모두 다 배운 경우 (정지조건)
        if (count == K - 5) {
            int canReadWord = 0;

            // 읽을 수 있는 단어의 수 계산
            for (String word : word) {

                boolean canRead = true;
                for (char c : word.toCharArray()) {
                    if (!learnedWord[c - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) {
                    canReadWord++;
                }

            }

            // 최대로 읽을 수 있는 단어의 개수 갱신
            maxWord = Math.max(maxWord, canReadWord);
            return;
        }

        // 2. 선택할 수 있는 알파벳을 하나씩 선택하여 완전 탐색
        for (int i = index; i < 26; i++) {
            if (!learnedWord[i]) {
                learnedWord[i] = true;
                learn(i, count + 1);
                learnedWord[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();
        // 개행꼭 처리할것...
        scanner.nextLine();

        word = new String[N];
        learnedWord = new boolean[26];
        maxWord = 0;

        // 1. 앞뒤 4개 짜르고 단어를 처리
        for (int i = 0; i < N; i++) {
            String word = scanner.nextLine();
            Main.word[i] = word.substring(4, word.length() - 4);
        }


        // 2. 5가지 알파벳 처리
        learnedWord['a' - 'a'] = true;
        learnedWord['n' - 'a'] = true;
        learnedWord['t' - 'a'] = true;
        learnedWord['i' - 'a'] = true;
        learnedWord['c' - 'a'] = true;

//        System.out.println("WORD :"+Arrays.toString(word));
//        System.out.println("LEARNED WORD :"+Arrays.toString(word));

        learn(0, 0);
        System.out.println(maxWord);
    }

}
