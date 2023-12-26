#include <iostream>
using namespace std;

int main() {
	long long n;
	long long k;
	cin >> n >> k;

	long long row, col, answer;
	long long left, right, mid;

	left = 0;
	right = n / 2;

	while (left <= right) {
		mid = (left + right) / 2;
		row = mid + 1;
		col = n - mid + 1;
		answer = row * col;
		if (answer == k) {
			cout << "YES";
			return 0;
		}
		else if (answer < k) {
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}
	cout << "NO";

	return 0;
}
