import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int len = cards.length;
        
        for (int i = 0 ; i < len ; i++) {
            cards[i] -= 1;
        }
        
        int cnt = 0;
        List<Integer> cardGroup = new ArrayList<>();
        
        for (int i = 0 ; i < len ; i++) {
            int cardCnt = 0;
            int j = i;
            while (cards[j] != -1) {
                int tmp = cards[j];
                cards[j] = -1;
                j = tmp;
                cardCnt += 1;
            }
            
            if (cardCnt != 0) {
                cardGroup.add(cardCnt);
            }
        }
        
        if (cardGroup.size() == 1) {
            return 0;
        }
        else {
            Collections.sort(cardGroup, Collections.reverseOrder());
            return cardGroup.get(0) * cardGroup.get(1);
        }
    }
}
