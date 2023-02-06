#include "bits/stdc++.h"
using namespace std;
using ll = long long;
int n, m;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    vector<pair<ll, ll>> V;
    for (int i = 0; i < n; i++) {
        ll a, b;
        cin >> a >> b;
        if(a > b) {
            V.push_back({b,a});
            continue;
        }
    }
    sort(V.begin(), V.end());
    ll start = V[0].first;
    ll end = V[0].second;
    ll len = 0;
    ll ans = m;
    for (int i = 1; i < V.size(); i++) {
        auto from = V[i].first;
        auto to = V[i].second;
        if(from <= end) {
            end = (to > end ? to : end);
        } else {
            len += end - start;
            start = from;
            end = to;
        }
    }
    len += end - start;
    ans += 2 * len;
    cout << ans;
}
