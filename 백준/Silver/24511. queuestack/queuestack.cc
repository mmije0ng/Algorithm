#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	deque<int> dq;
	bool arr[100000];
	int cnt = 0;

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i <N; i++) {
		int num;
		cin >> num;

		if (arr[i])
			continue;
		dq.push_back(num);
	}

	int M, C;
	cin >> M;

	while(M--) {
		cin >> C;
		dq.push_front(C);
		cout << dq.back() << ' ';
		dq.pop_back();				
	}

}