# 다이나믹 프로그래밍(메모이제이션, 누적합)

N = int(input())

num_lst = list(map(int, input().split()))


for i in range(1, N):
    # 왼쪽부터 더해서 진행하되, 더했을 때의 값이 더 작아지는 경우라면 해당 숫자를 처음으로 삼고 다시 시작.
    num_lst[i] = max(num_lst[i-1] + num_lst[i], num_lst[i])

print(max(num_lst))


# # 다이나믹 프로그래밍(메모이제이션, 누적합)

# N = int(input())

# num_lst = list(map(int, input().split()))
# prefix = [-1000] * (N + 1)

# for i in range(N):
#     # 왼쪽부터 더해서 진행하되, 더했을 때의 값이 더 작아지는 경우라면 해당 숫자를 처음으로 삼고 다시 시작.
#     prefix[i + 1] = max(prefix[i] + num_lst[i], num_lst[i])

# print(max(prefix))