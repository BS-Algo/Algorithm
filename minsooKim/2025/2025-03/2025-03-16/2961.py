from itertools import combinations

N = int(input())
arr = []
for _ in range(N):
    s, b = map(int, input().split())
    arr.append((s, b))

answer = []

for i in range(1, N+1):
    a = 10000000001
    for combo in combinations(arr, i):
        sour = 1
        bitter = 0

        for j in combo:
            sour *= j[0]
            bitter += j[1]
        
        chaii = sour - bitter

        if chaii < 0:
            chaii = -chaii
        if chaii < a:
            a = chaii
    answer.append(a)
print(min(answer))