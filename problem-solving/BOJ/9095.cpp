#include "bits/stdc++.h"
using namespace std;
int t;
int d[13];
vector<int> V;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> t;
    int m = 0;
    for (int i = 0; i < t; i++) {
        int num;
        cin >> num;
        V.push_back(num);
        m = max(m, num);
    }
    d[1] = 1; d[2] = 2; d[3] = 4;
    for (int i = 4; i <= m; i++) {
        d[i] = d[i-1] + d[i-2] + d[i-3];
    }
    for (auto i: V) {
        cout << d[i] << '\n';
    }
}