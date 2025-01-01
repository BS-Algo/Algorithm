from collections import deque

def bfs(i, o):
    queue = deque()
    queue.append((i, 1))

    while queue:
        cur_val, cnt = queue.popleft()

        if cur_val == o:
            return cnt

        if cur_val * 2 <= o:
            queue.append((cur_val * 2, cnt + 1))
            bfs(cur_val * 2, cnt + 1)

        if cur_val * 10 + 1 <= o:
            queue.append((cur_val * 10 + 1, cnt + 1))
            bfs(cur_val * 10 + 1, cnt + 1)

    return -1


input, output = map(int, input().split())
result = bfs(input, output)

print(result)