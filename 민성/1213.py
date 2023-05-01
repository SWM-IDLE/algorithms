# BaekJoon 05/01 2023
# 1213 팰린드롬 만들기
# 13:30 ~ 13:46

from collections import defaultdict

input_string = str(input())

chr_dict = defaultdict(int)

for s in input_string:
    chr_dict[s] += 1

odd_num_count = 0

for chr_num in chr_dict.values():
    if chr_num & 1:
        odd_num_count += 1

if odd_num_count >= 2:
    print("I'm Sorry Hansoo")
else:
    odd_str = ""
    even_str = ""
    for chr, cnt in chr_dict.items():
        if cnt & 1:
            odd_str += chr
            even_str += (chr * (cnt//2))
        else:
            even_str += (chr * (cnt//2))

    answer = ""
    answer += "".join(sorted(even_str))
    answer += odd_str
    answer += "".join(sorted(even_str)[::-1])
    print(answer)
