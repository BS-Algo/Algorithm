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

# 코딩 기초 트레이닝