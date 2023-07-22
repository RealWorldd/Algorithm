#include "bits/stdc++.h"
using namespace std;
#define X first
#define Y second
int m, n;
int board[1005][1005];
int dis[1005][1005];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> m >> n;
    for (int i = 1; i <= n; i++)
        fill(dis[i], dis[i] + m + 1, -1);
    queue<pair<int, int>> q;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            int num;
            cin >> num;
            board[i][j] = num;
            if(num == 1) {
                q.push({j, i});
                dis[i][j] = 0;
            }
        }
    }
    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();
        for (int nxt = 0; nxt < 4; nxt++) {
            int nx = cur.X + dx[nxt];
            int ny = cur.Y + dy[nxt];
            if(nx < 1 || nx > m || ny < 1 || ny > n) continue;
            if(dis[ny][nx] >= 0 || board[ny][nx] == -1) continue;
            dis[ny][nx] = dis[cur.Y][cur.X] + 1;
            q.push({nx, ny});
        }
    }
    int res = 0;
    for (int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            if (dis[i][j] == -1 && board[i][j] == 0) {
                cout << -1;
                return 0;
            }
            res = max(res, dis[i][j]);
        }
    }
    cout << res;
}