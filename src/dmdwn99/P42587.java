package dmdwn99;

public class P42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int max = 0, idx1 = 0, idx2 = 0, len = priorities.length,cnt=0;
        for (int i = 0; i < len; i++){
            for (int j = idx1; j<len+idx1; j++){
                if (priorities[j%len] > max){
                    max = priorities[j%len];
                    idx2 = j%len;
                }
            }
            cnt++;
            if (idx2 == location) return cnt;
            priorities[idx2] = 0;
            max = 0;
            idx1 = idx2;
        }
        return cnt;
    }
}
