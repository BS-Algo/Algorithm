# 문자열 안에 문자열
def solution(str1, str2):
    if str2 in str1:
        return 1
    else:
        return 2

str1 = "ab6CDE443fgh22iJKlmn1o"	
str2 = "6CD"	

print(solution(str1, str2))

# 제곱 수 판별하기
def solution(n):
    n = n ** 0.5
    if n == int(n):
        return 1
    else:
        return 2

n = 144

print(solution(n))

# is_integer() 함수 존재함

# 문자열 정렬하기 2
def solution(my_string):    
    my_string = list(map(str, my_string.lower()))
    
    for i in range(len(my_string)):
        my_string[i] = ord(my_string[i])
    
    my_string.sort()
    
    for i in range(len(my_string)):
        my_string[i] = chr(my_string[i])
        
    return ''.join(my_string)

def solution(my_string):
    return ''.join(sorted(my_string.lower()))
# sorted에 문자열 넣으면 -> list -> 다시 문자열로 만들기


my_string = "Bcad"	

print(solution(my_string))