#include "bits/stdc++.h"
using namespace std;
#define X first
#define Y second
int n;
string board[102];
bool vis[102][102];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int bfs(char c){
    for (int i = 0; i < n; i++) {
        fill(vis[i], vis[i] + n, 0);
    }
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if(board[i][j] != c || vis[i][j] == 1) continue;
            queue<pair<int, int>> q;
            q.push({j, i});
            vis[i][j] = 1;
            cnt++;
            while (!q.empty()) {
                pair<int, int> cur = q.front();
                q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(board[ny][nx] != c || vis[ny][nx]) continue;
                    vis[ny][nx] = 1;
                    q.push({nx, ny});
                }
            }
        }
    }
    return cnt;
}
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) {
        string line;
        cin >> line;
        board[i] = line;
    }
    int res1, res2;
    res1 = bfs('R') + bfs('G') + bfs('B');
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if(board[i][j] == 'G') board[i][j] = 'R';
        }
    }
    res2 = bfs('R') + bfs('B');
    cout << res1 << " " << res2;
}