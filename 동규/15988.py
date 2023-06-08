"""
[백준] 1, 2, 3 더하기 3
입력: 테스트 케이스 T, 정수 n (n<=1000000)
출력: n을 1, 2, 3의 합으로 나타내는 방법의 수 % 1000000009
"""
import sys

input = sys.stdin.readline

dp = [0] * 1000001
dp[0] = 1
dp[1] = 2
dp[2] = 4
dp[3] = 7

for i in range(4, 1000001):
    # dp[i] = dp[i - 1] % 1000000009 + dp[i - 2] % 1000000009 + dp[i - 3] % 1000000009
    dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009

T = int(input())
for _ in range(T):
    n = int(input())
    print(dp[n - 1])
    # print(dp[n - 1] % 1000000009) 메모리 초과
