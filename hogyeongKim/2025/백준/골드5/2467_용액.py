import sys
n = int(input())

solutions = list(map(int, input().split()))
mn_solution = sys.maxsize
result = []
left, right = 0, n-1
cur_left, cur_right = 0, n-1
while left < right:
    new_solution = solutions[left] + solutions[right]
    if new_solution == 0:
        cur_left, cur_right = left, right
        break
    else:
        if mn_solution > abs(new_solution):
            mn_solution = abs(new_solution)
            cur_left, cur_right = left, right
        
        if new_solution > 0:
            right -= 1
        else:
            left += 1
print(solutions[cur_left], solutions[cur_right])