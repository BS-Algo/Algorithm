cnt = 1
temp = True
stack = []
over = []

N = int(input())
for i in range(N):
    num = int(input())
    while cnt <= num:
        stack.append(cnt)
        over.append('+')
        cnt += 1

    if stack[-1] == num:
        stack.pop()
        over.append('-')
    else:
        temp = False
        break

if not temp:
    print("NO")
else:
    for i in over:
        print(i)