# BaekJoon 05/05 2023
# 3273 두 수의 합
# 12:15 ~ 12:22

n = int(input())
nums = sorted(list(map(int, input().split())))
x = int(input())

i, j = 0, len(nums)-1
answer = 0

while i < j:
    if nums[i] + nums[j] == x:
        answer += 1

    if nums[i] + nums[j] > x:
        j -= 1
    else:
        i += 1
    
print(answer)