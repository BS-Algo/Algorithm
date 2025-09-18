# 두 개 뽑아서 더하기
# https://school.programmers.co.kr/learn/courses/30/lessons/68644
def solution(numbers):
    answer = []
    for i in range(len(numbers)):
        for j in range(i, len(numbers)):
            if i != j:
                answer.append(numbers[i] + numbers[j])

    answer = list(set(answer))
    
    return sorted(answer)

print(solution([2,1,3,4,1]))