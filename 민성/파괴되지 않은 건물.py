def solution(board, skill):
    answer = 0
    
    tmp_board = [[0] * (len(board[0]) + 1) for _ in range(len(board) + 1)]
    
    for s in skill:
        if s[0] == 1:
            tmp_board[s[1]][s[2]] -= s[5]
            tmp_board[s[1]][s[4]+1] += s[5]
            tmp_board[s[3]+1][s[2]] += s[5]
            tmp_board[s[3]+1][s[4]+1] -= s[5]
        else:
            tmp_board[s[1]][s[2]] += s[5]
            tmp_board[s[1]][s[4]+1] -= s[5]
            tmp_board[s[3]+1][s[2]] -= s[5]
            tmp_board[s[3]+1][s[4]+1] += s[5]

    for i in range(len(tmp_board[0])):
        for j in range(1, len(tmp_board)):
            tmp_board[j][i] += tmp_board[j-1][i]
            
    for i in range(len(tmp_board)):
        for j in range(1, len(tmp_board[0])):
            tmp_board[i][j] += tmp_board[i][j-1]
    
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] + tmp_board[i][j] >= 1:
                answer += 1
    
    return answer
