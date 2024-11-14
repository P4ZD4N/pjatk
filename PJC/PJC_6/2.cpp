#include <filesystem>
#include <string>
#include <fstream>
#include <vector>
#include <fmt/base.h>
#include <fmt/ranges.h>
#include <sstream>
#include <algorithm>
#include <set>

auto areAllRowsCorrect(const std::string& absolutePathToFile) -> bool {
    auto digits = std::vector<std::string>{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    auto file = std::fstream(absolutePathToFile);

    for (auto line = std::string(); std::getline(file, line); ) {
        auto lineAsStream = std::stringstream(line);
        for (auto digit = std::string(); lineAsStream >> digit; ) {
            digits.erase(std::ranges::remove(digits, digit).begin(), digits.end());
        }
    }

    return digits.empty();
}

auto areAllColumnsCorrect(const std::string& absolutePathToFile) -> bool {
    auto digits = std::set<std::string>{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    auto file = std::fstream(absolutePathToFile);

    auto digitsInColumns = std::vector<std::set<std::string>>(9);
    for (auto line = std::string(); std::getline(file, line); ) {
        auto lineAsStream = std::stringstream(line);
        int columnIndex = 0;

        for (auto digit = std::string(); lineAsStream >> digit; ) {
            if (columnIndex < 9) digitsInColumns[columnIndex].insert(digit);
            columnIndex++;
        }
    }

    for (const auto& columnDigits : digitsInColumns) {
        if (columnDigits != digits) return false;
    }

    return true;
}

auto areAll3x3PartsCorrect(const std::string& absolutePathToFile) -> bool {
    auto file = std::fstream(absolutePathToFile);
    auto sudoku = std::vector(9, std::vector<int>(9));

    auto line = std::string();
    auto row = 0;

    while (std::getline(file, line)) {
        auto ss = std::stringstream(line);
        auto col = 0;
        auto value = 0;

        while (ss >> value) {
            sudoku[row][col] = value;
            col++;
        }
        row++;
    }

    for (int i = 0; i < 9; i += 3) {

        for (int j = 0; j < 9; j += 3) {

            auto subGrid = std::set<int>{};
            for (int x = 0; x < 3; ++x) {

                for (int y = 0; y < 3; ++y) {

                    auto row_index = i + x;
                    auto col_index = j + y;

                    if (auto value = sudoku[row_index][col_index]; value != 0) {
                        if (subGrid.contains(value)) return false;
                        subGrid.insert(value);
                    }
                }
            }
        }
    }

    return true;
}

auto findCorrectSudoku(const std::string& absolutePathToFolder) -> void {

    auto correctSudoku = std::vector<std::string>{};
    auto incorrectSudoku = std::vector<std::string>{};

    for (auto const& entry : std::filesystem::directory_iterator(std::filesystem::path(absolutePathToFolder))) {

        auto fileName = entry.path().filename();

        if (!areAllRowsCorrect(absolutePathToFolder + "/" + fileName.string()) ||
            !areAllColumnsCorrect(absolutePathToFolder + "/" + fileName.string()) ||
            !areAll3x3PartsCorrect(absolutePathToFolder + "/" + fileName.string())) {
            incorrectSudoku.push_back(fileName.string());
            continue;
        }

        correctSudoku.push_back(fileName.string());
    }

    fmt::println("Correct: {}, Incorrect: {}", correctSudoku, incorrectSudoku);
}
