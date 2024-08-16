#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;

    int arr[3];
    int maxDp[3] = {0, 0, 0};
    int minDp[3] = {0, 0, 0};

    for (int i = 0; i < n; ++i) {
        cin >> arr[0] >> arr[1] >> arr[2];

        // 이전 줄에서의 최대값과 최소값을 기반으로 현재 줄의 최대값과 최소값 계산
        int maxTmp0 = max(maxDp[0], maxDp[1]) + arr[0];
        int maxTmp1 = max({maxDp[0], maxDp[1], maxDp[2]}) + arr[1];
        int maxTmp2 = max(maxDp[1], maxDp[2]) + arr[2];

        int minTmp0 = min(minDp[0], minDp[1]) + arr[0];
        int minTmp1 = min({minDp[0], minDp[1], minDp[2]}) + arr[1];
        int minTmp2 = min(minDp[1], minDp[2]) + arr[2];

        // 계산된 값을 현재 줄의 DP 값으로 갱신
        maxDp[0] = maxTmp0;
        maxDp[1] = maxTmp1;
        maxDp[2] = maxTmp2;

        minDp[0] = minTmp0;
        minDp[1] = minTmp1;
        minDp[2] = minTmp2;
    }

    // 마지막 줄의 최대값과 최소값 계산
    int resultMax = max({maxDp[0], maxDp[1], maxDp[2]});
    int resultMin = min({minDp[0], minDp[1], minDp[2]});

    cout << resultMax << " " << resultMin << endl;

    return 0;
}