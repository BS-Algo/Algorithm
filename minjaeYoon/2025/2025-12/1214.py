# 과일 장수
# https://school.programmers.co.kr/learn/courses/30/lessons/135808
def solution(k, m, score):
    answer = 0
    score = sorted(score, reverse=True)
    
    for i in range(0, len(score), m):
        bene = score[i : i+m]
        if len(bene) != m:
            return answer
        fit = min(bene) * m
        answer += fit
        
    return answer

print(solution(4, 3, [4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]))
