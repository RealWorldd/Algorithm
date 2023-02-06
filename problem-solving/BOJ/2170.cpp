#include "bits/stdc++.h"
using namespace std;
int n;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    vector<pair<int, int>> V;
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        V.push_back({x, y});
    }
    sort(V.begin(), V.end());
    int start = V[0].first;
    int end = V[0].second;
    int len = 0;
    for (int i = 1; i < n; i++) {
        int from = V[i].first;
        int to = V[i].second;
        if (from <= end) {
            end = (to > end ? to : end);
        } else {
            len += end - start;
            start = from;
            end = to;
        }
    }
    len += end - start;
    cout << len;
}