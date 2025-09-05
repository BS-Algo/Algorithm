# 약수의 덧셈과 뺄셈
def solution(left, right):
    answer = 0
    for i in range(left, right+1):
        cnt = 0
        for j in range(1, i+1):
            if i % j == 0:
                cnt += 1
        if cnt % 2 == 0:
            answer += i
        elif cnt % 2 == 1:
            answer -= i
        
    return answer

print(solution(13, 17))

# 약수의 개수가 홀수인 케이스는 완전제곱수
# 에라토스테네스의 체 알고리즘 사용하기