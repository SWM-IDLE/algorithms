class Solution {
    
    private Integer timeToSeconds(String time) {
        
        String[] t = time.split(":");
        Integer h = Integer.valueOf(t[0]);
        Integer m = Integer.valueOf(t[1]);
        Integer s = Integer.valueOf(t[2]);
        
        return s + (60 * m) + (3600 * h);
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int len = logs.length;
        
        Integer playTime = timeToSeconds(play_time);
        Integer advTime = timeToSeconds(adv_time);
        
        
        int idx = 0;
        int[] timeLog = new int[360001];
        for (String log : logs) {
            String[] l = log.split("-");
            timeLog[timeToSeconds(l[0])]++;
            timeLog[timeToSeconds(l[1])]--;
        }
        
        for (int i = 1 ; i < timeLog.length ; i++) {
            timeLog[i] += timeLog[i-1];
        }
        
        long totalTime = 0;
        
        for (int i = 0 ; i <= advTime ; i++) {
            totalTime += timeLog[i];
        }
        
        long maxTime = totalTime;
      
        long startTime = 0;
        for (int i = advTime+1 ; i < playTime ; i++) {
            totalTime = totalTime + timeLog[i] - timeLog[i-advTime];
            if (maxTime < totalTime) {
                maxTime = totalTime;
                startTime = i-advTime+1;
            }
        }
        
        return toTime(startTime);

    }
    
    public String toTime(long time){
        
        long hour= time/3600;
        String sh=String.valueOf(hour);
        if(hour<10) sh="0"+sh;
        
        
        time-=hour*3600;
        
        long min= time/60;
        time-=min*60;
        String mh=String.valueOf(min);
        
        if(min<10) mh="0"+mh;
        
        String ch=String.valueOf(time);
        if(time<10) ch="0"+ch;
        
        return sh+":"+mh+":"+ch;
        
    }
}
