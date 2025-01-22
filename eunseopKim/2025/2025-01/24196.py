line = input()
pos = 0
answer = ''
while pos < len(line):
    answer += line[pos]
    pos += ord(line[pos]) - ord('A') + 1
print(answer)