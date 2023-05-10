# BaekJoon 05/10 2023
# 2512 예산
# 13:20 ~ 13:30

N = int(input())
nums = list(map(int, input().split()))
total = int(input())

start, end = 0, total
mid = 0

if sum(nums) <= total:
    print(max(nums))
else:
    while start <= end:
        mid = (start +end ) // 2

        tmp = 0
        for n in nums:
            if n <= mid:
                tmp += n
            else:
                tmp += mid
        
        if tmp <= total:
            start = mid + 1
        else:
            end = mid - 1

    print(end)