#include "bits/stdc++.h"
using namespace std;
int n;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    deque<int> Q;
    for (int i = 1; i <= n; i++) {
        Q.push_back(i);
    }
    while (Q.size() > 1) {
        Q.pop_front();
        Q.push_back(Q.front());
        Q.pop_front();
    }
    cout << Q.front();
}