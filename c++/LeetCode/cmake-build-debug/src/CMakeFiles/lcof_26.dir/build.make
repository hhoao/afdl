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
include src/CMakeFiles/lcof_26.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include src/CMakeFiles/lcof_26.dir/compiler_depend.make

# Include the progress variables for this target.
include src/CMakeFiles/lcof_26.dir/progress.make

# Include the compile flags for this target's objects.
include src/CMakeFiles/lcof_26.dir/flags.make

src/CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.o: src/CMakeFiles/lcof_26.dir/flags.make
src/CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.o: /home/hhoa/hhoa/algorithm/c++/LeetCode/src/lcof/26_is_tree_sub_structure/Solution.cpp
src/CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.o: src/CMakeFiles/lcof_26.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object src/CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.o"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT src/CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.o -MF CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.o.d -o CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.o -c /home/hhoa/hhoa/algorithm/c++/LeetCode/src/lcof/26_is_tree_sub_structure/Solution.cpp

src/CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.i"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/hhoa/hhoa/algorithm/c++/LeetCode/src/lcof/26_is_tree_sub_structure/Solution.cpp > CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.i

src/CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.s"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/hhoa/hhoa/algorithm/c++/LeetCode/src/lcof/26_is_tree_sub_structure/Solution.cpp -o CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.s

# Object files for target lcof_26
lcof_26_OBJECTS = \
"CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.o"

# External object files for target lcof_26
lcof_26_EXTERNAL_OBJECTS =

src/liblcof_26.a: src/CMakeFiles/lcof_26.dir/lcof/26_is_tree_sub_structure/Solution.cpp.o
src/liblcof_26.a: src/CMakeFiles/lcof_26.dir/build.make
src/liblcof_26.a: src/CMakeFiles/lcof_26.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX static library liblcof_26.a"
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && $(CMAKE_COMMAND) -P CMakeFiles/lcof_26.dir/cmake_clean_target.cmake
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/lcof_26.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
src/CMakeFiles/lcof_26.dir/build: src/liblcof_26.a
.PHONY : src/CMakeFiles/lcof_26.dir/build

src/CMakeFiles/lcof_26.dir/clean:
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src && $(CMAKE_COMMAND) -P CMakeFiles/lcof_26.dir/cmake_clean.cmake
.PHONY : src/CMakeFiles/lcof_26.dir/clean

src/CMakeFiles/lcof_26.dir/depend:
	cd /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/hhoa/hhoa/algorithm/c++/LeetCode /home/hhoa/hhoa/algorithm/c++/LeetCode/src /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src /home/hhoa/hhoa/algorithm/c++/LeetCode/cmake-build-debug/src/CMakeFiles/lcof_26.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : src/CMakeFiles/lcof_26.dir/depend

