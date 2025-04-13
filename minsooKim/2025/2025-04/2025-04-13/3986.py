N = int(input())
lst = []
for _ in range(N):
    lst.append(input())
cnt = 0
for i in lst:
    stack = []
    for j in i:        
        if j not in stack:
            stack.append(j)
        elif j == stack[-1]:
            stack.pop()
        elif j != stack[-1]:
            stack.append(j)
    if len(stack) == 0:
        cnt += 1
print(cnt)