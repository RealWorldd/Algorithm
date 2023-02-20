#include "bits/stdc++.h"
using namespace std;
int n, m;
int cards[500001];
int hCards[500001];
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        cards[i] = num;
    }
    cin >> m;
    for (int i = 0; i < m; i++) {
        int num;
        cin >> num;
        hCards[i] = num;
    }
    sort(cards, cards + n);
    for (int i = 0; i < m; i++) {
        if (binary_search(cards, cards + n, hCards[i])) {
            hCards[i] = 1;
            continue;
        }
        hCards[i] = 0;
    }
    for (int i = 0; i < m; i++) {
        cout << hCards[i] << " ";
    }
}