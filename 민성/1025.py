# BaekJoon 05/12 2023
# 1025 제곱수 찾기
# 11:20 ~ 12:17

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
max_p = max(N, M)

# 시작지점, 방향, 일정한 간격(X축, Y축), 사이즈

def is_square(n):
    return int(int(n) ** 0.5) ** 2 == int(n)

lst = [list(input()) for _ in range(N)]

dir = [(0, 1), (1, 0), (0, -1), (-1, 0), (-1, -1), (-1, 1), (1, -1), (1, 1)]

result = -1
for i in range(N):
    for j in range(M):

        for d in dir:
            for x_size in range(1, max_p+1):
                for y_size in range(1, max_p+1):
                    cnt = 1
                    tmp = str(lst[i][j])
                    if int(tmp) == 1 or int(tmp) == 1 or int(tmp) == 4 or int(tmp) == 9:
                        if result <= int(tmp):
                            result = int(tmp)
                    
                    flag = False
                    if flag:
                        break
                    while True:
                        dx, dy = i+(d[0]*x_size)*cnt, j+(d[1]*y_size)*cnt
                        
                        if not (0 <= dx < N and 0 <= dy < M):
                            flag = True
                            break

                        tmp += lst[dx][dy]
                        print(tmp)
                        if is_square(tmp) and result <= int(tmp):
                            result = int(tmp)
                        cnt += 1

print(result)