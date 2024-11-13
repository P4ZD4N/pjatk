#include <map>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>
#include <cctype>

auto cleanWord(const std::string& word) -> std::string {
    auto cleanedWord = std::string();
    for (const char c : word) {
        if (std::isalpha(c)) cleanedWord += std::tolower(c);
    }
    return cleanedWord;
}

auto largestAnagramGroupsFrom(const std::string& text) -> std::vector<std::vector<std::string>> {
    auto anagramGroups = std::map<std::string, std::vector<std::string>>{};

    auto stream = std::istringstream(text);
    auto word = std::string();

    while (stream >> word) {
        const auto cleanedWord = cleanWord(word);
        if (cleanedWord.empty()) continue;

        auto sortedWord = cleanedWord;
        std::ranges::sort(sortedWord);

        auto& group = anagramGroups[sortedWord];

        if (std::ranges::find(group, cleanedWord) == group.end()) group.push_back(cleanedWord);
    }

    auto largestGroups = std::vector<std::vector<std::string>>{};
    size_t maxGroupSize = 0;

    for (const auto& [sortedWord, group] : anagramGroups) {
        if (group.size() > maxGroupSize) {
            maxGroupSize = group.size();
            largestGroups = {group};
        } else if (group.size() == maxGroupSize) {
            largestGroups.push_back(group);
        }
    }

    return largestGroups;
}