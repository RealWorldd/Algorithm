#include "bits/stdc++.h"
using namespace std;
int m, n;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> m >> n;
    int a = min(m, n);
    while (a > 0) {
        if(m % a == 0 && n % a == 0) break;
        a--;
    }
    cout << a << "\n";
    int b = max(m, n);
    int c = min(m, n);
    int d = b;
    int i = 2;
    while(1) {
        if(d % c == 0) break;
        d = b * i;
        i++;
    }
    cout << d;
}