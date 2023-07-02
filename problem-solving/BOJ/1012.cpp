#include "bits/stdc++.h"
using namespace std;
#define X first
#define Y second
int t, m, n, k;
int board[2503][2503];
bool vis[2503][2503];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> t;
    while (t--) {
        cin >> m >> n >> k;
        for (int i = 0; i < n; i++) {
            fill(board[i], board[i] + m, 0);
            fill(vis[i], vis[i] + m, 0);
        }
        for (int i = 0; i < k; i++) {
            int x, y;
            cin >> x >> y;
            board[y][x] = 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 0 || vis[i][j]) continue;
                queue<pair<int, int>> Q;
                vis[i][j] = 1;
                res++;
                Q.push({j, i});
                while (!Q.empty()) {
                    pair<int, int> cur = Q.front();
                    Q.pop();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.X + dx[dir];
                        int ny = cur.Y + dy[dir];
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if(vis[ny][nx] || board[ny][nx] != 1) continue;
                        vis[ny][nx] = 1;
                        Q.push({nx, ny});
                    }
                }
            }
        }
        cout << res << "\n";
    }
}