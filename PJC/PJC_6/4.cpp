#include <string>
#include <filesystem>
#include <fmt/std.h>

auto printNumberOfFilesInFolder(const std::string& absolutePath) -> void {

    auto const path = std::filesystem::path(absolutePath);
    auto fileCount = 0;

    for (auto const& entry : std::filesystem::directory_iterator(path)) fileCount++;

    fmt::println("Number of files in {}: {}", absolutePath, fileCount);
}