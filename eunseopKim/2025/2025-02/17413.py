
S = input()
stack = []
# print(S)
flag = 0

for i in S:
    if i == '<':
        flag = 1
        for _ in range(len(stack)):
            print(stack.pop(), end='')

    stack.append(i)
    if i == '>':
        flag = 0
        for _ in range(len(stack)):
            print(stack.pop(0), end='')

    if i == ' ' and flag == 0:
        for j in range(len(stack)):
            if j == 0:
                stack.pop()
                continue
            print(stack.pop(), end='')
        print(' ', end='')
if stack:
    for _ in range(len(stack)):
        print(stack.pop(), end='')