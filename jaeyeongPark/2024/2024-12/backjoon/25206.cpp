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
	string obj;
	float score;
	string rank;
	float sum = 0;
	float sum_score = 0;
	for (int i = 0; i < 20; i++) {
		cin >> obj >> score >> rank;
		if (rank == "A+") {
			sum += score * 4.5;
			sum_score += score;
		}
		else if (rank == "A0") {
			sum += score * 4.0;
			sum_score += score;
		}
		else if (rank == "B+") {
			sum += score * 3.5;
			sum_score += score;
		}
		else if (rank == "B0") {
			sum += score * 3;
			sum_score += score;
		}
		else if (rank == "C+") {
			sum += score * 2.5;
			sum_score += score;
		}
		else if (rank == "C0") {
			sum += score * 2;
			sum_score += score;
		}
		else if (rank == "D+") {
			sum += score * 1.5;
			sum_score += score;
		}
		else if (rank == "D0") {
			sum += score * 1.0;
			sum_score += score;
		}
		else if (rank == "F") {
			sum += score * 0.0;
			sum_score += score;
		}
	}
	float result = sum / sum_score;
	cout << result;


	return 0;
}