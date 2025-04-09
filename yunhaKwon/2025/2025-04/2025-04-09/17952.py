import sys
input = sys.stdin.readline

homework = []
res = 0

min = int(input())
for _ in range(min):
    h = list(map(int, input().split()))
    if h[0] == 1:
        homework.append((h[1], h[2]))

    if homework:
        score, time = homework.pop()
        time -= 1

        if time == 0:
            res += score
        else:
            homework.append((score, time))

print(res)