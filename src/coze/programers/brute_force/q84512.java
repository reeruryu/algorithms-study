package coze.programers.brute_force;

public class q84512 {
    public int solution(String word) {
        String str = "AEIOU";
        int[] increase = {781,156,31,6,1};
        int index,result=word.length();
        for(int i=0;i<word.length();i++){
            index = str.indexOf(word.charAt(i));
            result+=increase[i]*index;
        }
        return result;
    }
}
