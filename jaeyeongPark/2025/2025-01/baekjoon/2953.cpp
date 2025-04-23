#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

	int total[5]; //참가자들의 점수 합을 저장 
	int num; // 입력받을 점수 
	int max = 0; //max값 
	int idx; //idx 값 

	for (int i = 0; i < 5; i++) {
		total[i] = 0;
		for (int j = 0; j < 4; j++) { //i번째 참가자의 점수를 합해서 저장 
			cin >> num;
			total[i] += num;
		}
		if (max < total[i]) { //max 값보다 더큰 값이 존재하면 변경 
			max = total[i];
			idx = i;
		}
	}
	cout << idx + 1 << " " << max << "\n";
	return 0;


}