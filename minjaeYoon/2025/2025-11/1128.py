# 푸드파이트 대회
# https://school.programmers.co.kr/learn/courses/30/lessons/134240
def solution(food):
    answer = ''
    lft = ''
    
    for i in range(1, len(food)):
        cnt = food[i] // 2
        lft += str(i) * cnt
    
    answer = lft + '0' + lft[::-1]
    return answer

print(solution([1, 3, 4, 6]))