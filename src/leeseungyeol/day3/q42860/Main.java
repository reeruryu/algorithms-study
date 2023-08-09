package leeseungyeol.day3.q42860;


// Point1. 알파벳은 처음에 무조건 A로 초기화 되어있음, 사실상 상하좌우 정렬 안하고 시작해도 됨.
// Point2. A->Z 가능, 첫번째에서 마지막 알파벳으로 이동 가능. (사실상 문제 없음, 순서 상관 없 -> 정렬 안해도 됨)
// Point3. 이때 A 가 중요, A가 있는지, 없는지에 따라서 좌우 이동 이 2개 이상씩 차이가 나는 경우가 있음.
class Solution {
    public int solution(String name) {

        int length = name.length();
        int aPos = 'A'; // 'A'의 아스키 코드 65
        int zPos = 'Z'; // 'Z'의 아스키 코드 90
        int answer = 0;

        // 1. 알파벳 변경, 위아래 횟수 계산 (A 혹은 Z 에서 이동했을때 더 가까운 곳을 찾음)
        // .toCharArray 를 쓰면 문자열을 문자배열로 변경 가능.
        for (char ch : name.toCharArray()) {
            answer += Math.min(ch - aPos, zPos + 1 - ch); // 둘중 더 작은값 누적
        }

        int minMoves = length - 1; // 좌우이동 최대값은 전체길이 -1 (문자가 3글자면 2번)

        // 2. 좌우 횟수 계산
        for (int i = 0; i < length; i++) {

            int nextIndex = i + 1;

            // 'A'가 아닌 문자를 만날 때까지 nextIndex 업데이트
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            //
            int reverseMoves = (length - (nextIndex - i)) + (Math.min(i, length - nextIndex));

            // minMoves 업데이트
            minMoves = Math.min(minMoves, reverseMoves);
        }

       // System.out.println(answer);
       // System.out.println(minMoves);

        return answer + minMoves; // 알파벳 변경 횟수와 좌우 이동 횟수를 더한 결과를 반환합니다.
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String name = "HEAAAWORLA";

        int answer = solution.solution(name);
        System.out.println(answer);
    }
}
