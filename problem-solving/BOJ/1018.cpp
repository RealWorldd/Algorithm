#include "bits/stdc++.h"
using namespace std;
int m, n;
char board[52][52];
int chess(char c[][10]) {
    char first = c[0][0];
    int count = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (c[i][j] == first && first == 'B') {
                first = 'W';
                continue;
            }
            if (c[i][j] == first && first == 'W') {
                first = 'B';
                continue;
            }
            if (c[i][j] != first && first == 'B') {
                first = 'W';
                count++;
                continue;
            }
            if (c[i][j] != first && first == 'W') {
                first = 'B';
                count++;
                continue;
            }
        }
        if(first == 'B') {
            first = 'W';
            continue;
        }
        if(first == 'W') {
            first = 'B';
            continue;
        }
    }
    return count;
}
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> m >> n;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            cin >> board[i][j];
        }
    }
    int ans = 1000000;
    for (int i = 0; i <= m - 8; i++) {
        char test[10][10] = {0, };
        for (int j = 0; j <= n - 8; j++) {
            for (int k = 0; k < 8; k++) {
                for (int l = 0; l < 8; l++) {
                    test[k][l] = board[i + k][j + l];
                }
            }
            ans = min(ans, chess(test));
            if (test[0][0] == 'B') {
                test[0][0] = 'W';
                ans = min(ans, chess(test)+1);
            }
            if (test[0][0] == 'W') {
                test[0][0] = 'B';
                ans = min(ans, chess(test)+1);
            }
        }
    }
    cout << ans;
}