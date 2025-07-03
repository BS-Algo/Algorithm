#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//브루트 포스로 전부다 해보기
//각 높이마다(0~256) 전부 해보기
//만들수 있는 높이 중 가장 시간이 적게 걸리는 것 선택

int N, M, B;
vector<vector<int>> land;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> N >> M >> B;
	land.resize(N, vector<int>(M));

	int minH = 256, maxH = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> land[i][j];
			//최소값 최대값 알고 그 범위 안에서 브루트포스
			minH = min(minH, land[i][j]);
			maxH = max(maxH, land[i][j]);
		}
	}

	int bestTime = 1e9;
	int bestHeight = 0;

	//가능한 모든 높이에 대해 브루트포스
	for (int h = minH; h <= maxH; h++) {
		int removeB = 0;
		int addB = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//그자리의 높이와 가능한 높이의 차를 가지고 블록을 제거할지 추가할지 결정
				int diff = land[i][j] - h;
				//그 차이만큼 제거나 추가
				if (diff > 0) {
					removeB += diff;
				}
				// 추가는 그 높이보다 작아서 음수니까 -를 붙여서 계산
				else {
					addB -= diff; 
				}
			}
		}

		//인벤토리 갯수 안에 맞아야 하기때문에
		//제거+인벤토리 >= 추가한 블럭갯수를 만족해야 가능
		if (removeB + B >= addB) {
			int time = removeB * 2 + addB;
			if (time <= bestTime) {
				bestTime = time;
				bestHeight = h;
			}
		}
	}

	cout << bestTime << " " << bestHeight << '\n';
	return 0;
}