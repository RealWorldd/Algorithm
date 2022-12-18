#include "bits/stdc++.h"
using namespace std;
/**
 * 처음 좌표로 부터 탐색할 때 마다 들렸다는 표시를 두지 않고
 * dis라는 배열을 두어 탐색 당한 좌표로부터 +1을 하게 해서 문제를 해결하였다.
 */
#define X first
#define Y second
int n, m;
int board[102][102];
int dis[102][102]; //dis 배열을 선언해 한칸씩 옮길 때 마다 +1씩 증가하게 함
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &board[i][j]);
            dis[i][j] = -1; //dis 배열을 처음에 -1로 모두 초기화 시켜놓음
        }
    }
    queue<pair<int, int>> Q;
    dis[0][0] = 1; //{0, 0}도 거리에 포함되니 1로 설정
    Q.push({0, 0});
    while (!Q.empty()) {
        pair<int, int> cur = Q.front(); Q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(dis[nx][ny] != -1 || board[nx][ny] != 1) continue; //dis가 -1이 아니면 지나쳐 온 곳이기 때문에 continue 함으로써 거리와 방문 여부 두개의 역할 수행
            dis[nx][ny] =  dis[cur.X][cur.Y] + 1; //현재 좌표에서 길이 있는 좌표에 +1 을 해 거리 측정
            Q.push({nx, ny});
        }
    }
    cout << dis[n-1][m-1]; //n, m 에 기록된 좌표로 최단 거리 확인 가능
}