"""
[백준] 8980번 - 택배
입력: 2<=N<=2000, 1<=C<=10000, 1<=M<=10000
"""
import sys

input = sys.stdin.readline

N, C = map(int, input().split())
M = int(input())

ship = []
for _ in range(M):
    ship.append(tuple(map(int, input().split())))

ship.sort(key=lambda x: x[1])
village = [0] * (N + 1)
result = 0

for f, t, s in ship:
    temp = s
    for i in range(f, t):
        if village[i] + temp >= C:
            temp = C - village[i]
    for i in range(f, t):
        village[i] += temp
    result += temp

print(result)
