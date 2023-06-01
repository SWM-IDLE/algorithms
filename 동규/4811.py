import sys

input = sys.stdin.readline

while True:
    dp = [[0 for _ in range(31)] for _ in range(31)]

    # 반 개의 경우의 수 모두 1로
    for i in range(1, 31):
        dp[0][i] = 1
    
    # 이전 경우의 수 + 다음 경우의 수 조합
    for i in range(1, 31):
        for j in range(i, 31):
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

    n = int(input())

    if n == 0:
        break
    else:
        print(dp[n][n])
