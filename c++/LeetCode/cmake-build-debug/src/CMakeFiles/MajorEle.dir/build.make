# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.22

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/hhoa/hhoa/algorithm/c++/LeetCode

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug

# Include any dependencies generated for this target.
include src/CMakeFiles/MajorEle.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include src/CMakeFiles/MajorEle.dir/compiler_depend.make

# Include the progress variables for this target.
include src/CMakeFiles/MajorEle.dir/progress.make

# Include the compile flags for this target's objects.
include src/CMakeFiles/MajorEle.dir/flags.make

src/CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.o: src/CMakeFiles/MajorEle.dir/flags.make
src/CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.o: ../src/LCOF/03-数组中重复的数字/Solution.cpp
src/CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.o: src/CMakeFiles/MajorEle.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object src/CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.o"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT src/CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.o -MF CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.o.d -o CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.o -c /home/hhoa/hhoa/algorithm/c++/LeetCode/src/LCOF/03-数组中重复的数字/Solution.cpp

src/CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.i"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/hhoa/hhoa/algorithm/c++/LeetCode/src/LCOF/03-数组中重复的数字/Solution.cpp > CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.i

src/CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.s"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/hhoa/hhoa/algorithm/c++/LeetCode/src/LCOF/03-数组中重复的数字/Solution.cpp -o CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.s

# Object files for target MajorEle
MajorEle_OBJECTS = \
"CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.o"

# External object files for target MajorEle
MajorEle_EXTERNAL_OBJECTS =

src/libMajorEle.a: src/CMakeFiles/MajorEle.dir/LCOF/03-数组中重复的数字/Solution.cpp.o
src/libMajorEle.a: src/CMakeFiles/MajorEle.dir/build.make
src/libMajorEle.a: src/CMakeFiles/MajorEle.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX static library libMajorEle.a"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && $(CMAKE_COMMAND) -P CMakeFiles/MajorEle.dir/cmake_clean_target.cmake
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/MajorEle.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
src/CMakeFiles/MajorEle.dir/build: src/libMajorEle.a
.PHONY : src/CMakeFiles/MajorEle.dir/build

src/CMakeFiles/MajorEle.dir/clean:
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && $(CMAKE_COMMAND) -P CMakeFiles/MajorEle.dir/cmake_clean.cmake
.PHONY : src/CMakeFiles/MajorEle.dir/clean

src/CMakeFiles/MajorEle.dir/depend:
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/hhoa/hhoa/algorithm/c++/LeetCode /home/hhoa/hhoa/algorithm/c++/LeetCode/src /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src/CMakeFiles/MajorEle.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : src/CMakeFiles/MajorEle.dir/depend

