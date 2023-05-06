# BaekJoon 05/06 2023
# 4095 최대 정사각형
# 12:30 ~ 13:16

import sys
input = sys.stdin.readline

while True:
    N, M = map(int, input().split())

    if N == 0 and M == 0:
        sys.exit()
    
    board = [list(map(int, input().split())) for _ in range(N)]

    answer = 0
    for i in range(N):
        for j in range(M):
            if i == 0 or j == 0:
                if answer <= board[i][j]:
                    answer = board[i][j]

            elif board[i][j] == 1:
                board[i][j] = min(board[i-1][j], board[i][j-1], board[i-1][j-1]) + 1
                if answer <= board[i][j]:
                    answer = board[i][j]
                    
    print(answer)

'''
while True:
    N, M = map(int, input().split())

    if N == 0 and M == 0:
        sys.exit()
    
    board = [list(map(int, input().split())) for _ in range(N)]

    p_board = [[0] * (M+1) for _ in range(N+1)]

    for i in range(1, N+1):
        for j in range(1, M+1):
            p_board[i][j] = p_board[i-1][j] + p_board[i][j-1] - p_board[i-1][j-1] + board[i-1][j-1]

    answer = 0
    for size in range(min(N, M)):
        for i in range(1, N+1-size):
            for j in range(1, M+1-size):
                tmp = p_board[i+size][j+size] - p_board[i-1][j+size] - p_board[i+size][j-1] + p_board[i-1][j-1]
                
                if tmp == (size+1)**2 and answer < tmp:
                    answer = size+1
    
    print(answer)
'''