cmake_minimum_required(VERSION 3.29)
project(PJC_2)

set(CMAKE_CXX_STANDARD 20)

include(FetchContent)

FetchContent_Declare(
        fmt
        GIT_REPOSITORY https://github.com/fmtlib/fmt
        GIT_TAG 11.0.2
)

FetchContent_MakeAvailable(fmt)

add_executable(PJC_2 main.cpp 1.cpp 2.cpp 3.cpp 4.cpp 5.cpp 6.cpp 7.cpp)
target_link_libraries(PJC_2 fmt)