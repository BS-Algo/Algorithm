#include<iostream>
#include<vector>
#include<string>
#include<deque>

using namespace std;

// 함수 R은 배열의 수의 순서를 뒤집음
// 함수 D는 첫번째 수를 버리는 함수, 배열이 비어있으면 D를 쓰면 에러 발생


int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int T,a,b;
	string C;
	

	cin >> T;
	for (int i = 0; i < T; i++) {
		string C;
		int a, b;
		string arr_input;

		cin >> C;
		cin >> a;
		cin >> arr_input;

		deque<int> arr;
		string num = "";
		
		//리스트를 받아올때 [랑 , 가 있기때문에 문자열 방식으로 받아오고 숫자만 isdigt로 파싱해야함
		// 두자리수 이상의 숫자 때문에 숫자끼리는 다 이어 붙임 그후에 ,나 ],[이게 나오면 num이 완성됐다는 뜻이므로 덱에 추가함
		for (int i = 1; i < arr_input.size(); i++) {
			if (isdigit(arr_input[i])) {
				num += arr_input[i];
			}
			else if (arr_input[i] == ',' || arr_input[i] == '[' || arr_input[i] == ']') {
				if (!num.empty()) {
					arr.push_back(stoi(num));
					num = "";
				}

			}
		}
		
		bool reverse_flag = false;
		bool error_flag = false;

		for (char c : C) {
			if (c == 'R') {
				reverse_flag = !reverse_flag;
			}
			else if (c == 'D') {
				if (arr.empty()) {
					error_flag = true;
					break;
				}
				if (reverse_flag) arr.pop_back();
				else arr.pop_front();
			}
		}
		if (error_flag) {
			cout << "error\n";
		}
		else {
			cout << "[";
			if (reverse_flag) {
				for (auto it = arr.rbegin(); it != arr.rend(); it++) {
					if (it != arr.rbegin()) cout << ",";
					cout << *it;
				}
			}
			else {
				for (size_t i = 0; i < arr.size(); i++) {
					if (i > 0) cout << ",";
					cout << arr[i];
				}
			}
			cout << "]\n";
		}


	}
	return 0;
}