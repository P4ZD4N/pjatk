#include <string>
#include <filesystem>
#include <fmt/ostream.h>
#include <sstream>

auto changeFileContent(std::fstream& file, const std::string& changeTo) -> void {

    auto result = std::string();
    auto currentNumber = std::string();

    auto line = std::string();
    while (std::getline(file, line)) {

        auto lineAsStream = std::istringstream(line);
        while (lineAsStream >> currentNumber) {
            if (std::ranges::all_of(currentNumber, [](const char c) { return std::isdigit(c); })) result += changeTo;
            else result += currentNumber;
            result += " ";
        }

        result += "\n";
    }

    file.clear();
    file.seekg(0, std::ios::beg);
    file << result;

    fmt::println("Replacement done!");
}