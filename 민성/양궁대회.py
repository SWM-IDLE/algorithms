answer_score = 0
from collections import defaultdict

def solution(n, info):
    answer_dict = defaultdict(list)
    global answer_score
    
    lions = []
    def dfs():
        global answer_score
        
        if sum(lions) > n or len(lions) > 11:
            return 
        
        if len(lions) == 11 and sum(lions) != n:
            return
        
        if len(lions) == 11 and sum(lions) == n:
            lion_score = 0
            apeach_score = 0
            
            for i in range(11):
                if info[i] == 0 and lions[i] == 0:
                    continue
                if info[i] >= lions[i]:
                    apeach_score += (10-i)
                else:
                    lion_score += (10-i)
                    
            if (lion_score - apeach_score) > 0 and (lion_score - apeach_score) >= answer_score:
                answer_score = (lion_score - apeach_score)
                answer_dict[answer_score].append(lions[:])
            return
        
        for i in range(0, 11):
            lions.append(i)
            dfs()
            lions.pop()

    dfs()
    if answer_score == 0:
        return [-1]
    
    for i in range(0, 11):
        answer_dict[answer_score].sort(key=lambda x:-x[i])
    return answer_dict[answer_score][0]
