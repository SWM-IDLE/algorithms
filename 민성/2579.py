# BaekJoon 05/09 2023
# 2579 계단 오르기
# 13:18 ~ 13:40

N = int(input())

stairs = [int(input()) for _ in range(N)]

dp = [[0] * (N+1) for _ in range(3)]

dp[1][1] = stairs[0]
dp[2][1] = 0
if N >= 2:
    dp[1][2] = dp[1][1] + stairs[1]
    dp[2][2] = stairs[1]

for i in range(3, N+1):
    dp[1][i] = dp[2][i-1] + stairs[i-1]
    dp[2][i] = max(dp[1][i-2], dp[2][i-2]) + stairs[i-1]

print(max(dp[1][N], dp[2][N]))