#include <iostream>
#include <vector>
#include <set>
#include <string>
#include <cassert>
#include <fmt/ranges.h>

auto eliminate() -> void;
auto dotProduct(std::vector<int> firstVector, std::vector<int> secondVector) -> int;
auto iterateEveryNElements(std::vector<int> vec, int n) -> void;
auto iterateEveryNElements(std::set<int> vec, int n) -> void;
auto suffix(std::set<int> testSet, std::vector<int> testVector) -> bool;
auto isPalindrome(std::string sentence) -> bool;
auto sortBiggerHalf(std::vector<int>& numbers) -> void;
auto printWithoutDuplicates(std::vector<std::string> strings) -> void;

int main() {

    using namespace std;

    auto choice = -1;

    while (choice < 0 || choice > 7) {
        fmt::println("[0] Eliminate biggest and smallest value");
        fmt::println("[1] Dot product");
        fmt::println("[2] Iterate every N elements");
        fmt::println("[3] Biggest elements of set");
        fmt::println("[4] Is palindrome");
        fmt::println("[5] Sort bigger half");
        fmt::println("[6] Print without duplicates");
        fmt::print("Choose program: ");
        cin >> choice;
    }

    cout << '\n';

    switch (choice) {
        case 0:
            eliminate();
        break;

        case 1: {
            auto firstVector = vector<int>{4,5,6,7,2};
            auto secondVector = vector<int>{4,3,9,1,10};

            assert(firstVector.size() == secondVector.size() && "First vector's size must be equal to second vector's size");

            fmt::println("Dot product of {} and {}: {}", firstVector, secondVector, dotProduct(firstVector, secondVector));
        } break;

        case 2: {
            auto testVec = vector<int>{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
            auto testSet = set<int>{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

            iterateEveryNElements(testVec, 2);
            fmt::println("");
            iterateEveryNElements(testSet, 3);
        } break;

        case 3: {
            auto testSet = set<int>{1,2,3,4,5,6,7,7,7,7};
            auto testVec = vector<int>{5,6,7};

            assert(testVec.size() <= testSet.size() && "Vector's size must be less or equals to set's size");

            fmt::println("Vector {} is suffix of {} set: {}", testVec, testSet, suffix(testSet, testVec));
        } break;

        case 4: {
            string sentence = string();
            fmt::print("Input sentence: ");
            cin >> sentence;

            fmt::println("{} is palindrome: {}", sentence, isPalindrome(sentence));
        } break;

        case 5: {
            auto firstHalfBigger  = std::vector<int>{3, 2, 1, 0, 1, 0};
            auto secondHalfBigger = std::vector<int>{3, 2, 1, 6, 5, 4};
            auto secondHalfBigger2 = std::vector<int>{3, 2, 1, 4, 6, 5, 4};
            auto bothHalvesSame   = std::vector<int>{5, 4, 5, 4};

            sortBiggerHalf(firstHalfBigger);
            sortBiggerHalf(secondHalfBigger);
            sortBiggerHalf(secondHalfBigger2);
            sortBiggerHalf(bothHalvesSame);

            fmt::println(
                    "{}\n{}\n{}\n{}",
                    firstHalfBigger,
                    secondHalfBigger,
                    secondHalfBigger2,
                    bothHalvesSame
            );
        } break;

        case 6: {
            vector<string> strings = {"Adam", "Illia", "Ewa", "Anastasia", "Illia", "Maciej", "Adam", "Natalia", "Wiktor", "Wiktor"};

            assert(strings.size() == 10 && "Vector must contain 10 elements!");

            printWithoutDuplicates(strings);
        } break;

        default: fmt::print("Invalid input!");
    }

    return 0;
}
