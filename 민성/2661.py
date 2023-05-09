# BaekJoon 05/09 2023
# 2661 좋은수열
# 12:23 ~ 13:18

import sys
N = int(input())

answer = ""

def check(nums):
    for length in range(2, len(nums)+1, 2):
        for i in range(len(nums)-length+1):
            if nums[i:i+length//2] == nums[i+length//2:i+length]:
                return False
    return True

def f(nums):

    if len(nums) == N:
        print(nums)
        sys.exit()
    
    for num in ["1", "2", "3"]:
        tmp = nums+num
        if check(tmp):
            f(tmp)
        tmp = tmp[:-1]

print(f(""))

"""
// 1차 시도
N = int(input())

loop = "1213"

cnt = N // 4

tmp = ""
for _ in range(cnt+1):
    tmp += loop

print(int(tmp[:N]))

// 2차 시도
N = int(input())

answer = ""

def check(nums):
    for length in range(2, len(nums)+1, 2):
        for i in range(len(nums)-length+1):
            if nums[i:i+length//2] == nums[i+length//2:i+length]:
                return False
    return True

while len(answer) != N:
    for num in ["1", "2", "3"]:
        if check(answer+num):
            answer += num
            break

print(int(answer))
"""