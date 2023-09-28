class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int len = String.valueOf(storey).length();
        
        while (storey > 0) {
            int ans = storey % 10;
            storey /= 10;
            
            if (ans < 5) {
                answer += ans;
            }
            else if (ans > 5) {
                answer += (10 - ans);
                storey += 1;
            }
            else if (storey % 10 >= 5) {
                answer += (10 - ans);
                storey += 1;
            } else {
                answer += ans;
            }
        }
        
        return answer;
    }
}
