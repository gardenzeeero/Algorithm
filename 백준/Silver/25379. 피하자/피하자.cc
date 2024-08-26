#include <iostream>
#include <algorithm>
using namespace std;

int arr[1000001];

int main(void) {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	long long n, i, c0 = 0, c1 = 0, cnt0 = 0, cnt1 = 0;

	cin >> n;
	for (i = 0; i < n; i++) { cin >> arr[i]; }

	for (i = 0; i < n; i++) {
		if ((arr[i] % 2)) { // 홀수
			c1++;
			cnt0 += c0;
		}
		else { // 짝수
			c0++;
			cnt1 += c1;
		}
	}
	cout << min(cnt0, cnt1);

	return 0;
}