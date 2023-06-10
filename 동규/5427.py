"""
[백준] 불
입력: 테스트 케이스 T, 빌딩 너비와 높이 w/h(1<=w,h<=1000)
출력: 빌딩 탈출하는데 가장 빠른 시간, 불가능할 경우 "IMPOSSIBLE"
"""
from collections import deque
import sys

input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def f_bfs():
    for _ in range(len(fq)):
        ex, ey = fq.popleft()
        for k in range(4):
            nx = ex + dx[k]
            ny = ey + dy[k]
            if 0 <= nx < w and 0 <= ny < h:
                if graph[nx][ny] != "#" and graph[nx][ny] != "*":
                    graph[nx][ny] = "*"
                    fq.append((nx, ny))


def m_bfs():
    mv = False
    for _ in range(len(mq)):
        ex, ey = mq.popleft()
        for k in range(4):
            nx = ex + dx[k]
            ny = ey + dy[k]
            if 0 <= nx < w and 0 <= ny < h:
                if (
                    visited[nx][ny] == 0
                    and graph[nx][ny] != "#"
                    and graph[nx][ny] != "*"
                ):
                    mv = True
                    visited[nx][ny] = visited[ex][ey] + 1
                    mq.append((nx, ny))
            else: return visited[ex][ey]

    if not mv:
        return "IMPOSSIBLE"

      
T = int(input())
for _ in range(T):
    h, w = map(int, input().split())
    graph = []
    visited = [[0] * h for _ in range(w)]

    mq = deque()
    fq = deque()

    for i in range(w):
        graph.append(list(input().strip()))
        for j in range(h):
            if graph[i][j] == "*":
                fq.append((i, j))
            if graph[i][j] == "@":
                mq.append((i, j))

    visited[mq[0][0]][mq[0][1]] = 1
    
    ans = 0
    while True:
        f_bfs()
        ans = m_bfs()
        if ans: break

    print(ans)
