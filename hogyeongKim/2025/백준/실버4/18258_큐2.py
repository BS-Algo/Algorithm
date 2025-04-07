from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
result = deque([])
for _ in range(n):
    cmd = list(input().split())
    num = 0
    if cmd[0] == 'push':
        num = int(cmd[1])
    cmd = cmd[0]

    if cmd == 'push':
        result.append(num)
    elif cmd == 'pop':
        if result:
            print(result.popleft())
        else:
            print(-1)
    elif cmd == 'size':
        print(len(result))
    elif cmd == 'empty':
        if result:
            print(0)
        else:
            print(1)
    elif cmd == 'front':
        if result:
            print(result[0])
        else:
            print(-1)
    else:
        if result:
            print(result[-1])
        else:
            print(-1)