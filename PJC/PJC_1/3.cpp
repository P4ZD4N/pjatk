#include <iostream>
#include <vector>
#include <algorithm>

// Comparing entered values

auto comparing() -> void {

    using namespace std;

    vector<int> firstPartNumbers = {};
    vector<int> secondPartNumbers = {};
    auto i = 0;

    while (firstPartNumbers.size() + secondPartNumbers.size() < 10) {

        auto number = -1;

        cout << "Enter digit: ";
        cin >> number;

        if (i < 5) {
            firstPartNumbers.push_back(number);
            i++;
            continue;
        }

        i++;
        secondPartNumbers.push_back(number);
    }

    sort(firstPartNumbers.begin(), firstPartNumbers.end());
    sort(secondPartNumbers.begin(), secondPartNumbers.end());

    if (firstPartNumbers == secondPartNumbers) {
        cout << "Vectors contain the same digits!";
        return;
    }

    cout << "Vectors do not contain the same digits!";
}