#include "bits/stdc++.h"
using namespace std;
/**
 * 주어진 피보나치 함수로 값을 구하려하면 시간초과가 나게해서
 * 함정이 있었던 것 같은 문제였다. 규칙을 찾아서 점화식을 찾아서 풀었다.
 */
pair<int, int> d[50]; //값을 저장할 배열
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    d[0] = {1, 0}; //초기값 0 일 때 1, 0
    d[1] = {0, 1}; // 초기값 1 일 때 0, 1
    for (int i = 2; i <= 40; i++) { // 점화식은 d[i] = d[i - 1] + d[i - 2]
        d[i].first = d[i - 1].first + d[i - 2].first;
        d[i].second = d[i - 1].second + d[i - 2].second;
    }
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        cout << d[n].first << " " << d[n].second << "\n";
    }
}