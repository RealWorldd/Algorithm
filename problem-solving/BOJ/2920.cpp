#include "bits/stdc++.h"
using namespace std;
vector<int> V;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    for (int i = 0; i < 8; i++) {
        int num;
        cin >> num;
        V.push_back(num);
    }
    int as = 1;
    int des = 8;
    for (int i = 1; i < 8; i++) {
        if (V[0] == 1) {
            as++;
            if (as != V[i]) {
                cout << "mixed";
                return 0;
            }
            if (i == 7) {
                cout << "ascending";
                return 0;
            }
        }
        if (V[0] == 8) {
            des--;
            if (des != V[i]) {
                cout << "mixed";
                return 0;
            }
            if (i == 7) {
                cout << "descending";
                return 0;
            }
        }
    }
    cout << "mixed";
}