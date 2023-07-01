#include "bits/stdc++.h"
using namespace std;
string a, b;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    getline(cin, a); //공백 포함 문자열은 getline으로 해결
    getline(cin, b);
    int result = 0;
    for (int i = 0; i < a.length();) {
        int index = i;
        for (int j = 0; j < b.length(); j++) {
            if(a[index] == b[j]) {
                if(j == b.length() - 1) {
                    result++;
                    i += b.length();
                    break;
                }
                index++;
                continue;
            }
            i++;
            break;
        }
    }
    cout << result;
}