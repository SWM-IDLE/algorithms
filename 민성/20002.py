# BaekJoon 05/05 2023
# 20002 사과 나무
# 12:22 ~ 

import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

p_board = [[0] * (N+1) for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, N+1):
        p_board[i][j] = p_board[i-1][j] + p_board[i][j-1] - p_board[i-1][j-1] + board[i-1][j-1]


answer = p_board[1][1]
for size in range(N):
    for i in range(1, N+1-size):
        for j in range(1, N+1-size):
            tmp = p_board[i+size][j+size] - p_board[i-1][j+size] - p_board[i+size][j-1] + p_board[i-1][j-1]
            if answer < tmp:
                answer = tmp

print(answer)

''' 시간 초과..!
N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

answer = -1000
for i in range(N):
    for j in range(N):
        answer = max(answer, board[i][j])
        if j != 0:
            board[i][j] += board[i][j-1]


# 시작점과 사이즈만 알면 됨
for size in range(2, N):
    for i in range(N-size):
        for j in range(N-size):
            tmp = 0
            for s in range(size):
                tmp += (board[i+s][j+size] - board[i+s][j])
            answer = max(answer, tmp)
        
print(answer)
'''