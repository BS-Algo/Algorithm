A, P = map(int, input().split())
D = [A]

while True:
    word = str(D[-1])
    num = 0
    for i in range(len(word)):
        num += int(word[i])**P    

    if num in D:    
        print(D.index(num))
        break
    else:
        D.append(num)