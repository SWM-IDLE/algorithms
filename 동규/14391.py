def dfs(arr):
    global result
    total = 0

    # 가로, 세로의 모든 경우의 수 newArr 생성
    if len(arr) == N * M:
        newArr = []
        for i in range(N):
            newArr.append(arr[i * M : i * M + M])

        # 가로 합 계산하기
        horizNum = 0
        for i in range(N):
            for j in range(M):
                # 가로일 때
                if newArr[i][j] == 0:
                    horizNum = (horizNum * 10) + paper[i][j]
                # 세로일 때 앞에 나온 수를 total에 합산하고 초기화
                else:
                    total += horizNum
                    horizNum = 0
            total += horizNum
            horizNum = 0

        # 세로 합 계산하기
        vertiNum = 0
        for j in range(M):
            for i in range(N):
                # 세로일 때
                if newArr[i][j] == 1:
                    vertiNum = (vertiNum * 10) + paper[i][j]
                # 세로일 때 앞에 나온 수를 total에 합산하고 초기화
                else:
                    total += vertiNum
                    vertiNum = 0
            total += vertiNum
            vertiNum = 0

        # result와 total 중 더 큰 값 갱신
        result = max(result, total)
        return result

    else:
        dfs(arr + [0])
        dfs(arr + [1])

N, M = map(int, input().split())
paper = []
result = 0

for _ in range(N): paper.append(list(map(int, input())))

dfs([])

print(result)
