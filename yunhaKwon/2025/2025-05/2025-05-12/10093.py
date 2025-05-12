a, b = map(int, input().split())
mn = min(a, b)
mx = max(a, b)

ans = mx - mn - 1
if mn == mx or mn+1 == mx:
    ans = 0
print(ans)

for i in range(mn+1, mx):
    print(i, end = ' ')