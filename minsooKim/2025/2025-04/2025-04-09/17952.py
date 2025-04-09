N = int(input())
stack = []
score = 0
for _ in range(N):
    lst = list(map(int, input().split()))
    if lst[0] == 1:
        A, T = lst[1], lst[2]        
        if T - 1 == 0:
            score += A
        else:
            stack.append([A, T-1])
    else:
        if stack:
            stack[-1][1] -= 1
            if stack[-1][1] == 0:
                score += stack[-1][0]
                stack.pop()
print(score)