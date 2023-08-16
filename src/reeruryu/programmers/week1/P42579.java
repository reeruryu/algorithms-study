package reeruryu.programmers.week1;

/*
문제: 프로그래머스 - 베스트앨범 / 난이도: Level 3
정확성  테스트
    테스트 1 〉	통과 (4.11ms, 65.5MB)
    테스트 2 〉	통과 (4.13ms, 80.5MB)
    테스트 3 〉	통과 (2.70ms, 73.1MB)
    테스트 4 〉	통과 (4.07ms, 78.7MB)
    테스트 5 〉	통과 (3.28ms, 77MB)
    테스트 6 〉	통과 (4.06ms, 77.9MB)
    테스트 7 〉	통과 (2.94ms, 77MB)
    테스트 8 〉	통과 (3.96ms, 74.2MB)
    테스트 9 〉	통과 (3.93ms, 81MB)
    테스트 10 〉	통과 (4.18ms, 70.8MB)
    테스트 11 〉	통과 (4.75ms, 74MB)
    테스트 12 〉	통과 (2.96ms, 79.3MB)
    테스트 13 〉	통과 (2.87ms, 74.8MB)
    테스트 14 〉	통과 (3.00ms, 81.6MB)
    테스트 15 〉	통과 (2.92ms, 75.4MB)
*/

import java.util.*;

public class P42579 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<String, Integer> totalNum = new HashMap<>();
        Map<String, HashMap<Integer, Integer>> musicNum = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            if (!totalNum.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                musicNum.put(genres[i], map);
                totalNum.put(genres[i], plays[i]);
            } else {
                musicNum.get(genres[i]).put(i, plays[i]);
                totalNum.put(genres[i], totalNum.get(genres[i]) + plays[i]);
            }
        }

        List<String> genreList = new ArrayList<>(totalNum.keySet());
        genreList.sort((x, y) -> totalNum.get(y) - totalNum.get(x));

        for (String genre: genreList) {
            HashMap<Integer, Integer> map = musicNum.get(genre);

            List<Integer> musicList = new ArrayList<>(map.keySet());
            musicList.sort((x, y) -> map.get(y) - map.get(x));

            answer.add(musicList.get(0));
            if (musicList.size() > 1)
                answer.add(musicList.get(1));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
