H, W = map(int, input().split())
blocks = list(map(int, input().split()))

drop_cnt = 0

for i in range(1, W-1):
    left = max(blocks[:i])
    right = max(blocks[i+1:])

    standard = min(left, right)

    if blocks[i] < standard:
        drop_cnt += standard - blocks[i]

print(drop_cnt)