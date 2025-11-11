# 예산
# https://school.programmers.co.kr/learn/courses/30/lessons/12982
def solution(d, budget):
    d.sort()
    answer = 0
    total = 0
    
    for cost in d:
        total += cost
        if total <= budget:
            answer += 1
        else:
            break
    
    return answer

# 시간 초과
from itertools import combinations

def solution(d, budget):
    answer = 0
    
    # 가능한 모든 부서
    for count in range(len(d), 0, -1):
        # 조합 확인
        for combo in combinations(d, count):
            if sum(combo) <= budget:
                return count
    
    return answer

print(solution([1,3,2,5,4], 9))
print(solution([2,2,3,3], 10))