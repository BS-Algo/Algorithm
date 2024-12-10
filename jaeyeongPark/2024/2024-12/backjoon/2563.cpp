#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	// 색종이 갯수 받아오기
	int N;
	cin >> N;
	
	bool all[100][100] = { 0 };
	int sum = 0;
	
	// 각각의 색종이가 왼쪽 모서리로부터 시작점 받아오기(가로세로 10임)
	// 전체 크기가 100*100 이므로 전체를 0으로 두고 색칠할 부분만 1로 바꾸면 됨

	for (int i = 0; i < N; i++) {
		int x, y;
		cin >> x >> y;
		for (int dx=x; dx < x + 10; dx++) {
			for (int dy = y; dy < y + 10; dy++) {
				if (all[dx][dy] == 1) {
					continue;
				}
				all[dx][dy] = 1;
				sum++;
				
			}
		}
	}

	cout << sum;


	return 0;
}