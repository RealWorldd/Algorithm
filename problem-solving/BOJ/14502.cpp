#include "bits/stdc++.h"
using namespace std;
#define X first
#define Y second
int n, m; //n: 세로 크기, m: 가로 크기
int board[10][10];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    vector<pair<int, int>> space;
    vector<pair<int, int>> virus;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            int type;
            cin >> type;
            board[i][j] = type;
            if(type == 0) space.push_back({j, i});
            if(type == 2) virus.push_back({j, 1});
        }
    }
    int res = 0;
    vector<bool> temp(space.size(), true);
    for (int i = 0; i < space.size() - 3; i++)
        temp[i] = false;
    do{
        int temp_board[10][10];
        copy(&board[0][0], &board[0][0] + 100, &temp_board[0][0]);
        int temp_vis[10][10];
        for (int i = 0; i <= n; i++)
            fill(temp_vis[i], temp_vis[i] + m + 1, -1);
        vector<pair<int, int>> new_walls;
        for (int i = 0; i < space.size(); ++i) {
            if(temp[i])
                new_walls.push_back(space[i]);
        }
        for (auto i: new_walls) {
            temp_board[i.Y][i.X] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(temp_vis[i][j] == 1 || temp_board[i][j] == 1 || temp_board[i][j] == 0) continue;
                queue<pair<int, int>> q;
                q.push({j, i});
                temp_vis[i][j] = 1;
                while (!q.empty()) {
                    pair<int, int> cur = q.front();
                    q.pop();
                    for (int nxt = 0; nxt < 4; nxt++) {
                        int nx = cur.X + dx[nxt];
                        int ny = cur.Y + dy[nxt];
                        if(nx < 1 || nx > m || ny < 1 || ny > n) continue;
                        if(temp_vis[ny][nx] == 1 || temp_board[ny][nx] == 1) continue;
                        q.push({nx, ny});
                        temp_vis[ny][nx] = 1;
                    }
                }
            }
        }
        int temp_space_size = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(temp_vis[i][j] == -1 && temp_board[i][j] == 0) temp_space_size++;
            }
        }
        if(temp_space_size == 0) continue;
        res = max(res, temp_space_size);
    } while(next_permutation(temp.begin(), temp.end()));
    cout << res;
}