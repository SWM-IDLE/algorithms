import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> dangHatDa = new HashMap<>();
        Map<String, Set<String>> hatDa = new HashMap<>();
        
        
        for (String r : report) {
            String[] rr = r.split(" ");
            if (dangHatDa.containsKey(rr[1])) {
                dangHatDa.get(rr[1]).add(rr[0]);   
            } else {
                dangHatDa.put(rr[1], new HashSet<>());
                dangHatDa.get(rr[1]).add(rr[0]);
            }
            
            if (hatDa.containsKey(rr[0])) {
                hatDa.get(rr[0]).add(rr[1]);   
            } else {
                hatDa.put(rr[0], new HashSet<>());
                hatDa.get(rr[0]).add(rr[1]);
            }
        }
        
        Set<String> jungji = new HashSet<>();
        for (String key : dangHatDa.keySet()) {
            if (dangHatDa.get(key).size() >= k) {
                jungji.add(key);
            }
        }
        
        System.out.print(jungji);
        
        int idx = 0;
        for (String id : id_list) {
            for (String jungjiId : jungji) {
                if (hatDa.get(id) != null && hatDa.get(id).contains(jungjiId)) {
                    answer[idx] += 1;
                }
            }
            idx += 1;
        }
        return answer;
    }
}
