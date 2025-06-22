# 컨트롤 제트
def solution(s):
    answer = 0
    s = [x for x in s.split()]
    for i in range(len(s)):
        if s[i] == 'Z':
            answer -= int(s[i-1])
        else:
            answer += int(s[i])
    return answer

s = "1 2 Z 3"
s1 = "10 20 30 40"
s2 = "10 Z 20 Z 1"	

print(solution(s))
print(solution(s1))
print(solution(s2))

# := 연산자 풀이 (월러스 연산자) -> 변수에 값을 대입함과 동시에 연산에 사용할 수 있게 해주는 연산자
def solution(s):
    answer = 0
    for i in range(len(s := s.split(" "))):
        answer += int(s[i]) if s[i] != "Z" else -int(s[i-1])
    return answer