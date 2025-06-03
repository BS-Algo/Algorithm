# 특이한 정렬
def solution(numlist, n):
    answer = sorted(numlist, key=lambda x: (abs(x-n), -x))
    return answer

numlist = [1, 2, 3, 4, 5, 6]	
n = 4

print(solution(numlist, n))