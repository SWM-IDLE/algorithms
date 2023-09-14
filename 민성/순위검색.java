import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        Map<String, ArrayList<Integer>> infoMap = new HashMap<>();
        
        Integer[][] permu = {{}, {0}, {1}, {2}, {3}, {0,1}, {0,2}, {0,3}, {1,2}, {1,3}, {2,3}, {0,1,2}, {0,1,3}, {0,2,3}, {1,2,3}, {0,1,2,3}}; // 15
        for (String i : info) {
            
            String[] conditions = i.split(" ");
            
            for (Integer[] p : permu) {
                StringBuilder sb = new StringBuilder();
                for (Integer idx : p) {
                    sb.append(conditions[idx]);
                }
                String str = sb.toString();
                
                if (infoMap.containsKey(str)) {
                    infoMap.get(str).add(Integer.valueOf(conditions[4]));
                }
                else {
                    infoMap.put(str, new ArrayList<Integer>());
                    infoMap.get(str).add(Integer.valueOf(conditions[4]));
                }
            }            
        }
      
        for (String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key));
        }
        
        int idx = 0;
        for (String qr : query) {
            String q = qr.replaceAll(" and ", "");
            String[] queryConditions = q.split(" ");
            
            String c = queryConditions[0].replaceAll("-", "");
          
            if (infoMap.containsKey(c)) {
                List<Integer> scores = infoMap.get(c);
                int start = 0;
                int end = scores.size() - 1;
                int mid = 0;
                while (start <= end) {
                    mid = (end + start) / 2;
                    
                    if (scores.get(mid) >= Integer.valueOf(queryConditions[1])) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }   
                }
                answer[idx] = scores.size() - start;
                
            }
            else {
                answer[idx] = 0;
            }
            idx += 1;
        }
        
        return answer;
    }
}
