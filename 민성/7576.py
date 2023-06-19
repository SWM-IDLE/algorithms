# BaekJoon 06/19 2023
# 7576 토마토

from collections import deque

M, N = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

dir = [[0, 1], [1, 0], [0, -1], [-1, 0]]

tomatoes = []

cnt = 0
visited = [[False] * M for _ in range(N)]

for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            tomatoes.append((i, j, 0))
            visited[i][j] = True
            cnt += 1
        if arr[i][j] == -1:
            visited[i][j] = True
            cnt += 1

queue = deque(tomatoes)
answer = 0

while queue:
    x, y, day = queue.popleft()
    for d in dir:
        dx, dy = x+d[0], y+d[1]

        if 0 <= dx < N and 0 <= dy < M and not visited[dx][dy]:
            if arr[dx][dy] == 0:
                queue.append((dx, dy, day+1))
                visited[dx][dy] = True
                cnt += 1
                answer = day+1

if cnt == (M*N):
    print(answer)
else:
    print(-1)
