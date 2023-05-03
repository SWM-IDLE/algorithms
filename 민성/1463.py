# BaekJoon 05/03 2023
# 1463 1로 만들기
# 13:35 ~ 13:51

N = int(input())

dp = [1e9] * (N+1) if N >= 3 else [1e9] * 4
dp[1] = 0
dp[2] = 1
dp[3] = 1

for i in range(4, N+1):
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i//3]+1)
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i//2]+1)
    dp[i] = min(dp[i], dp[i-1]+1)

print(dp[N])
