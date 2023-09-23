import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        int[] start = new int[2];
        List<int[]> obstacles = new ArrayList<>();
        
        for (int i = 0 ; i < park.length ; i++) {
            for (int j = 0 ; j < park[i].length() ; j++) {
                if (park[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                }
                if (park[i].charAt(j) == 'X') {
                    obstacles.add(new int[]{i, j});
                }
            }
        }
        
        Map<String, int[]> directions = new HashMap<>() {{
            put("N", new int[]{-1, 0});
            put("S", new int[]{1, 0});
            put("W", new int[]{0, -1});
            put("E", new int[]{0, 1});
        }};
        
        for (String route : routes) {
            String[] r = route.split(" ");
            String d = r[0];
            Integer w = Integer.valueOf(r[1]);
            
            int[] tmp = start.clone();
            int[] dir = directions.get(d);
            boolean flag = false;
            
            for (int i = 0 ; i < w ; i++) {
                tmp[0] = dir[0]+tmp[0];
                tmp[1] = dir[1]+tmp[1];
                if (tmp[0] >= 0 && tmp[0] < park.length && tmp[1] >= 0 && tmp[1] < park[0].length()) {
                    if (park[tmp[0]].charAt(tmp[1]) == 'X') {
                        flag = true;
                        break;
                    }
                } else {
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                start = tmp;
            }
        }
        
        return start;
    }
}
