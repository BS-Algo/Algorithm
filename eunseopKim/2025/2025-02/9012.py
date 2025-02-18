T = int(input())
for _ in range(T):
    stack = []
    a = input()
    for i in a:
        if i == '(':
            stack.append(i)
        else:
            if len(stack) == 0:
                print('NO')
                break
            else:
                stack.pop()

    else:
        if len(stack) == 0:
            print('YES')
        else:
            print('NO')