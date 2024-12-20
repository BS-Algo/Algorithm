N, K = map(int, input().split())
coins = []
for _ in range(N):
    coins.append(int(input()))
coins.sort(reverse=True)
cnt = 0
for coin in coins:
    cnt += K // coin
    K %= coin
print(cnt)

