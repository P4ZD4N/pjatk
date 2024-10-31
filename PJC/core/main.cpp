#include <iostream>
#include <vector>
#include <string>
#include <fmt/ranges.h>
#include <algorithm>

auto boxPrint(std::vector<std::string> words, char border = '*') -> void;
auto reversedWords(const std::string &sentence) -> std::string;
auto manipulation() -> void;
auto example(std::vector<std::string> left, std::vector<std::string> right) -> void;


namespace pjc::ranges {
    auto sort(const std::vector<int> numbers) -> std::vector<int> {
        std::vector<int> sorted = numbers;
        std::ranges::sort(sorted);
        return sorted;
    }

    auto reverse(const std::vector<int> numbers) -> std::vector<int> {
        std::vector<int> reversed = numbers;
        std::ranges::reverse(reversed);
        return reversed;
    }
}

auto main() -> int {
    using namespace std;

    auto choice = -1;

    while(choice < 0 || choice > 5) {
        cout << "[0] Box print" << '\n';
        cout << "[1] Reversed words" << '\n';
        cout << "[2] Manipulation of data display format" << '\n';
        cout << "[3] Refactoring with usage of lambdas and algorithms" << '\n';
        cout << "[4] Enhancements to the standard library" << "\n";
        cout << "Choose program: ";
        cin >> choice;
    }

    cout << '\n';

    switch (choice) {
        case 0:
            boxPrint({"a", "quick", "brown", "fox"});
            boxPrint({"siema", "jestem", "wiktor", ":)"}, '=');
            boxPrint({"a", "quick", "brown", "fox"}, '#');
            boxPrint(std::vector<std::string>{"a", "quick", "brown", "fox"}, '#');
            boxPrint({""});
            boxPrint({});
            boxPrint({}, '#');
            boxPrint({"", "hmmmm", ""});
            boxPrint({"", "", ""});
        break;

        case 1:
            cout << reversedWords("Ala ma kota") << '\n';
            cout << reversedWords("Ala") << '\n';
            cout << reversedWords("Siema jestem wiktor :>") << '\n';
            cout << reversedWords("") << '\n';
            cout << reversedWords("1 2 3") << '\n';
        break;

        case 2:
            manipulation();
        break;

        case 3: {
            const auto vec1 = std::vector<std::string>{"1", "1", "3", "2","7", "1", "5"};
            const auto vec2 = std::vector<std::string>{"1", "1", "3", "2","7", "1", "5", "5", "7"};

            example(vec1, vec2);
        } break;

        case 4: {
            const auto vec1 = std::vector{1, 1, 3, 2, 7, 1, 5};

            auto sorted = pjc::ranges::sort(vec1);
            auto reversed = pjc::ranges::reverse(vec1);

            fmt::println("Original before: {}", vec1);
            fmt::println("Copy sorted: {}", sorted);
            fmt::println("Copy reversed: {}", reversed);
            fmt::println("Original after: {}", vec1);
        } break;

        default: cout << "Incorrect input!";
    }

    cout << "\n";

    return 0;
}
