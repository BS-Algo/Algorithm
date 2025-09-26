# 직사각형 별 찍기
# https://school.programmers.co.kr/learn/courses/30/lessons/12969

a, b = map(int, input().strip().split(' '))
a, b = 5, 3
print(a + b)

for i in range(b):
    print(a*'*')

# for 문 사용하지 않고
a, b = map(int, input().strip().split(' '))
answer = ('*'*a +'\n')*b
print(answer)