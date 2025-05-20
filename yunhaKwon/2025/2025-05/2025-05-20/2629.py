n = int(input())
weights = list(map(int, input().split()))
m = int(input())
targets = list(map(int, input().split()))

dp = [0]
for w in weights:
    tmp = []
    for i in dp:
        tmp.append(i+w)
        tmp.append(abs(i-w))
    dp = list(set((dp + tmp)))

for t in targets:
    if t in dp:
        print('Y', end=' ')
    else:
        print('N', end=' ')