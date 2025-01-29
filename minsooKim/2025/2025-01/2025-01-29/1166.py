N, L, W, H = map(int, input().split())
arr = [L, W, H]
start = 0
end = min(arr)

for _ in range(10000):
    mid = (start + end) / 2
    cnt = (L // mid) * (W // mid) * (H // mid)

    if cnt >= N:
        start = mid
    else:
        end = mid

print(start)