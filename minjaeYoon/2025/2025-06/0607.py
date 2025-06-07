def solution(my_string):
    import re
    numbers = re.findall(r'\d+', my_string)
    return sum(int(num) for num in numbers)