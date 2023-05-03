# BaekJoon 05/03 2023
# 19598 최소 회의실 개수
# 13:58 ~ 실패
# 풀이 참고

from collections import defaultdict

N = int(input())

dic = defaultdict(list)
for _ in range(N):
    s, e = map(int, input().split())
    dic[s].append(1)
    dic[e].append(-1)

tmp = 0
answer = 0
for key, value in sorted(dic.items()):
    tmp += sum(value)
    answer = max(tmp, answer)

print(answer)