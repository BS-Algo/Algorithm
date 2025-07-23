def solution(record):
    answer = []
    idx_list = []
    nick_dict = {}
    command_dict = {'Enter': "님이 들어왔습니다.", 'Leave': "님이 나갔습니다."}
    n = len(record)
    
    for i in range(n):
        record[i] = record[i].split()
        idx_list.append((record[i][0], record[i][1]))
        if record[i][0] == 'Enter' or record[i][0] == 'Change':
            nick_dict[record[i][1]] = record[i][2]
            
    for command, uid in idx_list:
        if command == 'Change':
            continue
        answer.append(f'{nick_dict[uid]}'+command_dict[command])
    
    return answer