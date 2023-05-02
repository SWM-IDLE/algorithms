# BaekJoon 05/02 2023
# 15655 N과 M(6)
# 12:30 ~ 12:45

N, M = map(int, input().split())
lst = sorted(list(map(int, input().split())))

arr = []
def f(index):

    if len(arr) == M:
        print(" ".join(map(str, arr)))
        return
    
    for i in range(index, N):
        if lst[i] not in arr:
            arr.append(lst[i])
            f(i+1)
            arr.pop()

f(0)