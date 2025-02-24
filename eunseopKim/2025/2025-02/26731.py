import string

text = input()
for a in string.ascii_uppercase :
    if a not in text :
        print(a)
        break