def similar(target, word):
    dic1 = {}
    for t in target:
        if t in dic1:
            dic1[t] += 1
        else:
            dic1[t] = 1

    dic2 = {}
    for w in word:
        if w in dic2:
            dic2[w] += 1
        else:
            dic2[w] = 1

    print(dic1)
    print(dic2)

    if dic1 == dic2:
        return True

    diff_cnt = 0
    for d in dic1:
        if d in dic2:
            diff_cnt += abs(dic1[d] - dic2[d])
        else:
            diff_cnt += dic1[d]

    for d in dic2:
        if d not in dic1:
            diff_cnt += dic2[d]

    return diff_cnt == 1


n = int(input())
target = input()
words = [input() for _ in range(n-1)]

cnt = 0

for word in words:
    if similar(target, word):
        cnt += 1

print(cnt)