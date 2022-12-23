#include "iostream"
#include "vector"
using namespace std;
int main (){
    int n, x;
    vector<int> v;
    cin >> n >> x;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        if(a < x) {
            v.push_back(a);
        }

    }
    for (auto i: v) {
        cout << i << " ";
    }
    return 0;
}