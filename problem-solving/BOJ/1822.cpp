#include "bits/stdc++.h"
using namespace std;
int a, b;
int arrA[500001];
int arrB[500001];
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> a >> b;
    for (int i = 0; i < a; i++) {
        int num;
        cin >> num;
        arrA[i] = num;
    }
    for (int i = 0; i < b; i++) {
        int num;
        cin >> num;
        arrB[i] = num;
    }
    sort(arrB, arrB + b);
    vector<int> V;
    for (int i = 0; i < a; i++) {
        if (!binary_search(arrB, arrB + b, arrA[i])) {
            V.push_back(arrA[i]);
        }
    }
    if (V.empty()) {
        cout << 0;
        return 0;
    }
    sort(V.begin(), V.end());
    cout << V.size() << "\n";
    for (auto i: V) {
        cout << i << " ";
    }
}