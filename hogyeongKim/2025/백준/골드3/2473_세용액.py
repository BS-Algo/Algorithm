n = int(input())

solutions = list(map(int, input().split()))
solutions.sort()
mn_solution = float('inf')

cur_left, cur_right, cur_mid = 0, 0, 0

for mid in range(1, n-1):
    left, right = 0, n-1
    new_solution = 0
    while left < right:
        if left == mid or right == mid:
            if new_solution > 0:
                right -= 1
            elif new_solution < 0:
                left += 1
            continue
        new_solution = solutions[left] + solutions[right] + solutions[mid]
        if new_solution == 0:
            cur_left, cur_right, cur_mid = left, right, mid
            break
        else:
            if mn_solution > abs(new_solution):
                mn_solution = abs(new_solution)
                cur_left, cur_right, cur_mid = left, right, mid
                
            if new_solution > 0:
                right -= 1
            elif new_solution < 0:
                left += 1
                
result = [solutions[cur_left], solutions[cur_mid], solutions[cur_right]]
result.sort()
print(*result)