# BaekJoon 05/10 2023
# 2636 치즈
# 14:08 ~ 14:44

N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

dir = [(1,0), (0, 1), (-1, 0), (0, -1)]
result = [-1]

while result[-1] != 0:
    visited = [[False] * M for _ in range(N)]
    cnt = 0
    flag = False
    for i in range(N):
        for j in range(M):
            if board[i][j] == 0 and not visited[i][j]:
                stack = [(i, j)]

                while stack:
                    x, y = stack.pop()

                    for d in dir:
                        dx, dy = x+d[0], y+d[1]

                        if 0 <= dx < N and 0 <= dy < M:
                            if board[dx][dy] == 1:
                                board[dx][dy] = 0
                                visited[dx][dy] = True
                                cnt += 1
                            if board[dx][dy] == 0 and not visited[dx][dy]:
                                stack.append((dx, dy))
                                visited[dx][dy] = True
            flag = True
        if flag:
            break
    result.append(cnt)

print(len(result)-2)
print(result[-2])
                    