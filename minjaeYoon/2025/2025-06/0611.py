# 숨어있는 숫자의 덧셈 (1)
def solution(my_string):
    return sum([int(i) for i in my_string if i.isdigit()])

my_string = "aAb1B2cC34oOp"

print(solution(my_string))