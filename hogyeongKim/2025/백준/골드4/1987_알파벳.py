import sys
input = sys.stdin.readline
dt = ((1, 0), (0, 1), (-1, 0), (0, -1))

r, c = map(int, input().split())
alphabets = [input().rstrip() for _ in range(r)]

checker = set()
result = 0
def back_dfs(x, y, cnt):
    global checker, result, r, c
    result = max(result, cnt)
    
    for dx, dy in dt:
        nx, ny = x + dx, y + dy
        if 0 <= nx < r and 0 <= ny < c:
            next_alphabet = alphabets[nx][ny]
            if next_alphabet not in checker:
                checker.add(next_alphabet)
                back_dfs(nx, ny, cnt+1)
                checker.remove(next_alphabet)

checker.add(alphabets[0][0])
back_dfs(0, 0, 1)
print(result)