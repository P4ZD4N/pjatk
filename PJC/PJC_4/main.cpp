#include <iostream>
#include <fmt/ranges.h>
#include <vector>
#include <algorithm>
#include <type_traits>

namespace pjc::ranges {

    template<std::ranges::range T>
    auto sort(T container) -> T {
        T sorted = container;
        std::ranges::sort(sorted);
        return sorted;
    }

    template<std::ranges::range T>
    auto reverse(T container) -> T {
        T reversed = container;
        std::ranges::reverse(reversed);
        return reversed;
    }
}

template<typename ArgumentType, typename Function>
auto mapped(std::vector<ArgumentType> vec, Function func) -> std::vector<std::invoke_result_t<Function, ArgumentType>> {
    using ResultType = std::invoke_result_t<Function, ArgumentType>;

    std::vector<ResultType> resultVec;
    std::ranges::transform(vec.begin(), vec.end(), std::back_inserter(resultVec), func);

    return resultVec;
}

template<std::ranges::range T, typename Function>
auto chunkedApply(T container, Function func) -> void {

    using ElementType = decltype(*std::ranges::begin(container));

    constexpr size_t arg_count = std::is_invocable_v<Function, ElementType> +
                                  std::is_invocable_v<Function, ElementType, ElementType> * 2 +
                                  std::is_invocable_v<Function, ElementType, ElementType, ElementType> * 3;

    if constexpr (arg_count == 1) {
        for (auto& element : container) {
            func(element);
        }
    } else if constexpr (arg_count == 2) {
        for (auto i = 1; i < container.size(); i += 2) func(container[i - 1], container[i]);

        if (container.size() % 2 == 1) func(container[container.size() - 1], container[container.size() - 1]);
    } else if constexpr (arg_count == 3) {
        for (auto i = 2; i < container.size(); i += 3) func(container[i - 2], container[i - 1], container[i]);

        if (container.size() % 3 == 1) func(container[container.size() - 1], container[container.size() - 1], container[container.size() - 1]);
        if (container.size() % 3 == 2) func(container[container.size() - 2], container[container.size() - 1], container[container.size() - 1]);
    } else {
        fmt::println("Incorrect arguments count");
    }
}

auto main() -> int {

    auto choice = -1;

    while (choice < 0 || choice > 3) {
        fmt::println("[0] Generic improvement of standard library");
        fmt::println("[1] Mapping vector elements");
        fmt::println("[2] Convenient function adjustment");
        fmt::print("Choose program: ");
        std::cin >> choice;
    }

    fmt::println("");

    switch (choice) {
        case 0: {
            const auto vec1 = std::vector{1, 1, 3, 2, 7, 1, 5};
            const auto vec2 = std::vector<std::string>{"1", "1", "3", "2","7", "1", "5"};
            const auto vec3 = std::vector<float>{1.1, 1.5, 3, 2, 7.9, 1, 5};
            const auto str1 = std::string("siema");

            auto sorted = pjc::ranges::sort(vec3);
            auto reversed = pjc::ranges::reverse(vec3);

            fmt::println("Original before: {}", vec3);
            fmt::println("Copy sorted: {}", sorted);
            fmt::println("Copy reversed: {}", reversed);
            fmt::println("Original after: {}", str1);
        } break;

        case 1: {
            auto strings = std::vector<std::string>{"abc", "defghi", "jk", "lmno"};
            auto chars = mapped(strings, [](std::string s) { return s.front(); });
            auto sizes = mapped(strings, [](std::string s) { return s.size(); });

            fmt::println("{}", chars);
            fmt::println("{}", sizes);
        } break;

        case 2: {
            auto const ints1 = std::vector{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
            auto const ints2 = std::vector{1, 2, 3, 4, 5};
            auto const ints3 = std::vector{1, 2, 3, 4, 5, 6, 7};
            auto const ints4 = std::vector{1, 2, 3, 4, 5, 6, 7, 8};

            chunkedApply(ints3, [](int const n) {
                fmt::print("[{}] ", n);
            });

            fmt::println("");

            chunkedApply(ints3, [](int const a, int const b) {
                fmt::print("[{} {}]", a, b);
            });

            fmt::println("");

            chunkedApply(ints3, [](int const a, int const b, int const c) {
                fmt::print("[{} {} {}]", a, b, c);
            });
        } break;

        default: fmt::print("Invalid input!");
    }
}
