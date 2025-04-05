import sys
input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
stack = []
for _ in range(n):
    com1 = input().split()
    com2 = 0
    if len(com1) > 1:
        com1, com2 = int(com1[0]), int(com1[1])
    else:
        com1 = int(com1[0])
    
    if com1 == 1:
        stack.append(com2)
    elif com1 == 2:
        if stack:
            print(f'{stack.pop()}\n')
        else:
            print('-1\n')
    elif com1 == 3:
        print(f'{len(stack)}\n')
    elif com1 == 4:
        if stack:
            print('0\n')
        else:
            print('1\n')
    else:
        if stack:
            print(f'{stack[-1]}\n')
        else:
            print('-1\n')