# BaekJoon 05/09 2023
# 2559 수열
# 13:40 ~ 

N, K = map(int, input().split())

nums = list(map(int, input().split()))

for i in range(1, N):
    nums[i] += nums[i-1]
nums.insert(0, 0)

print(nums)
answer = -1e9

if N == K:
    print(nums[-1])
else:
    for i in range(1, N-K+2):
        if answer <= (nums[i+K-1]-nums[i-1]):
            answer = (nums[i+K-1]-nums[i-1])

    print(answer)v