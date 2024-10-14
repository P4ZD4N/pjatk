#include <iostream>
#include <vector>
#include <cmath>

auto isPrime(int number) -> bool {

    using namespace std;

    if (number < 2) return false;
    for (int i = 2; i <= sqrt(number); i++) {
        if (number % i == 0) return false;
    }
    return true;
}

auto verifyPrimeNumbers() -> void {

    using namespace std;

    cout << "Please input the numbers" << '\n';
    cout << "Type in a negative number to stop." << '\n';

    vector<int> numbersToCheckForPrimality = {};

    auto number = 0;

    while (number >= 0) {
        cin >> number;

        if (number >= 0) {
            numbersToCheckForPrimality.push_back(number);
        }
    }

    for (int numberToCheckForPrimality : numbersToCheckForPrimality) {
        if (isPrime(numberToCheckForPrimality)) {
            cout << numberToCheckForPrimality << " is prime." << '\n';
        } else {
            cout << numberToCheckForPrimality << " is not prime." << '\n';
        }
    }
}