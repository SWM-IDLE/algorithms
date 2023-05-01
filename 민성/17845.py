# BaekJoon 05/01 2023
# 17845 수강 과목
# 13:57 ~ X

N, K = map(int, input().split())
subjects = [[0, 0]]

for _ in range(K):
    subjects.append(list(map(int, input().split())))

subjects.sort(key=lambda x: x[1])
dp = [[0] * (N+1) for _ in range(K+1)]

for i in range(1, K+1):
    w = subjects[i][1]
    v = subjects[i][0]
    for j in range(1, N+1):
        if j < w:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-w]+v)

print(dp[K][N])
