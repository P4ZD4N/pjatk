#include <string>
#include <fmt/ranges.h>
#include <iostream>
#include <map>
#include <vector>

auto printGroupedWords(std::map<size_t, std::vector<std::string>> groupedWords) -> void {
    for (auto const& [length, words] : groupedWords) {
        for (auto const& word : words) {
            fmt::print("{} ", word);
        }
        fmt::println("");
    }
}

auto groupWordsByTextLength() -> void {

    auto wordsWithLengths = std::map<size_t, std::vector<std::string>>{};
    auto currentWord = std::string();

    while (currentWord != "stop") {
        fmt::print("Enter word (Enter 'stop' to stop): ");
        std::cin >> currentWord;

        if (currentWord == "stop") break;

        wordsWithLengths[currentWord.length()].push_back(currentWord);
    }

    printGroupedWords(wordsWithLengths);
}