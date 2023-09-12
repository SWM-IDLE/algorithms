from collections import deque, defaultdict

def solution(n, vertex):

    graph = defaultdict(list)
    for v in vertex:
        graph[v[0]].append(v[1])
        graph[v[1]].append(v[0])
    
    visited = [False] * (n+1)
    distance = defaultdict(int)
    visited[1] = True
    queue = deque([[1, 0]])
    
    while queue:
        node, cnt = queue.popleft()
        
        for next_node in graph[node]:
            if not visited[next_node]:
                queue.append([next_node, cnt+1])
                visited[next_node] = True
                distance[cnt+1] += 1
    
    
    return distance[max(distance.keys())]
