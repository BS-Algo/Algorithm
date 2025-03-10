#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  int n, k, a, b; cin >> n >> k >> a >> b;

  int eT = abs(1 - k) * b + (n - 1) * b;
  int sT = (n - 1) * a;

  cout << eT << " " << sT << "\n";

  return 0;
}