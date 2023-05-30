# BaekJoon 05/30 2023
# 12896 스크루지 민호

# 트리 지름 구하기
from collections import defaultdict, deque
import math

N = int(input())

graph = defaultdict(list)
for _ in range(N-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def get_farthest_node_and_distance_from_bfs(start):
    visited = [False] * (N+1)
    queue = deque([[start, 0]])

    farthest_node = -1
    farthest_distance = -1
    while queue:
        node, distance = queue.popleft()

        if distance >= farthest_distance:
            farthest_distance = distance
            farthest_node = node

        for n in graph[node]:
            if not visited[n]:
                queue.append([n, distance+1])
                visited[n] = True
    
    return [farthest_node, farthest_distance]


x, distance = get_farthest_node_and_distance_from_bfs(1)
y, answer = get_farthest_node_and_distance_from_bfs(x)

print(math.ceil(answer/2))