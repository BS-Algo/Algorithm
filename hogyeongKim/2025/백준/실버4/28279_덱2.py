from collections import deque
import sys

result = deque([])
input = sys.stdin.readline

for _ in range(int(input())):
    cmd = list(map(int, input().split()))
    num = 0
    if cmd[0] == 1 or cmd[0] == 2:
        num = cmd[1]
    cmd = cmd[0]
    
    if cmd == 1:
        result.appendleft(num)
    elif cmd == 2:
        result.append(num)
    elif cmd == 3:
        if result:
            print(result.popleft())
        else:
            print(-1)
    elif cmd == 4:
        if result:
            print(result.pop())
        else:
            print(-1)
    elif cmd == 5:
        print(len(result))
    elif cmd == 6:
        if result:
            print(0)
        else:
            print(1)
    elif cmd == 7:
        if result:
            print(result[0])
        else:
            print(-1)
    elif cmd == 8:
        if result:
            print(result[-1])
        else:
            print(-1)