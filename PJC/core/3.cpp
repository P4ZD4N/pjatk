#include <fmt/ranges.h>
#include <string>

auto printManyTimes() -> void {
    const auto x = "siema";

    fmt::println("({x}) ({x}) ({x})", fmt::arg("x", x));
}

auto displayReservedCharacters() -> void {
    fmt::println("The simplest C++ program is: \"auto main() -> int {{ }}\"");
}

auto containerSeparatorManipulation() -> void {
    using namespace std;

    const auto digits = {1,2,3,4,5,6,7};

    fmt::println("{}", digits);
    fmt::println("${}$", fmt::join(digits, " - "));
}

auto sequenceAndMultiplicityManipulation() -> void {
    fmt::println("{1}{0}", '?', "I'm enclosed in question marks");
}

auto digitsFormatting() -> void {
    auto fl = 1.337;
    auto in = 37;

    fmt::println("{:.3}", fl);
    fmt::println("Binary: {:b}", in);
    fmt::println("Decimal: {}", in);
    fmt::println("Hexadecimal: {:#x}", in);
}

auto justifyingText() -> void {
    using namespace std;

    auto text = string("Wiktor");

    fmt::println("{:*<20}", text);
    fmt::println("{:*>20}", text);
    fmt::println("{:*^20}", text);
}

auto manipulation() -> void {

    printManyTimes();
    displayReservedCharacters();
    containerSeparatorManipulation();
    sequenceAndMultiplicityManipulation();
    digitsFormatting();
    justifyingText();
}