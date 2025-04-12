#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

// 진입, 이탈 횟수를 최소화하는 경로, 원은 행성계의 경계를 의미
// 점이 원 안에 있는지 확인해야함, 행성계의 경계를 알아야 하기 때문

bool isInside(int cx, int cy, int r, int x, int y) {
  int dx = cx-x;
  int dy = cy-y;
  return dx * dx + dy * dy < r * r;

}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);

  int T;
  cin >> T;

  while(T--){
    int x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;

    int n;
    cin >> n;

    int count = 0;
    for (int i = 0; i<n;i++){
      int cx, cy, r;
      cin >> cx >> cy >> r;

      bool inStart = isInside(cx,cy,r,x1,y1);
      bool inEnd = isInside(cx,cy,r,x2,y2);

      if(inStart != inEnd) count++;
    }

    cout << count << "\n";
  }

  return 0;
}

