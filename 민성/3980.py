# BaekJoon 05/30 2023
# 3980 선발 명단

C = int(input())

for _ in range(C):
    abilities = [list(map(int, input().split())) for _ in range(11)]

    arr = []
    answer_list = []
    
    def f():
        if len(arr) == 11:
            answer = 0
            for i in range(11):
                answer += abilities[i][arr[i]]
            answer_list.append(answer)
            return

        for i in range(11):
            if i in arr:
                continue
            else:
                if abilities[len(arr)][i] != 0:
                    arr.append(i)
                    f()
                    arr.pop()
    f()
    print(max(answer_list))