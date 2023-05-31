# BaekJoon 05/31 2023
# 18513 샘터

from collections import deque

MIN_RANGE = -100000000
MAX_RANGE = 100000000

N, K = map(int, input().split())
spring = list(map(int, input().split()))

visited = set(spring)

queue = deque([[s, 0] for s in spring])

answer = 0
while queue and K > 0:
    point, weight = queue.popleft()

    if MIN_RANGE <= (point-1) <= MAX_RANGE and (point-1) not in visited:
        answer += (weight+1)
        K -= 1
        visited.add(point-1)
        queue.append([point-1, weight+1])

    if K == 0:
        break

    if MIN_RANGE <= (point+1) <= MAX_RANGE and (point+1) not in visited:
        answer += (weight+1)
        K -= 1
        visited.add(point+1)
        queue.append([point+1, weight+1])

print(answer)