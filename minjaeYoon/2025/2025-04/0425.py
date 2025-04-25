# 대문자로 바꾸기
def solution(myString):
    return myString.upper()

myString = "aBcDeFg"

print(solution(myString))

# 소문자로 바꾸기
def solution(myString):
    return myString.lower()

myString = "aBcDeFg"

print(solution(myString))

# 배열에서 대소문자 변환하기
def solution(strArr):
    answer = []
    for i in range(len(strArr)):
        if i % 2 == 0:
            answer.append(strArr[i].lower())
        elif i % 2 == 1:
            answer.append(strArr[i].upper())
        
    return answer

strArr = ["AAA","BBB","CCC","DDD"]

print(solution(strArr))

# A 강조하기
def solution(myString):
    answer = ''
    myString = list(myString)
    for i in range(len(myString)):
        if myString[i] == 'a':
            myString[i] = myString[i].upper()
        elif myString[i].isupper() and myString[i] != 'A':
            myString[i] = myString[i].lower()
    return answer.join(myString)

myString = "abstract algebra"	

print(solution(myString))