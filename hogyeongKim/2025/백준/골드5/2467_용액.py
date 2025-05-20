# 두 포인터 문제

# 용액의 수
n = int(input())

# 용액의 특성값
solutions = list(map(int, input().split()))

# 가장 0에 가까운 값을 저장할 변수
mn_solution = float('inf')

# 0에 가까운 값의 인덱스가 저장될 변수들
cur_left, cur_right = 0, n-1

# 시작 인덱스 left, 끝 인덱스 right부터 원소 탐색을 위한 값
left, right = 0, n-1

# left가 right를 넘지 않으면 반복
while left < right:
    # new_solution을 조건식에 활용하기 위해 별도로 값을 계산. left, right 인덱스에 위치한 용액 특성값의 합.
    new_solution = solutions[left] + solutions[right]
    
    # 만약 new_solution의 값이 0이라면 최적해이므로 반복문 중지.
    if new_solution == 0:
        cur_left, cur_right = left, right
        break
    else:
        # 그렇지 않을 경우 비교하여 최적해 갱신.
        if mn_solution > abs(new_solution):
            # 최적해가 바뀌었을 경우 해당 인덱스 값들을 별도로 저장.
            mn_solution = abs(new_solution)
            cur_left, cur_right = left, right
        
        # 용액의 특성값이 정렬되어 있는 상태이므로, new_solution의 값을 토대로 left 혹은 right의 값 변동.
        if new_solution > 0:
            right -= 1
        else:
            left += 1

print(solutions[cur_left], solutions[cur_right])