tmp_answer = 0
answer = 0

def solution(word):
    
    alpha = ['A', 'E', 'I', 'O', 'U']
    words = ""
    global tmp_answer
    
    def dfs(words):
        global tmp_answer, answer
        print(words, tmp_answer)
        
        if answer != 0:
            return
        
        if words == word:
            answer = tmp_answer
            return
            
        if len(words) >= 5:
            return
        
        for i in range(5):
            words += alpha[i]
            tmp_answer += 1
            dfs(words)
            words = words[:-1]
    
    dfs("")
    
    return answer
