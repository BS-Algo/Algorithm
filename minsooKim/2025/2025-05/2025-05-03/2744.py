word = input()
upper_word = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P' , 'Q' , 'R' , 'S', 'T' , 'U', 'V', 'W', 'X', 'Y', 'Z']
lower_word = ['a', 'b,' 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l' ,'m', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
arr = []
for i in range(len(word)):
    if word[i].isupper():
        arr.append(word[i].lower())
    else:
        arr.append(word[i].upper())
for i in range(len(arr)):
    print(arr[i], end = '')
