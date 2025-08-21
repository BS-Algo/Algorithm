#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> schedules, vector<vector<int>> timelogs, int startday) {
    int a = schedules.size();
    vector<int> arr(a, 0);
    
    for (int i = 0; i < a; i++) {
        bool ok = true; 
        for (int j = 0; j < 7; j++) {
            int day = (startday - 1 + j) % 7 + 1; 
            if (day == 6 || day == 7) continue; 

            int sh = schedules[i] / 100;
            int sm = schedules[i] % 100;
            int scheduleMinutes = sh * 60 + sm;

            int th = timelogs[i][j] / 100;
            int tm = timelogs[i][j] % 100;
            int timeMinutes = th * 60 + tm;

            if (timeMinutes > scheduleMinutes + 10) {
                ok = false; 
                break; 
            }
        }
        if (ok) arr[i] = 1;
    }

    int answer = 0;
    for (int i = 0; i < a; i++) {
        if (arr[i] == 1) answer++;
        cout << "arr[" << i << "] = " << arr[i] << "\n"; 
    }

    return answer;
}
