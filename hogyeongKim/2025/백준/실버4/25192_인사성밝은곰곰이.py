chat_lst = [input() for _ in range(int(input()))]

result = set()
cnt = 0

for chat in chat_lst:
    if chat == 'ENTER':
        cnt += len(result)
        result = set()
    else:
        result.add(chat)
cnt += len(result)
print(cnt)