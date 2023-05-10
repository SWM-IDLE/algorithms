# BaekJoon 05/10 2023
# 2631 줄세우기
# 13:31 ~ 14:00

N = int(input())
lines = [int(input()) for _ in range(N)]

dp = [1] * N

for i in range(1, N):
    for j in range(0, i):
        if lines[j] < lines[i]:
            dp[i] = max(dp[i], dp[j]+1)

print(N - max(dp))