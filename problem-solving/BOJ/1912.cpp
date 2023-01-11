#include "bits/stdc++.h"
using namespace std;
int n;
int a[100005];
int d[100005];
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> a[i];
    d[1] = a[1];
    for(int i = 2; i <= n; i++) d[i] = max(d[i-1], 0) + a[i];
    cout << *max_element(d+1, d+n+1);
}