import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for (int i = 0 ; i < len ; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 0 ; i < len ; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 1) - 1);
            
            if (right.get(topping[i]) == 0) {
                right.remove(topping[i]);
            }
            
            left.put(topping[i], left.getOrDefault(topping[i], 1) + 1);
            
            if (right.size() == left.size()) {
                answer += 1;
            } 
        }
        
        return answer;
    }
}
