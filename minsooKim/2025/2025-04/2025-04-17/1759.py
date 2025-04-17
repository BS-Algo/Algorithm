from itertools import combinations

L, C = map(int, input().split())
word = list(map(str, input().split()))
combo = list(combinations(sorted(word), L))
mo = ['a', 'e', 'i', 'o', 'u']
for i in range(len(combo)):
    cnt = 0
    cnt_2 = 0
    for j in range(L):
        if combo[i][j] not in mo:
            cnt += 1
        elif combo[i][j] in mo:
            cnt_2 += 1
        if cnt >= 2 and cnt_2 >= 1:
            print(''.join(combo[i]))
            break
