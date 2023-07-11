#include "bits/stdc++.h"
using namespace std;
typedef long long ll;
ll n, m;
ll trees[1000005];
ll d[1000005];
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> trees[i];
    }
    sort(trees, trees + n, greater());
    d[0] = 0;
    for (int i = 1; i < n; i++) {
        d[i] = d[i - 1] + i * (trees[i - 1] - trees[i]);
        if(d[i] >= m){
            cout << trees[i] + (d[i] - m) / i;
            return 0;
        }
    }
    for (int i = 1; i < trees[n-1]; i++) {
        if(d[n-1] + n*(trees[n-1] - (trees[n-1] - i)) >= m){
            cout << trees[n-1] - i;
            return 0;
        }
    }
    cout << 0;
}