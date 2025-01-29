N, L, W, H = map(int, input().split())
start, end = 0, min(L, W, H)

for _ in range(10000):
    mid = (start + end) / 2
    cnt = (L // mid) * (W // mid) * (H // mid)
    if cnt >= N:
        start = mid
    else:
        end = mid

print(start)