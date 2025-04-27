# 공백으로 구분하기 2
def solution(my_string):
    my_string = list(map(str, my_string.split()))
    return my_string

my_string = " i    love  you"

print(solution(my_string))

# x 사이의 개수
def solution(myString):
    answer = []
    myString = list(map(str, myString.split("x")))
    for i in range(len(myString)):
        answer.append(len(myString[i]))
    return answer

myString = "oxooxoxxox"	

print(solution(myString))