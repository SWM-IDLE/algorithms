# BaekJoon 05/04 2023
# 3613 Java vs C++
# 12:10 ~ 12:34

import sys

variable = str(input())

upper_cnt = 0
underbar_cnt = 0

if variable[0] == "_" or variable[-1] == "_" or variable[0] == variable[0].upper() or "__" in variable:
    print("Error!")
    sys.exit(0)

for v in variable:
    if v != "_" and v == v.upper():
        upper_cnt += 1
    if v == "_":
        underbar_cnt += 1

if underbar_cnt > 0 and upper_cnt > 0:
    print("Error!")
    sys.exit(0)

new_variable = ""
if upper_cnt == 0 and underbar_cnt != 0:
    i = 0
    while i < len(variable):
        if variable[i] == "_":
            i += 1
            new_variable += variable[i].upper()
        else:
            new_variable += variable[i]
        i += 1
    print(new_variable)
elif upper_cnt != 0 and underbar_cnt == 0:
    for v in variable:
        if v == v.upper():
            new_variable += "_"
            new_variable += v.lower()
        else:
            new_variable += v
    print(new_variable)
elif underbar_cnt == 0 and upper_cnt == 0:
    print(variable)
