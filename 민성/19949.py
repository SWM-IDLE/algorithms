# BaekJoon 06/19 2023
# 19949 영재의 시험

answers = list(map(int, input().split()))

arr = []
answer = 0

def f(arr_size, cnt):
    global answer
    if arr_size == 10:
        if cnt >= 5:
            answer += 1
        return

    for i in range(1, 6):
        if arr_size >= 2 and arr[-2] == arr[-1] and arr[-1] == i:
            continue
        
        arr.append(i)
        if answers[len(arr)-1] == i:
            f(arr_size+1, cnt+1)
        else:
            f(arr_size+1, cnt)
            
        arr.pop()

f(0, 0)
print(answer)

'''
answers = list(map(int, input().split()))

arr = []
answer = 0

def f(arr_size):
    global answer
    if arr_size == 10:
        cnt = 0
        for i in range(10):
            if arr[i] == answers[i]:
                cnt += 1

            if cnt >= 5:
                answer += 1
                break
        return

    for i in range(1, 6):
        if arr_size >= 2 and arr[-2] == arr[-1] and arr[-1] == i:
            continue
        
        arr.append(i)
        f(arr_size+1)
        arr.pop()

f(0)
print(answer)
'''