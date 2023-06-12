# BaekJoon 06/12
# 8980 택배
# 12:30 ~ 13:13

N, C = map(int, input().split())
M = int(input())

boxes = [list(map(int, input().split())) for _ in range(M)]
boxes.sort(key=lambda x: (x[1]))

villages = [0] * (N+1)

answer = 0
for b in boxes:
    fr, to, w = b
    tmp_w = min(w, C-max(villages[fr:to]))
    answer += tmp_w

    for i in range(fr, to):
        villages[i] += tmp_w
print(answer)

'''
from collections import deque, defaultdict

boxes.sort(key=lambda x: (x[1], x[0]))

print(boxes)
queue = deque(boxes)
carry_weight = defaultdict(int)

answer = 0
for i in range(1, N+1):
    C += carry_weight[i]

    while C > 0 and queue:
        fr, to, w = queue[0]
        
        if fr == i:
            tmp = min(w, C)
            carry_weight[to] += tmp
            answer += tmp
            C -= tmp
            queue.popleft()
        else:
            break

print(answer)

'''
