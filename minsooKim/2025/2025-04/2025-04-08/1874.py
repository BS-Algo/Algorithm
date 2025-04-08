cnt = 1
temp = True
stack = []
lst = []

N = int(input())
for i in range(N):
    num = int(input())

    while cnt <= num:
        stack.append(cnt)
        lst.append('+')
        cnt += 1

    if stack[-1] == num:
        stack.pop()
        lst.append('-')
    else:
        temp = False
        break

if temp ==False:
    print("NO")
else:
    for i in lst:
        print(i)