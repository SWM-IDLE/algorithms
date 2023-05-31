# BaekJoon 05/31 2023
# 14284 간선 이어가기 2

import sys, heapq
from collections import defaultdict
input = sys.stdin.readline

n, m = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(m)]
s, t = map(int, input().split())

graph = defaultdict(list)
for edge in edges:
    graph[edge[0]].append([edge[1], edge[2]])
    graph[edge[1]].append([edge[0], edge[2]])

def dijkstra(graph, start):
    distances = [1e9] * (n+1)
    queue = []
    distances[start] = 0
    heapq.heappush(queue, [0, start])

    while queue:
        cur_distance, cur_node = heapq.heappop(queue)
        
        if distances[cur_node] < cur_distance:
            continue

        for edge in graph[cur_node]:
            node, distance = edge[0], edge[1]
            if distances[node] > cur_distance + distance:
                distances[node] = cur_distance + distance
                heapq.heappush(queue, [distances[node], node])
    return distances

print(dijkstra(graph, s)[t])
