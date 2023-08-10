package coze.programers.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q42579 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genresPlays = new HashMap<>();
        HashMap<Integer, Integer> playsIndex = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!genresPlays.containsKey(genres[i])) {
                genresPlays.put(genres[i], plays[i]);
            } else {
                genresPlays.put(genres[i], genresPlays.get(genres[i]) + plays[i]);
            }
        }

        for (int i = 0; i < plays.length; i++) {
            playsIndex.put(i, plays[i]);
        }

        List<String> genreSort = new ArrayList<>(genresPlays.keySet());
        genreSort.sort((s1, s2) -> (genresPlays.get(s2).compareTo(genresPlays.get(s1))));
        List<Integer> indexSort = new ArrayList<>(playsIndex.keySet());
        indexSort.sort((s1, s2) -> (playsIndex.get(s2).compareTo(playsIndex.get(s1))));

        List<Integer> list = new ArrayList<>();

        for (String genre : genreSort) {
            int cnt = 1;
            for (int i : indexSort) {
                if (genres[i].equals(genre) && cnt < 3) {
                    list.add(i);
                    cnt++;
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
