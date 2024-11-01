#include <iostream>
#include <vector>
#include <string>
#include <fmt/ranges.h>
#include <algorithm>
#include <set>

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

    template<std::ranges::range T, typename Predicate>
    auto partition(const T container, Predicate predicate) -> std::pair<T, T> {
        auto modifiedContainer = container;
        std::ranges::partition(modifiedContainer, predicate);

        return std::pair<T, T>(container, modifiedContainer);
    }

    template<std::ranges::range T>
    auto drop(T container, int n) -> T {
        T newContainer;
        for (int i = n; i < container.size(); i++) newContainer.push_back(container.at(i));
        return newContainer;
    }

    template<std::ranges::range T>
    auto dropLast(T container, int n) -> T {
        T newContainer;
        for (int i = 0; i < container.size() - n; i++) newContainer.push_back(container.at(i));
        return newContainer;
    }

    template<std::ranges::range OuterContainer>
    auto flatten(const OuterContainer& container)
        -> std::vector<typename std::ranges::range_value_t<std::ranges::range_value_t<OuterContainer>>> {

        using InnerContainer = std::ranges::range_value_t<OuterContainer>;
        using TypeName = std::ranges::range_value_t<InnerContainer>;

        std::vector<TypeName> flattened;

        for (const InnerContainer& subContainer : container) {
            for (const TypeName& element : subContainer) {
                flattened.push_back(element);
            }
        }

        return flattened;
    }

    template<std::ranges::range R, typename TypeName>
    auto findAll(R& container, TypeName toFind) -> std::vector<TypeName> {
        std::vector<TypeName> vec;

        for (auto& element : container)
            if (element == toFind) vec.push_back(element);

        return vec;
    }

    template<std::ranges::range R, typename Predicate>
    auto findAllIf(R& container, Predicate predicate) -> std::vector<std::ranges::range_value_t<R>> {
        using TypeName = std::ranges::range_value_t<R>;
        std::vector<TypeName> vec;

        for (auto& element : container)
            if (predicate(element)) vec.push_back(element);

        return vec;
    }

}

auto main() -> int {
    using namespace std;

    auto choice = -1;

    while(choice < 0 || choice > 9) {
        cout << "[0] Box print" << '\n';
        cout << "[1] Reversed words" << '\n';
        cout << "[2] Manipulation of data display format" << '\n';
        cout << "[3] Refactoring with usage of lambdas and algorithms" << '\n';
        cout << "[4] Enhancements to the standard library" << "\n";
        cout << "[5] Splitting ranges" << '\n';
        cout << "[6] Cutting ranges" << '\n';
        cout << "[7] Flattening ranges" << '\n';
        cout << "[8] find_if extension" << '\n';
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

        case 5: {
            const auto vec1 = std::vector{1, 1, 3, 2, 7, 1, 5};
            const auto vec2 = std::vector<string>{"a", "bb", "ccc", "dddd", "eeeee"};
            const auto str1 = string("alfabet");

            const auto [v1First, v1Second] = pjc::ranges::partition(vec1, [](const int n) {
               return n % 2 == 0;
            });

            const auto [v2First, v2Second] = pjc::ranges::partition(vec2, [](const string& s) {
               return s.size() > 3;
            });

            const auto [str1First, str1Second] = pjc::ranges::partition(str1, [](const char& c) {
                return c == 'a';
            });

            fmt::println("{} - {}", v1First, v1Second);
            fmt::println("{} - {}", v2First, v2Second);
            fmt::println("{} - {}", str1First, str1Second);
        } break;

        case 6: {
            const auto vec1 = std::vector{1, 1, 3, 2, 7, 1, 5};
            const auto vec2 = std::vector<string>{"a", "bb", "ccc", "dddd", "eeeee"};
            const auto str1 = string("alfabet");

            fmt:: println("{} - {}", vec1, pjc::ranges::drop(vec1, 4));
            fmt:: println("{} - {}", vec2, pjc::ranges::drop(vec2, 3));
            fmt:: println("{} - {}", str1, pjc::ranges::dropLast(str1, 6));
        } break;

        case 7: {
            auto source1 = std::vector<std::set<int>>{
            {10},
            {1, 2, 3},
            {5, 6},
            {4},
            {7, 8, 9}
            };

            auto source2 = std::set<std::set<int>>{
            {10},
            {3, 2, 1},
            {6, 5},
            {4},
            {8, 7, 9}
            };

            fmt::println("{}", pjc::ranges::flatten(source1));
            fmt::println("{}", pjc::ranges::flatten(source2));
        } break;

        case 8: {
            const auto vec1 = std::vector{1, 1, 3, 2, 7, 1, 5};
            const auto set1 = std::set{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

            fmt::println("{} - {}", vec1, pjc::ranges::findAll(vec1, 1));
            fmt::println("{} - {}", set1, pjc::ranges::findAllIf(set1, [](const int n) {
                return n > 5;
            }));
        } break;

        default: cout << "Incorrect input!";
    }

    cout << "\n";

    return 0;
}
