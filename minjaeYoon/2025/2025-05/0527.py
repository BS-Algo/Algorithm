# 세균 증식
def solution(n, t):
    for _ in range(1, t+1):
        n *= 2
    return n

n = 2
t = 10

print(solution(n, t))

# 비트 활용
def solution(n, t):
    return n << t

# 자릿수 더하기
def solution(n):
    answer = 0
    n = [x for x in str(n)]
    for i in range(len(n)):
        answer += int(n[i])
    return answer

n = 1234

print(solution(n))

# sum 활용해서 리스트 컴프리헨션으로 바로 마무리 하기

# n의 배수 구하기
def solution(n, numlist):
    answer = []
    for i in range(len(numlist)):
        if numlist[i] % n == 0:
            answer.append(numlist[i])
    return answer

n = 3
numlist = [4, 5, 6, 7, 8, 9, 10, 11, 12]

print(solution(n, numlist))

# 리스트 컴프리헨션 연습
def solution(n, numlist):
    answer = [i for i in numlist if i%n==0]
    return answer

# filter 함수 사용
def solution(n, numlist):
    return list(filter(lambda v: v%n==0, numlist))

# 한 번만 등장한 문자
def solution(s):
    answer = ''
    s = list(s)
    cnt = sorted(set(s))
    lst = []
    for char in cnt:
        lst.append(s.count(char))
    
    for i in range(len(lst)):
        if lst[i] == 1:
            answer += cnt[i]
    return answer

s = "abcabcadc"	

print(solution(s))

# 리스트 컴프리헨션 사용
def solution(s):
    answer = "".join(sorted([ ch for ch in s if s.count(ch) == 1]))
    return answer

# 인덱스 바꾸기
def solution(my_string, num1, num2):
    answer = ''
    my_string = list(my_string)
    my_string[num1], my_string[num2] = my_string[num2], my_string[num1]
    return answer.join(my_string)

my_string = "hello"	
num1 = 1
num2 = 2

print(solution(my_string, num1, num2))

# 영어가 싫어요
def solution(numbers):
    answer = ""  # 문자열로 초기화
    num_char_lst = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    num_lst = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
    
    i = 0
    while i < len(numbers):  # while문으로 변경
        found = False
        for j in range(len(num_char_lst)):
            if numbers[i:].startswith(num_char_lst[j]):  # startswith로 수정, i부터 시작
                answer += num_lst[j]  # 문자열 연결
                i += len(num_char_lst[j])  # 영어 단어 길이만큼 이동
                found = True
                break
        
        if not found:  # 매칭되는 단어가 없으면 1칸 이동
            i += 1
            
    return int(answer)  # answer를 int로 변환

numbers = 'onetwothreefourfivesixseveneightnine'

print(solution(numbers))

# 대문자와 소문자
def solution(my_string):
    answer = ''
    my_string = [x.lower() if x.isupper() else x.upper() for x in my_string]
    return answer.join(my_string)

my_string = "abCdEfghIJ"

print(solution(my_string))

# swapcase라는 함수 활용
def solution(my_string):
    return my_string.swapcase()

# 문자열.swapcase() ?= 대<->소, 다른 문자들은 원본 유지하는 함수 

