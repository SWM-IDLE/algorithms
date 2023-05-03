# BaekJoon 05/03 2023
# 15654 N과 M (5)
# 13:52 ~ 13:57

N, M = map(int, input().split())
lst = sorted(list(map(int, input().split())))

arr = []
def f():

    if len(arr) == M:
        print(" ".join(map(str, arr)))
        return

    for i in range(N):
        if lst[i] in arr:
            continue

        arr.append(lst[i])
        f()
        arr.pop()

f()