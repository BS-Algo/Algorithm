# 하샤드 수
def solution(x):
    answer = True
    lx = list(map(int, str(x)))
    sx = sum(lx)
    return True if x % sx == 0 else False

print(solution(18))

# 음양 더하기
def solution(absolutes, signs):
    answer = 0
    for i in range(len(absolutes)):
        if signs[i]:
            answer += absolutes[i]
        else:
            answer -= absolutes[i]
    return answer

print(solution([4,7,12], [True,False,True]))

# 없는 숫자 더하기
def solution(numbers):
    answer = 0
    for i in range(10):
        if i not in numbers:
            answer += i
    return answer

print(solution([1,2,3,4,6,7,8,0]))

# 나누어 떨어지는 숫자 배열
def solution(arr, divisor):
    answer = sorted([i for i in arr if i % divisor == 0])
    return answer if answer else [-1]

print(solution([5, 9, 7, 10], 5))

def solution(arr, divisor): return sorted([n for n in arr if n%divisor == 0]) or [-1]

