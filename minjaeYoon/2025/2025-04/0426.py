# 특정한 문자를 대문자로 바꾸기
def solution(my_string, alp):
    my_string = list(my_string)
    for i in range(len(my_string)):
        if my_string[i] == alp:
            my_string[i] = my_string[i].upper()
    return ''.join(my_string)

my_string = "programmers"
alp = "p"

print(solution(my_string, alp))

# 특정 문자열로 끝나는 가장 긴 부분 문자열 찾기
def solution(myString, pat):
    candidates = []
    start_idx = 0
    while True:
        idx = myString.find(pat, start_idx)
        if idx == -1:
            break
        candidates.append(myString[0:idx+len(pat)])
        start_idx = idx +1
    
    if candidates:
        return max(candidates, key=len)
    
    return ""

myString = "AbCdEFG"
pat = "dE"	

print(solution(myString, pat))

# rfind, rindex, find, index

# 조건에 맞게 수열 변환하기 2
def solution(arr):
    arr = arr.copy()
    candidates = []
    
    candidates.append(arr.copy())
    
    for j in range(100):
        for i in range(len(arr)):
            if arr[i] >= 50 and arr[i] % 2 == 0:
                arr[i] //= 2
            elif arr[i] < 50 and arr[i] % 2 == 1:
                arr[i] = arr[i] * 2 + 1
        
        candidates.append(arr.copy())

        if candidates[j] == candidates[j+1]:
            return j

    return ""

arr = [1, 2, 3, 100, 99, 98]

print(solution(arr))

# 메모리 주소 및 배열 변경에 대해 주의하기

# 문자열이 몇 번 등장하는지 세기
def solution(myString, pat):
    answer = 0
    start_idx = 0
    while True:
        idx = myString.find(pat, start_idx)
        if idx == -1:
            break
        start_idx = idx + 1
        answer += 1
    return answer

myString = "banana"	
pat = "ana"

print(solution(myString, pat))

# enumerate, startswith 사용해보기

# ad 제거하기
def solution(strArr):
    answer = []
    for i in range(len(strArr)):
        if "ad" not in strArr[i]:
            answer.append(strArr[i])
    return answer

strArr = ["and","notad","abcd"]

print(solution(strArr))

# 공백으로 구분하기 1
def solution(my_string):
    my_string = list(map(str, my_string.split()))
    return my_string

my_string = "i love you"

print(solution(my_string))