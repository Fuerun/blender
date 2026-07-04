name=android/example-app/app/src/main/cpp/CMakeLists.txt
cmake_minimum_required(VERSION 3.10)
project(native-lib)

add_library(native-lib SHARED native-lib.cpp)

find_library(log-lib log)

target_link_libraries(native-lib ${log-lib})
