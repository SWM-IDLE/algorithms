def solution(info, edges):
    answer = []
    
    visited = [False] * len(info)
    visited[0] = True
    
    def dfs(sheep_cnt, wolf_cnt):
        
        if sheep_cnt <= wolf_cnt:
            return
        else:
            answer.append(sheep_cnt)
        
        for scr, dest in edges:
            if visited[scr] and not visited[dest]:
                visited[dest] = True
                if info[dest] == 0:                
                    dfs(sheep_cnt+1, wolf_cnt)
                else:
                    dfs(sheep_cnt, wolf_cnt+1)
                visited[dest] = False
        
    dfs(1, 0)
    return max(answer)
