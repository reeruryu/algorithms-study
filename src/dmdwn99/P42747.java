package dmdwn99;
import java.util.*;
public class P42747 {
    public int solution(int[] citations) {
        Integer[] array = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());
        for (int i=0;i<array.length;i++){
            if (array[i] <= i){
                return i;
            }
        }
        return array.length; // {6,6,6,6}
    }
}
