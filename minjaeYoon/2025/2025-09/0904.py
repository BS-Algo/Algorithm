# 제일 작은 수 제거하기
def solution(arr):
    minv = min(arr)
    arr.remove(minv)
    return arr if len(arr) > 1 else [-1]

print(solution([4,3,2,1]))
print(solution([10]))

# 내적
def solution(a, b):
    answer = 0
    for i in range(len(a)):
        answer += a[i]*b[i]
    return answer

print(solution([1,2,3,4], [-3,-1,0,2]))

# 수박수박수박수박수박수?
def solution(n):
    answer = ''
    word = ['수', '박']
    for i in range(1, n+1):
        answer += word[i % 2 -1]
    return answer

print(solution(3))
print(solution(4))