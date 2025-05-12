# 부분 문자열
def solution(str1, str2):
    if str1 in str2:
        return 1
    else:
        return 0

str1 = "abc"	
str2 = "aabcc"	

print(solution(str1, str2))

# 꼬리 문자열
def solution(str_list, ex):
    return ''.join(lang for lang in str_list if ex not in lang)

str_list = ["abc", "def", "ghi"]
ex = "ef"	

print(solution(str_list, ex))

# 정수 찾기
def solution(num_list, n):
    answer = 0
    for i in range(len(num_list)):
        if num_list[i] == n:
            answer = 1
    return answer

num_list = [1, 2, 3, 4, 5]	
n = 3

print(solution(num_list, n))