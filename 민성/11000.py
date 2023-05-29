# BaekJoon 05/29 2023
# 11000 강의실 배정
# 16:44 ~

import heapq
import sys
input = sys.stdin.readline

N = int(input())
lessons = [list(map(int, input().split())) for _ in range(N)]

lessons.sort(key=lambda x : x[0])

rooms = []
heapq.heappush(rooms, lessons[0][1])

for lesson in lessons[1:]:
    if lesson[0] < rooms[0]:
        heapq.heappush(rooms, lesson[1])
    else:
        heapq.heappop(rooms)
        heapq.heappush(rooms, lesson[1])

print(len(rooms))