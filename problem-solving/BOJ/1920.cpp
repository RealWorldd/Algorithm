#include "bits/stdc++.h"
using namespace std;
int n, m;
int a[100005];
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a+n);
    cin >> m;
    while (m--) {
        int num;
        cin >> num;
        auto it = binary_search(a, a+n, num);
        if(it){
            cout << "1" << "\n";
        }else{
            cout << "0" << "\n";
        }
    }
}