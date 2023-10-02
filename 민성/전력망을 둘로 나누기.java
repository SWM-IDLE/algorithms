from collections import defaultdict

def solution(n, wires):
    answer = 100
    
    tree = defaultdict(list)
    
    for wire in wires:
        tree[wire[0]].append(wire[1])
        tree[wire[1]].append(wire[0])
    
    for wire in wires:
        visited = [[False] * (n+1) for _ in range(n+1)]
        visited[wire[0]][wire[1]] = True
        visited[wire[1]][wire[0]] = True
        
        start = 0
        for i in range(1, n+1):
            for j in tree[i]:
                if not visited[i][j] or not visited[j][i]:
                    start = i
                    break
            if start != 0:
                break
                
        cnt = 1
        stack = [1]
        while stack:
            current_wire = stack.pop()
            
            for next_wire in tree[current_wire]:
                if (not visited[current_wire][next_wire]) and (not visited[next_wire][current_wire]):
                    stack.append(next_wire)
                    cnt += 1
                    visited[current_wire][next_wire] = True
                    visited[next_wire][current_wire] = True
        
        if abs(n-(2*cnt)) <= answer:
            answer = abs(n-(2*cnt))
        
    return answer
