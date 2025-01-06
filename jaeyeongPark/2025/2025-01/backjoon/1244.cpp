#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 남학생은 받은수의 배수만큼 스위치의 상대를 바꾼다
    // 여학생은 받은수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서 상태를 바꾼다.
    

    // 입력받는것
    // 스위치 개수
    // 스위치 상태
    // 학생수
    // 남학생 1. 여학생 2 이며 성별 표시후 받은수 

    int count;
    int state;

    vector<int> arr;

    int s_count;
    int sex;
    int num;

    cin >> count;

    for (int i = 0; i < count; i++) {
        cin >> state;
        arr.push_back(state);
    }

    cin >> s_count;

    for (int i = 0; i < s_count; i++) {
        cin >> sex >> num;
        // 성별이 남학생이면 num의 배수의 자리의 스위치 상태를 바꿈
        if (sex == 1) {
            for (int j = num - 1; j < count; j += num) {
                arr[j] = 1 - arr[j];
            }
        }
        // 성별이 여학생이면 num의 자리부터 대칭의 스위치 상태가 같고, 가장 넓은 범위를 찾아서 그 구간의 스위치 상태를 전부 바꿈
        else if (sex == 2) {
            int left = num - 2, right = num;
            arr[num - 1] = 1 - arr[num - 1];

            while (left >= 0 && right < count && arr[left] == arr[right]) {
                arr[left] = 1 - arr[left];
                arr[right] = 1 - arr[right];
                left--;
                right++;
            }
        }
    }
    for (int i = 0; i < count; i++) {
        cout << arr[i] << " ";
        if ((i + 1) % 20 == 0) cout << "\n";
    }
    if (count % 20 != 0) cout << "\n";


	return 0;
}