base_string = list(input())
match_string = input()

n, m = len(base_string), len(match_string)

def find_bomb():
    global m
    stack = []
    
    for char in base_string:
        stack.append(char)
        check = False
        if len(stack) >= m:
            check = True
            for i in range(1, m+1):
                if stack[-i] != match_string[-i]:
                    check = False
                    break
        if check:
            for _ in range(m):
                stack.pop()
    
    return stack
        
result = find_bomb()
print(''.join(result))
