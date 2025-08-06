# 저주의 숫자 3
def solution(n):
    answer = 0
    cnt = 0
    
    while cnt < n:
        answer += 1
        if answer % 3 != 0 and '3' not in str(answer):
            cnt += 1
    return answer

print(solution(15))