#include <iostream>
#include <fmt/ranges.h>
#include <map>
#include <set>
#include <string>
#include <vector>
#include <algorithm>

struct Point {
    int x;
    int y;

    auto printCoordinates() -> void {
        fmt::println("[{} {}]", x, y);
    }

    auto getDistanceFrom(const Point& point) -> int {
        return std::hypot(x - point.x, y - point.y);
    }

    auto changeCoordinatesTo(const int newX, const int newY) -> void {
        x = newX;
        y = newY;
    }
};

struct Student {
    private:
        std::string firstName;
        std::string lastName;
        std::string studentNumber;
        int semester = 0;

    public:
        Student(
            const std::string& first_name,
            const std::string& last_name,
            const std::string& student_number,
            const int semester
        ):
            firstName(first_name),
            lastName(last_name),
            studentNumber(student_number),
            semester(semester) {
        }

    [[nodiscard]] std::string getFirstName() const {
        return firstName;
    }

    void setFirstName(const std::string &first_name) {
        firstName = first_name;
    }

    [[nodiscard]] std::string getLastName() const {
        return lastName;
    }

    void setLastName(const std::string &last_name) {
        lastName = last_name;
    }

    [[nodiscard]] std::string getStudentNumber() const {
        return studentNumber;
    }

    void setStudentNumber(const std::string &student_number) {
        studentNumber = student_number;
    }

    [[nodiscard]] int getSemester() const {
        return semester;
    }

    void setSemester(const int semester) {
        this->semester = semester;
    }
};

auto semesterToString(int semester) -> std::string {
    switch (semester) {
        case 1: return "First";
        case 2: return "Second";
        case 3: return "Third";
        case 4: return "Fourth";
        default: return "Unknown";
    }
}

auto format_as(const Student& student) {
    return std::vector<std::string>{
        student.getFirstName(),
        student.getLastName(),
        student.getStudentNumber(),
        semesterToString(student.getSemester())
    };
}

enum class StudentProperty {
    FirstName, LastName, Index, Semester
};

auto hasGraphCycle(std::map<std::string, std::set<std::string>> graph) -> bool;
auto groupWordsByTextLength() -> void;
auto checkWhetherAllStudentsAreInTheSameSemester(std::vector<Student> const& students) -> void {
    auto const firstStudentSemester = students.at(0).getSemester();

    for (auto const& student : students) {
        if (student.getSemester() != firstStudentSemester) {
            fmt::println("Not all students are in the same semester!");
            return;
        }
    }

    fmt::println("All students are in the same semester!");
}
auto sortStudents(std::vector<Student>& students, const StudentProperty property) -> void {
    switch (property) {
        case StudentProperty::FirstName: {
            std::ranges::sort(students, {}, [](const Student& student) {
               return student.getFirstName();
            });
        } break;

        case StudentProperty::LastName: {
            std::ranges::sort(students, {}, [](const Student& student) {
                return student.getLastName();
            });
        } break;

        case StudentProperty::Index: {
            std::ranges::sort(students, {}, [](const Student& student) {
                return student.getStudentNumber();
            });
        } break;

        case StudentProperty::Semester: {
            std::ranges::sort(students, {}, [](const Student& student) {
                return student.getSemester();
            });
        } break;

        default: fmt::println("Invalid value of student property!");
    }
}

auto main() -> int {

    auto choice = -1;

    while (choice < 0 || choice > 4) {
        fmt::println("[0] Generic improvement of standard library");
        fmt::println("[1] Group words by text length");
        fmt::println("[2] Student group analysis");
        fmt::println("[3] Points in 2D space");
        fmt::print("Choose program: ");
        std::cin >> choice;
    }

    fmt::println("");

    switch (choice) {
        case 0: {
            auto graph = std::map<std::string, std::set<std::string>>();
            graph["A"] = {"B", "C"};
            graph["B"] = {"E"};
            graph["C"] = {"D"};
            graph["D"] = {"B"};
            graph["E"] = {"C"};

            fmt::println("Has graph cycle: {}", hasGraphCycle(graph));
        } break;

        case 1: {
            groupWordsByTextLength();
        } break;

        case 2: {
            auto students = std::vector<Student>{
                Student{"Wiktor", "Chudy", "s11111", 3},
                Student{"Jan", "Ptak", "s52341", 3},
                Student{"Mikolaj", "Lewandowski", "s42361", 4}
            };

            checkWhetherAllStudentsAreInTheSameSemester(students);

            fmt::println("{}", students);
            sortStudents(students, StudentProperty::FirstName);
            fmt::println("{}", students);
            sortStudents(students, StudentProperty::LastName);
            fmt::println("{}", students);
            sortStudents(students, StudentProperty::Index);
            fmt::println("{}", students);
            sortStudents(students, StudentProperty::Semester);
            fmt::println("{}", students);
        } break;

        case 3: {
            auto point1 = Point(5, 5);
            auto point2 = Point(1, 1);

            point1.printCoordinates();
            point2.printCoordinates();

            fmt::println("{}", point1.getDistanceFrom(point2));
            fmt::println("{}", point2.getDistanceFrom(point1));

            point1.changeCoordinatesTo(4, 1);
            point1.printCoordinates();
        } break;

        default: fmt::println("Invalid input!");
    }
    return 0;
}
