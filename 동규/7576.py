"""
[백준] 7576번 - 토마토
입력 : 2 <= M, N <= 1000
조건 : 정수 1이 익은 토마토, 0이 익지 않은 토마토, -1이 토마토 없음
"""
import sys
from collections import deque

input = sys.stdin.readline

M, N = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(N)]

q = deque()
cnt = 0

dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]

for i in range(N):
    for j in range(M):
        if box[i][j] == 1:
            q.append((i, j))


def bfs():
    while q:
        ey, ex = q.popleft()
        for k in range(4):
            ny = ey + dy[k]
            nx = ex + dx[k]
            if 0 <= ny < N and 0 <= nx < M and box[ny][nx] == 0:
                box[ny][nx] = box[ey][ex] + 1
                q.append((ny, nx))


bfs()
# print(box)

for i in box:
    for j in i:
        # if i == 0:
        if j == 0:
            print(-1)
            exit()
    cnt = max(cnt, max(i))

print(cnt - 1)
