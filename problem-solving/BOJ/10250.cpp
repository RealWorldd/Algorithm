#include "bits/stdc++.h"
using namespace std;
int t, h, w, n;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> t;
    while(t--){
        cin >> h >> w >> n;
        int count = 1;
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= h; j++) {
                if(count == n) {
                    string a, b;
                    if(i < 10) {
                        b = "0" + to_string(i);
                    }else{
                        b = to_string(i);
                    }
                    a = to_string(j);
                    cout << a << b << "\n";
                }
                count++;
            }
        }
    }
}