from collections import defaultdict
import heapq

def solution(n, paths, gates, summits):
    answer = []
    
    graph = defaultdict(list)
    
    for path in paths:
        graph[path[0]].append([path[1], path[2]])
        graph[path[1]].append([path[0], path[2]])
        
    summits = set (summits)
    
    intensity = [1e9] * (n+1)
    queue = []
    
    for gate in gates:
        heapq.heappush(queue, [0, gate])
        intensity[gate] = 0
    
    while queue:
        
        weight, node = heapq.heappop(queue)
        
        if node in summits or intensity[node] < weight:
            continue
            
        for next_node in graph[node]:
            w = max(weight, next_node[1])
            if intensity[next_node[0]] > w:
                intensity[next_node[0]] = w
                heapq.heappush(queue, [w, next_node[0]])
    
    answer = [0, 1e9]
    
    for summit in sorted(list(summits)):
        if intensity[summit] < answer[1]:
            answer[0] = summit
            answer[1] = intensity[summit]
    
    return answer
