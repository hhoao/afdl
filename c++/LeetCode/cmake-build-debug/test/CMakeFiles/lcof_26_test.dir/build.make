# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.24

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
include test/CMakeFiles/lcof_26_test.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include test/CMakeFiles/lcof_26_test.dir/compiler_depend.make

# Include the progress variables for this target.
include test/CMakeFiles/lcof_26_test.dir/progress.make

# Include the compile flags for this target's objects.
include test/CMakeFiles/lcof_26_test.dir/flags.make

test/CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.o: test/CMakeFiles/lcof_26_test.dir/flags.make
test/CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.o: /home/hhoa/hhoa/algorithm/c++/LeetCode/test/lcof/26_is_tree_sub_structure/test.cpp
test/CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.o: test/CMakeFiles/lcof_26_test.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object test/CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.o"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/test && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT test/CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.o -MF CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.o.d -o CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.o -c /home/hhoa/hhoa/algorithm/c++/LeetCode/test/lcof/26_is_tree_sub_structure/test.cpp

test/CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.i"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/test && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/hhoa/hhoa/algorithm/c++/LeetCode/test/lcof/26_is_tree_sub_structure/test.cpp > CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.i

test/CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.s"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/test && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/hhoa/hhoa/algorithm/c++/LeetCode/test/lcof/26_is_tree_sub_structure/test.cpp -o CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.s

# Object files for target lcof_26_test
lcof_26_test_OBJECTS = \
"CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.o"

# External object files for target lcof_26_test
lcof_26_test_EXTERNAL_OBJECTS =

test/lcof_26_test: test/CMakeFiles/lcof_26_test.dir/lcof/26_is_tree_sub_structure/test.cpp.o
test/lcof_26_test: test/CMakeFiles/lcof_26_test.dir/build.make
test/lcof_26_test: src/liblcof_26.a
test/lcof_26_test: test/CMakeFiles/lcof_26_test.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable lcof_26_test"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/test && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/lcof_26_test.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
test/CMakeFiles/lcof_26_test.dir/build: test/lcof_26_test
.PHONY : test/CMakeFiles/lcof_26_test.dir/build

test/CMakeFiles/lcof_26_test.dir/clean:
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/test && $(CMAKE_COMMAND) -P CMakeFiles/lcof_26_test.dir/cmake_clean.cmake
.PHONY : test/CMakeFiles/lcof_26_test.dir/clean

test/CMakeFiles/lcof_26_test.dir/depend:
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/hhoa/hhoa/algorithm/c++/LeetCode /home/hhoa/hhoa/algorithm/c++/LeetCode/test /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/test /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/test/CMakeFiles/lcof_26_test.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : test/CMakeFiles/lcof_26_test.dir/depend

