package dmdwn99.programmers.hash;
import java.util.*;
public class P42579 {
    class Solution {
        class Song{
            int id;
            String genre;
            int play;
            Song(int id, String genre, int play){
                this.id = id;
                this.genre = genre;
                this.play = play;
            }
        }
        public int[] solution(String[] genres, int[] plays) {
            int[] answer = {};
            List<Song> list = new ArrayList<>();

            for (int i=0;i<genres.length;i++){
                Song song = new Song(i, genres[i], plays[i]);
                list.add(song);
            }

            Collections.sort(list, (s1, s2) -> s2.play - s1.play);

            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i=0;i<genres.length;i++)
                hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);

            List<String> keyList = new ArrayList<>(hashMap.keySet());
            Collections.sort(keyList, (s1, s2) -> hashMap.get(s2) - hashMap.get(s1));

            int cnt = 0;

            List<Integer> tmp = new ArrayList<>();

            for (String genre : keyList) {
                for (Song song : list){
                    if (song.genre.equals(genre)) {
                        tmp.add(song.id);
                        cnt++;
                    }
                    if (cnt > 1)
                        break;
                }
                cnt = 0;
            }

            answer = new int[tmp.size()];
            for (int i = 0;i<tmp.size();i++)
                answer[i] = tmp.get(i);
            return answer;
        }
    }
}
