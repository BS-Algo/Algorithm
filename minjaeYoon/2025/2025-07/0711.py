# 배열 자르기
def solution(numbers, num1, num2):
    return numbers[num1 : num2+1]

numbers = [1, 2, 3, 4, 5]	
num1 = 1
num2 = 3

print(solution(numbers, num1, num2))

# 배열 뒤집기
def solution(num_list):
    answer = []
    return num_list[::-1]

# 나이 출력
def solution(age):
    answer = 0
    return 2022-age+1

# 개미 군단
# dp 로 풀기 
def solution(hp):
    dp = [float('inf')] * (hp+1)
    dp[0] = 0
    attacks = [5, 3, 1]
    for i in range(1, hp+1):
        for attack in attacks:
            if i >= attack:
                dp[i] = min(dp[i], dp[i - attack] + 1)
                
    return dp[hp] if dp[hp] != float('inf') else -1

hp = 24

print(solution(hp))

