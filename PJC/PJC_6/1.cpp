#include <string>
#include <fstream>
#include <fmt/ranges.h>

auto analyzeFile(const std::string& absolutePath) -> void {
    auto file = std::fstream(absolutePath);
    auto digitCounter = 0;

    auto word = std::string();
    while (file >> word) {
        if (std::all_of(word.begin(), word.end(), isdigit)) digitCounter++;
    }

    fmt::println("Number of digits in {} file: {}", absolutePath, digitCounter);
}