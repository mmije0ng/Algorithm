#include <iostream>
#include <cstring>
using namespace std;

int main() {
	int N;
	char num[102];

	cin >> N >> num;

	int sum = 0;
	for (int i = 0; i < strlen(num); i++) {
		int n = num[i] - '0';
		sum += n;
	}

	cout << sum << endl;
}