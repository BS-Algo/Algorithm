while True:
    sentence = input()
    if sentence == '.':
        break
        
    stack = []
    check = True
    for spelling in sentence:
        if spelling == '(' or spelling == '[':
            stack.append(spelling)
        if stack:
            if spelling == ')':
                tmp = stack.pop()
                if tmp != '(':
                    check = False
            elif spelling == ']':
                tmp = stack.pop()
                if tmp != '[':
                    check = False
        else:
            if spelling == ')' or spelling == ']':
                check = False
        
    if not check or stack:
        print('no')
    elif check:
        print('yes')