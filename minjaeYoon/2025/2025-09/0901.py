# 핸드폰 번호 가리기
def solution(phone_number):
    answer = ''
    phone_number = list(map(int, str(phone_number)))
    for i in range(len(phone_number)-4):
        answer += '*'
    for i in range(len(phone_number)-4, len(phone_number)):
        answer += str(phone_number[i])
    return answer
    # return "*"*(len(s)-4)+s[-4:]
print(solution("01033334444"))