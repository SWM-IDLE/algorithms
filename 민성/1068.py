# BaekJoon 05/13 2023
# 1068 트리
# 12:45 ~ 13:15

from collections import defaultdict

N = int(input())
lst = list(map(int, input().split()))

erase_node = int(input())

tree = defaultdict(list)

for i in range(N):
    tree[lst[i]].append(i)
    
child_count_lst = []
for i in range(N):
    child_count_lst.append(len(tree[i]))

stack = [erase_node]
erase_node_set = set()

while stack:
    node = stack.pop()
    erase_node_set.add(node)
    child_count_lst[lst[node]] -= 1
    stack.extend(tree[node])

answer = 0
for i in range(N):
    if child_count_lst[i] == 0 and i not in erase_node_set:
        answer += 1

print(answer)