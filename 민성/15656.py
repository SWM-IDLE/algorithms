# BaekJoon 05/02 2023
# 15655 N과 M(7)
# 12:46 ~ 12:50

N, M = map(int, input().split())
lst = sorted(list(map(int, input().split())))

arr = []

def f():

    if len(arr) == M:
        print(" ".join(map(str, arr)))
        return
    
    for i in range(0, N):
        arr.append(lst[i])
        f()
        arr.pop()

f()