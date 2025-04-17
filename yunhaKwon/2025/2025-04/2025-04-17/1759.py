from itertools import combinations

l, c = map(int, input().split())
alpha = input().split()
combos = combinations(sorted(alpha), l)

ans = []

for combo in combos:
    c_cnt = 0 #자음 개수
    v_cnt = 0 #모음 개수

    for c in combo:
        if c in "aeiou":
            c_cnt += 1
        else:
            v_cnt += 1

    if c_cnt >= 1 and v_cnt >= 2:
        print(''.join(combo))