# BaekJoon 05/04 2023
# 15652 N과 M(4)
# 12:45 ~ 12:48

N, M = map(int, input().split())

arr = []

def f(index):

    if len(arr) == M:
        print(" ".join(map(str, arr)))
        return
    
    for i in range(index, N+1):
        arr.append(i)
        f(i)
        arr.pop()

f(1)
