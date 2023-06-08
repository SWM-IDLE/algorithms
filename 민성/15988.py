# BaekJoon 06/08 2023
# 15988 1,2,3 더하기 3

T = int(input())

inputs = []
for _ in range(T):
    inputs.append(int(input()))

max_n = max(inputs)
dp = [0, 1, 2, 4, 7, 13]
if max_n > 5:
    dp.extend([0] * (max_n-5))

for i in range(6, max_n+1):
    dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009

for i in inputs:
    print(dp[i])