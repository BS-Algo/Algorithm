from sys import stdin

N, M = map(int,stdin.readline().split())
coin = []
cnt = 0

for i in range(N):
    coin.append(int(stdin.readline()))

coin.sort(reverse=True)

for value in coin:
    cnt += (M // value)
    M %= value

    if M <= 0:
        break

print(cnt)