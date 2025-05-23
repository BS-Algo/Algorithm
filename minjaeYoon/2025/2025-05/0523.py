# 잘라서 배열로 저장하기
def solution(my_str, n):
    answer = []
    for i in range(0, len(my_str), n):
        answer.append(my_str[i:i+n])
    return answer

my_str = "abc1Addfggg4556b"	
n = 6

print(solution(my_str, n))

# 슬라이싱은 초과해도 에러가 나지 않음

# 가장 큰 수 찾기
def solution(array):
    max_num = max(array)
    max_index = array.index(max_num)
    
    return [max_num, max_index]

array = [1, 8, 3]	

print(solution(array))

# 다음에 올 숫자
def solution(common):
    answer = 0
    if common[1] - common[0] == common[2] - common[1]:
        answer = common[-1] + (common[1] - common[0])
    elif common[1] // common[0] == common[2] // common[1]:
        answer = common[-1] * (common[1] // common[0])
    return answer

common = [1, 2, 3, 4]	

print(solution(common))

common2 = [2, 4, 8]

print(solution(common2))

# 깔끔한 풀이
def solution(common):
    answer = 0
    a,b,c = common[:3]
    if (b-a) == (c-b):
        return common[-1]+(b-a)
    else:
        return common[-1] * (b//a)
    return answer