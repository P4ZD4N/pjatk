cmake_minimum_required(VERSION 3.29)
project(PJC_5)

set(CMAKE_CXX_STANDARD 20)

include(FetchContent)

FetchContent_Declare(
        fmt
        GIT_REPOSITORY https://github.com/fmtlib/fmt.git
        GIT_TAG 11.0.2
)

FetchContent_MakeAvailable(fmt)

add_executable(PJC_5 main.cpp
        1.cpp
        2.cpp)
target_link_libraries(PJC_5 fmt)
