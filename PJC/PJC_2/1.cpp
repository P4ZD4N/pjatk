#include <iostream>
#include <vector>
#include <fmt/ranges.h>

auto eliminate() -> void {

    using namespace std;

    auto digits = vector<int>{};

    fmt::println("Enter 7 digits!");

    while (digits.size() != 7) {
        auto newDigit = int();

        fmt::print("Enter digit: ");
        cin >> newDigit;

        auto it = find(digits.begin(), digits.end(), newDigit);

        if (it != digits.end()) {
            fmt::println("Vector already contains value: {}", newDigit);
            continue;
        }

        digits.push_back(newDigit);
    }

    sort(digits.begin(), digits.end());

    fmt::println("Before: {}", digits);

    for (int i = 0; i <= 1; i++) {
        digits.pop_back();
        reverse(digits.begin(), digits.end());
    }

    fmt::println("After: {}", digits);
}
