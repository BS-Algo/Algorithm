def solution(arr):
    i = 0
    stk = []

    while i < len(arr):
        if not stk:
            stk.append(arr[i])
            i += 1
        elif stk and stk[-1] < arr[i]:
            stk.append(arr[i])
            i += 1
        elif stk and stk[-1] >= arr[i]:
            stk.pop()
    return stk



arr = [1, 4, 2, 5, 3]
result = [1, 2, 3]

print(solution(arr))