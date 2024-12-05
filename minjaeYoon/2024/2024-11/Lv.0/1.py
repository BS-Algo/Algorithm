# 1. [PCCE] 기출문제 1번 문자 출력
message = "Let's go!"

print("3 \n2 \n1")
print(message)

# 2. 코딩 기초 트레이닝 문자열 출력하기
str = input()
print(str)

# 3. 코딩 기초 트레이닝 a와 b 출력하기
a, b = map(int, input().strip().split(' '))
print(f'a = {a}')
print(f'b = {b}')

# 4. 코딩 기초 트레이닝 문자열 반복해서 출력하기
str, n = input().strip().split(' ')
n = int(n)
print(n*str)

# 5. 코딩 기초 트레이닝 대소문자 바꿔 출력
str = input()

sentence = []
for i in str:
    if i.isupper():
        i = i.lower()
    else:
        i = i.upper()
    sentence.append(i)

print(''.join(sentence))

# 6. 코딩 기초 트레이닝 특수문자 출력 -> 구글링

# 'r' 사용하기 : \가 많이 사용되는 케이스는 r
print(r'!@#$%^&*(\'"<>?:;')

# \ ' " 앞에 붙이기
print('!@#$%^&*(\\\'"<>?:;')

# 7. 코딩 기초 트레이닝 덧셈식 출력
a, b = map(int, input().strip().split(' '))
c = a + b
print(f'{a} + {b} = {c}')

# 8. 코딩 기초 트레이닝 문자열 붙여서 출력하기
str1, str2 = input().strip().split(' ')

sentence = str1 + str2

print(''.join(sentence))

# 9. 코딩 기초 트레이닝 문자열 돌리기

# 내 풀이
str = input()

for i in str:
    print(i)

# 감탄한 풀이
print('\n'.join(input()))

# 10. 코딩 기초 트레이닝 홀짝
a = int(input())

if a%2 == 0:
    print(f'{a} is even')
else:
    print(f'{a} is odd')

# 11. 코딩 기초 트레이닝 문자열 겹쳐쓰기

# 내 풀이
def solution(my_string, overwrite_string, s):
    answer = ''
    sentence = my_string[:s], overwrite_string, my_string[s+len(overwrite_string):]
    return answer.join(sentence)

my_string, overwrite_string, s = input().strip().split(' ')
s = int(s)

print(solution(my_string, overwrite_string, s))

# -> 없어도 그만 + 제일 많이 본 답변도 같은 구조

# 12. 코딩 기초 트레이닝 문자열 섞기

# 내 풀이
def solution(str1, str2):
    answer = []
    for i in range(len(str1)):
        answer.append(str1[i])
        answer.append(str2[i])
    return (''.join(answer))

print(solution('aaaaa', 'bbbbb'))

# 타인 풀이
def solution(str1, str2):
    answer = ''.join([str1[i] + str2[i] for i in range(len(str1))])
    return answer

# 13. 코딩 기초 트레이닝 문자 리스트를 문자열로 표현하기
def solution(arr):
    answer = ''.join([arr[i] for i in range(len(arr))])
    return answer

# 14. 코딩 기초 트레이닝 문자열 곱하기
def solution(my_string, k):
    answer = ''.join([my_string for i in range(k)])
    return answer

# 15. 코딩 기초 트레이닝 더 크게 합치기

def solution(a, b):
    answer = 0
    answer1 = '' + str(a) + str(b)
    answer2 = '' + str(b) + str(a)
    if int(answer1) > int(answer2):
        answer += int(answer1)
    else:
        answer += int(answer2)
    return answer

def solution(a, b):
    return int(max(f"{a}{b}", f"{b}{a}"))

# 16. 코딩 기초 트레이닝 두 수 연산값 비교
def solution(a, b):
    answer = 0
    if int(f'{a}{b}') > int(f'{2*a*b}'):
        answer = int(f'{a}{b}')
    elif int(f'{a}{b}') == int(f'{2*a*b}'):
        answer = int(f'{a}{b}')
    else:
        answer = int(f'{2*a*b}')
    return answer

# max는 같을 때 항상 앞에 있는 값을 반환
def solution(a, b):
    return max(int(str(a) + str(b)), 2 * a * b)

# 17. 코딩 기초 트레이닝 n의 배수
def solution(num, n):
    answer = 0
    if num%n == 0:
        answer = 1
    return answer

def solution(num, n):
    return int(not(num % n))

# 18. 코딩 기초 트레이닝 공배수
def solution(number, n, m):
    return int(not(number%n) and not(number%m))

def solution(number, n, m):
    return int(bool(number % n == 0) & bool(number % m == 0))

# 19. 코딩 기초 트레이닝 홀짝에 따른 값 반환
def solution(n):
    answer = 0
    if n%2 == 1:
        for i in range(n//2+1):
            answer += (i*2)+1
    elif n%2 == 0:
        for i in range(1, n//2+1):
            answer += (i*2)**2
    return answer

# 확실히 한 줄로 for 문 리스트 만들기 다시 연습
def solution(n):
    if n%2:
        return sum(range(1,n+1,2))
    return sum([i*i for i in range(2,n+1,2)])

# 20. 코딩 기초 트레이닝 조건 문자열
def solution(ineq, eq, n, m):
    if eq == '!':
        return int(n > m if ineq == '>' else n < m)
    elif eq == '=':
        return int(n >= m if ineq == '>' else n <= m)
    
# 21. 코딩 기초 트레이닝 flag에 따른 다른 값 반환
def solution(a, b, flag):
    if bool(flag) == True:
        return int(f'{a+b}')
    elif bool(flag) == False:
        return int(f'{a-b}')

def solution(a, b, flag):
    if flag: return a+b
    return a-b

# 22. 코딩 기초 트레이닝 코드 처리하기

# 23. 코딩 기초 트레이닝 

# 24. 코딩 기초 트레이닝 주사위 게임 2
def solution(a, b, c):
    answer = 0
    if a == b and b == c:
        answer = (a+b+c)*(a**2+b**2+c**2)*(a**3+b**3+c**3)
    elif a == b or b == c or a == c :
        answer = (a+b+c)*(a**2+b**2+c**2)
    else:
        answer = (a+b+c)
    return answer

# 25. 코딩 기초 트레이닝 원소들의 곱과 합
def solution(num_list):
    num = len(num_list)
    bit, answer, comparison = 0, 1, 0
    for i in range(num):
        answer *= num_list[i]
        comparison += num_list[i]
        
    if answer > comparison**2:
        bit = 0
    else:
        bit = 1
    return bit

num_list = [3, 4, 5, 2, 1]
num_list_comparison = [5, 7, 8, 3]
print(solution(num_list))
print(solution(num_list_comparison))

def solution(num_list):
    a=1
    b=0
    for x in num_list:
        a*=x
        b+=x
    if a<b*b: return 1
    return 0
