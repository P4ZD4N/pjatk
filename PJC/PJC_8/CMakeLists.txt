cmake_minimum_required(VERSION 3.30)
project(PJC_8)

set(CMAKE_CXX_STANDARD 20)

include(FetchContent)

FetchContent_Declare(
        fmt
        GIT_REPOSITORY https://github.com/fmtlib/fmt.git
        GIT_TAG 11.0.2
)

FetchContent_MakeAvailable(fmt)


add_executable(PJC_8 main.cpp
)
target_link_libraries(PJC_8 fmt)
