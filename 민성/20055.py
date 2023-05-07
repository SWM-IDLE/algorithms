# BaekJoon 05/07 2023
# 20055 컨베이어 벨트 위의 로봇
# 11:30 ~ 12:03

from collections import deque

N, K = map(int, input().split())

belt = deque(list(map(int, input().split())))
robots = deque([False] * (2*N))

stage = 0

while True:
    stage += 1

    belt.rotate(1)
    robots.rotate(1)

    if robots[N-1]:
        robots[N-1] = False

    for i in range(N-1, 0, -1):
        if robots[i] and not robots[i+1] and belt[i+1] >= 1:
            robots[i] = False
            robots[i+1] = True
            belt[i+1] -= 1
    
    if robots[N-1]:
        robots[N-1] = False
    
    if belt[0] >= 1 and not robots[0]:
        belt[0] -= 1
        robots[0] = True
    
    if belt.count(0) >= K:
        break

print(stage)
