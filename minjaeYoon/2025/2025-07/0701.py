# 특정 문자 제거하기
def solution(my_string, letter):
    answer = [i for i in my_string if i != letter]
    return ''.join(answer)

my_string = "abcdef"	
letter = "f"	

print(solution(my_string, letter))
