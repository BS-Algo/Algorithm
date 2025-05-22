lst = ['a', 'e', 'i', 'o', 'u']
word = input()
cnt = 0
for i in range(len(word)):
    if word[i] in lst:
        cnt += 1
print(cnt)
