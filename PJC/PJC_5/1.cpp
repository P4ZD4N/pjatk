#include <map>
#include <string>
#include <set>
#include <iostream>

auto fulfillMapWithGraph(
    std::map<std::string, int>& visitsCount, std::map<std::string,
    std::set<std::string>> graph
) -> void {
    for (auto const& [key, value] : graph) visitsCount[key] = 0;
}

auto hasGraphCycle(std::map<std::string, std::set<std::string>> graph) -> bool {

    auto visitsCount = std::map<std::string, int>{};
    fulfillMapWithGraph(visitsCount, graph);

    auto whileLoopExecutions = 0;
    auto current = graph.begin() -> first;

    while (whileLoopExecutions <= graph.size() * 4) {
        visitsCount[current]++;
        whileLoopExecutions++;

        if (graph[current].empty()) break;
        current = *graph[current].begin();
    }

    for (auto const& [key, value] : visitsCount) {
        if (value > 1) return true;
    }

    return false;
}