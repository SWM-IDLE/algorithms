# BaekJoon 05/02 2023
# 1449 수리공 항승
# 12:15 ~ 12:28

N, L = map(int, input().split())
pos = list(map(int, input().split()))

pos.sort()

attach_range = [pos[0]-0.5, pos[0]-0.5+L]
answer = 1

for p in pos[1:]:
    if attach_range[0] <= p-0.5 and p+0.5 <= attach_range[1]:
        pass
    else:
        attach_range[0] = p-0.5
        attach_range[1] = p-0.5+L
        answer += 1

print(answer)