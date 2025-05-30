# 삼각형의 완성조건 (1)
def solution(sides):
    stand = max(sides)
    sides.remove(stand)
    
    if sum(sides) <= stand:
        return 2
    elif sum(sides) > stand:
        return 1

sides = [1, 2, 3]	

print(solution(sides))

# 중복된 문자 제거
def solution(my_string):
    answer = ''
    my_string = list(dict.fromkeys(my_string))
    return answer.join(my_string)

my_string = "We are the world"	

print(solution(my_string))

# 방법순서 보존성능사용 시기
# set()❌⭐⭐⭐순서가 중요하지 않을 때
# dict.fromkeys()✅⭐⭐⭐순서를 유지하고 싶을 때
# 반복문 + in✅⭐작은 데이터, 이해하기 쉬운 코드
# 리스트 컴프리헨션✅⭐작은 데이터
# pandas✅⭐⭐대용량 데이터 분석
# numpy정렬됨⭐⭐숫자 데이터

# k의 개수
def solution(i, j, k):
    answer = 0
    for a in range(i, j+1):
        answer += str(a).count(str(k))
    return answer

i = 1
j = 13
k = 1

print(solution(i, j, k))