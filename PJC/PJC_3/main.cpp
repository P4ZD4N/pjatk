#include <iostream>
#include <fmt/ranges.h>
#include <vector>
#include <string>
#include <algorithm>

auto elementsModificationWithUsageOfForLoop(std::vector<int>& numbers) -> void;
auto reduceAdjacentWhitespaces(const std::string& toReduce) -> std::string;
auto naturalSort(std::vector<std::string>& strings) -> std::vector<std::string>;

namespace v1 {
    auto printTheLongestString(std::vector<std::string> strings) -> void {
        auto const longest = std::ranges::max(strings);
        fmt::println("Longest from {}: {}", strings, longest);
    }
}

namespace v2 {
    auto printTheLongestString(std::vector<std::string> strings) -> void {
        auto const longest = std::ranges::max_element(strings);
        fmt::println("Longest from {}: {}", strings, *longest);
    }
}

namespace v3 {
    auto printTheLongestString(std::vector<std::string> strings) -> void {
        auto const longest = std::ranges::min(strings, std::ranges::greater(), std::ranges::size);
        fmt::println("Longest from {}: {}", strings, longest);
    }
}

namespace v4 {
    auto printTheLongestString(std::vector<std::string> strings) -> void {
        auto const longest = std::ranges::min_element(strings, std::ranges::greater(), std::ranges::size);
        fmt::println("Longest from {}: {}", strings, *longest);
    }
}

auto main() -> int {

    using namespace std;

    auto choice = -1;

    while (choice < 0 || choice > 4) {
        fmt::println("[0] Elements modification with usage of for loop");
        fmt::println("[1] Finding the longest text");
        fmt::println("[2] Reduce adjacent whitespaces");
        fmt::println("[3] Natural sort");
        fmt::print("Choose program: ");
        cin >> choice;
    }

    cout << '\n';

    switch (choice) {
        case 0: {
            auto vec = vector<int>(10);
            fmt::println("{}", vec);
            elementsModificationWithUsageOfForLoop(vec);
            fmt::println("{}", vec);
        } break;

        case 1: {
            auto const v1 = vector<string>{"a", "bb", "ccc"};
            auto const v2 = vector<string>{"wiktor", "chudy"};
            auto const v3 = vector<string>{"1234", "43212", "5555"};
            auto const v4 = vector<string>{"", "assfd", "fsdgagdagfdagsdfg"};

            v1::printTheLongestString(v1);
            v2::printTheLongestString(v2);
            v3::printTheLongestString(v3);
            v4::printTheLongestString(v4);
        } break;

        case 2: {
            fmt::println("[{}]", reduceAdjacentWhitespaces("Abc"));
            fmt::println("[{}]", reduceAdjacentWhitespaces("A b c"));
            fmt::println("[{}]", reduceAdjacentWhitespaces("   A\tb c      "));
            fmt::println("[{}]", reduceAdjacentWhitespaces("A\t\tb\n \n  \t c"));
        } break;

        case 3: {
            auto lectureNames = std::vector<std::string>{
                "lecture 1", "lecture 2", "lecture 3",
                "lecture 10", "lecture 11", "lecture 12",
                "lecture 35", "lecture 39", "lecture 11111",
                "lecture 101", "lecture 111", "lecture 133",
                "lecture 159", "lecture 212", "lecture 221"
            };

            auto fileNames = std::vector<std::string>{
                "file1.txt", "file10.txt", "file11.txt",
                "file2.txt", "file20.txt", "file3.txt",
                "file30.txt", "file4.txt", "file40.txt",
            };


            fmt::println("{}", naturalSort(lectureNames));
            fmt::println("{}", naturalSort(fileNames));
        } break;

        default: fmt::print("Invalid input!");
    }
}
