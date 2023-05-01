# BaekJoon 05/01 2023
# 15657 N과 M(8)
# 13:46 ~ 13:57

from itertools import combinations_with_replacement

N, M = map(int, input().split())
nums = list(map(int, input().split()))

answer = []
for combi in combinations_with_replacement(nums, M):
    answer.append(sorted(combi))

answer.sort()

for a in answer:
    print(" ".join(map(str, a)))
