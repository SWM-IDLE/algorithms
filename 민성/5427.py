# BaekJoon 06/08 2023
# 5427 불

from collections import deque

T = int(input())
dir = [[0, 1], [1, 0], [-1, 0], [0, -1]]

for _ in range(T):
    w, h = map(int, input().split())

    board = [list(input()) for _ in range(h)]

    fires = []
    visited = [[False] * w for _ in range(h)]
    sanggeun = []
    for i in range(h):
        for j in range(w):
            if board[i][j] == "*":
                fires.append([i, j, 0])
                board[i][j] = 0
                visited[i][j] = True
            if board[i][j] == "@":
                sanggeun = [i, j, 1]
    
    queue = deque(fires)

    while queue:
        x, y, t = queue.popleft()
        
        for d in dir:
            dx, dy = x+d[0], y+d[1]

            if 0 <= dx < h and 0 <= dy < w and not visited[dx][dy]:
                if board[dx][dy] != "#":
                    queue.append([dx, dy, t+1])
                    board[dx][dy] = t+1
                    visited[dx][dy] = True

    visited = [[False] * w for _ in range(h)]

    queue = deque([sanggeun])
    flag = False
    while queue:
        x, y, t = queue.popleft()
        
        if x == 0 or x == (h-1) or y == 0 or y == (w-1):
            flag = True
            print(t)
            break

        for d in dir:
            dx, dy = x+d[0], y+d[1]

            if 0 <= dx < h and 0 <= dy < w and not visited[dx][dy] and board[dx][dy] != "#":
                if (type(board[dx][dy]) == int and board[dx][dy] > t) or board[dx][dy] == ".":
                    queue.append([dx, dy, t+1])
                    visited[dx][dy] = True
    
    if not flag:
        print("IMPOSSIBLE")