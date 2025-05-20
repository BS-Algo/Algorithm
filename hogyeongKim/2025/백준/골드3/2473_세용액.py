# 두 포인터 문제

# 용액의 수
n = int(input())

# 용액의 특성값
solutions = list(map(int, input().split()))

# 두 포인터를 적용하기 위해 정렬(2467 두 용액 문제에서는 정렬되어진 값이 주어짐)
solutions.sort()

# 가장 0에 가까운 값을 저장할 변수
mn_solution = float('inf')

# 0에 가까운 값의 인덱스가 저장될 변수들
cur_left, cur_right, cur_mid = 0, 0, 0

# 두 포인터 사이에 값을 하나 지정하고 진행.
for mid in range(1, n-1):
    # 매 mid마다 left, right를 초기화 하기 위해 while문 밖에 선언
    left, right = 0, n-1
    
    # left 혹은 right가 mid일 경우 조건문을 적용하기 위해 while문 밖에 선언
    new_solution = 0
    
    # left가 right를 넘지 않으면 반복
    while left < right:
        # mid의 값이 두 번 들어가면 안 되므로 left 혹은 right가 mid와 같으면 넘기기.
        # new_solution의 값을 통해 left 혹은 right의 값을 바꾸어 무한루프 방지.
        if left == mid or right == mid:
            if new_solution > 0:
                right -= 1
            elif new_solution < 0:
                left += 1
            continue
        
        # new_solution을 조건식에 활용하기 위해 별도로 값을 계산. left, right, mid 인덱스에 위치한 용액 특성값의 합.
        new_solution = solutions[left] + solutions[right] + solutions[mid]
        
        # 만약 new_solution의 값이 0이라면 최적해이므로 반복문 중지.
        if new_solution == 0:
            cur_left, cur_right, cur_mid = left, right, mid
            break
        else:
            # 그렇지 않을 경우 비교하여 최적해 갱신.
            if mn_solution > abs(new_solution):
                mn_solution = abs(new_solution)
                # 최적해가 바뀌었을 경우 해당 인덱스 값들을 별도로 저장.
                cur_left, cur_right, cur_mid = left, right, mid
            
            # 용액의 특성값이 정렬되어 있는 상태이므로, new_solution의 값을 토대로 left 혹은 right의 값 변동.
            if new_solution > 0:
                right -= 1
            elif new_solution < 0:
                left += 1
    # while문을 거쳐도 new_solution의 값이 0이면 최적해를 찾은 것이므로 for문 중단.
    if new_solution == 0:
        break

# 정렬된 값을 출력해야 하므로 정렬 수행.
result = [solutions[cur_left], solutions[cur_mid], solutions[cur_right]]
result.sort()
print(*result)