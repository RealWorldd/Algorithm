#include "bits/stdc++.h"
using namespace std;
typedef long long ll;
ll n, m;
ll budget[10005];
ll d[10005];
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> budget[i];
    cin >> m;
    sort(budget, budget + n);
    d[0] = 0;
    for(int i = 1; i <= n; i++) {
        d[i] = d[i - 1] + budget[i - 1];
    }
    for (int i = 1; i <= n; i++) {
        if(d[i] + (n - i) * budget[i - 1] > m) {
            cout << (m - d[i - 1]) / (n - i + 1);
            return 0;
        }
    }
    cout << budget[n - 1];
}