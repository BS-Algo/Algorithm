n = int(input())
baloons = list(map(int, input().split()))
positions = [ i for i in range(1, n+1)]

result = []
idx = 0
while True:
    result.append(positions[idx])
    next_baloon = baloons[idx]
    
    baloons.pop(idx)
    positions.pop(idx)
    
    if not positions:
        break
    
    if next_baloon > 0:
        idx = (idx + next_baloon - 1) % len(positions)
    else:
        idx = (idx + next_baloon) % len(positions)

print(*result)