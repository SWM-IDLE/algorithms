# BaekJoon 05/13 2023
# 1092 배

import sys
input = sys.stdin.readline

N = int(input())
crains = list(map(int, input().split()))
M = int(input())
boxes = list(map(int, input().split()))

if max(boxes) > max(crains):
    print(-1)
else:
    answer = 0
    crains.sort(reverse=True)
    boxes.sort(reverse=True)

    while boxes:
        for c in crains:
            if boxes and c < boxes[-1]:
                continue
            for b in boxes:
                if c >= b:
                    boxes.remove(b)
                    break
        answer +=1

    print(answer)

    '''
    removed = [False] * M
    remove_cnt = 0

    while remove_cnt != M:
        for crain in crains:
            if remove_cnt != M:
                continue
            
            for i in range(len(boxes)):
                if crain >= boxes[i] and not removed[i]:
                    remove_cnt += 1
                    removed[i] = True
                    break
                
        answer += 1
    
    print(answer)
    '''