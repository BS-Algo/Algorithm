# 배열의 길이를 2의 거듭제곱으로 만들기
def solution(arr):
    answer = []
    limit = len(arr)
    
    for i in range(11):
        if 2**i == limit:
            return arr
        elif 2**i > limit:
            plus = 2**i - limit
            arr += [0]*plus
            return arr
        
    return answer

arr = [58, 172, 746, 89]

print(solution(arr))