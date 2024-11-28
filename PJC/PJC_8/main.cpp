#include <fmt/ranges.h>
#include <iostream>
#include <string>
#include <vector>

auto operator*(const std::string &str, int times) -> std::string {
    auto output = std::string("");;
    while (times--) output += str;
    return output;
}

auto operator*(int times, const std::string &str) -> std::string {
    auto output = std::string("");;
    while (times--) output += str;
    return output;
}

auto operator/(const std::string& str, int divider) -> std::vector<std::string> {
    auto vec = std::vector<std::string>{};

    const int partSize = str.size() / divider;
    const int remainder = str.size() % divider;

    int currentPos = 0;
    for (int i = 0; i < divider; i++) {
        const int currentPartSize = partSize + (i < remainder ? 1 : 0);

        vec.push_back(str.substr(currentPos, currentPartSize));
        currentPos += currentPartSize;
    }

    return vec;
}

auto main() -> int {
    auto choice = -1;

    while (choice < 0 || choice > 2) {
        fmt::println("[0] Text duplication");
        fmt::println("[1] Text division");
        fmt::print("Choose program: ");
        std::cin >> choice;
    }
    fmt::println("");

    switch (choice) {
        case 0: {

            const auto str1 = std::string("Siema");
            auto newStr1 = str1 * 5;
            auto newStr2 = 4 * str1;

            fmt::println("{}", newStr1);
            fmt::println("{}", newStr2);

        } break;

        case 1: {

            const auto str1 = std::string("nananana");
            auto vec = str1 / 2;

            fmt::println("{}", vec);

        } break;

        default: fmt::println("Invalid input!");
    }

    return 0;
}