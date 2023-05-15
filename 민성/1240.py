# BaekJoon 05/15 2023
# 1240 노드사이의 거리
# 12:20 ~ 12:40

from collections import defaultdict, deque

N, M = map(int, input().split())

trees = defaultdict(list)
for _ in range(N-1):
    node_1, node_2, weight = map(int, input().split())
    trees[node_1].append((node_2, weight))
    trees[node_2].append((node_1, weight))

for _ in range(M):
    s, e = map(int, input().split())

    queue = deque([(s, 0)])
    visited = [False] * (N+1)

    while queue:
        node, cost = queue.popleft()
        visited[node] = True
        if node == e:
            print(cost)
            break
            
        for n, c in trees[node]:
            if not visited[n]:
                queue.append((n, cost+c))