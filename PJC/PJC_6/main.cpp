#include <iostream>
#include <fmt/ranges.h>
#include <string>
#include <filesystem>
#include <fstream>

auto analyzeFile(const std::string& absolutePath) -> void;
auto findCorrectSudoku(const std::string& absolutePath) -> void;
auto changeFileContent(std::fstream& file, const std::string& changeTo) -> void;

auto main() -> int {

    auto choice = -1;

    while (choice < 0 || choice > 3) {
        fmt::println("[0] Numbers in file analysis");
        fmt::println("[1] Find correct sudoku");
        fmt::println("[2] Change file content");
        fmt::print("Choose program: ");
        std::cin >> choice;
    }

    fmt::println("");

    switch (choice) {
        case 0: {
            auto absolutePath = std::string();
            fmt::print("Enter absolute path to the file: ");
            std::cin >> absolutePath;

            if (!exists(std::filesystem::path(absolutePath))) {
                fmt::println("File does not exist!");
                break;
            }

            analyzeFile(absolutePath);
        } break;

        case 1: {
            auto absolutePath = std::string();
            fmt::print("Enter absolute path to the folder with sudoku: ");
            std::cin >> absolutePath;

            if (!exists(std::filesystem::path(absolutePath))) {
                fmt::println("Folder does not exist!");
                break;
            }

            findCorrectSudoku(absolutePath);
        } break;

        case 2: {
            auto absolutePath = std::string();
            fmt::print("Enter absolute path to file: ");
            std::cin >> absolutePath;

            if (!exists(std::filesystem::path(absolutePath))) {
                fmt::println("File does not exist!");
                break;
            }

            auto file = std::fstream(absolutePath);

            changeFileContent(file, "siema");
        } break;

        default: fmt::println("Invalid input!");
    }
    return 0;
}
