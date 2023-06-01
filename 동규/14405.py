import sys

input = sys.stdin.readline

S = str(input().strip("\n"))
speak = ["pi", "ka", "chu"]

for word in speak: S = S.replace(word, " ")

if len(S.strip()) == 0: print("YES")
else: print("NO")
