cmake_minimum_required(VERSION 3.29)
project(PJC_6)

set(CMAKE_CXX_STANDARD 20)

include(FetchContent)

FetchContent_Declare(
        fmt
        GIT_REPOSITORY https://github.com/fmtlib/fmt.git
        GIT_TAG 11.0.2
)

FetchContent_MakeAvailable(fmt)

add_executable(PJC_6 main.cpp
        1.cpp
        2.cpp
        3.cpp)
target_link_libraries(PJC_6 fmt)
