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
CMAKE_SOURCE_DIR = /home/hhoa/hhoa/algorithm/c++/data_structure

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/hhoa/hhoa/algorithm/c++/data_structure/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/deque.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/deque.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/deque.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/deque.dir/flags.make

CMakeFiles/deque.dir/src/deque.cpp.o: CMakeFiles/deque.dir/flags.make
CMakeFiles/deque.dir/src/deque.cpp.o: ../src/deque.cpp
CMakeFiles/deque.dir/src/deque.cpp.o: CMakeFiles/deque.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/hhoa/hhoa/algorithm/c++/data_structure/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/deque.dir/src/deque.cpp.o"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/deque.dir/src/deque.cpp.o -MF CMakeFiles/deque.dir/src/deque.cpp.o.d -o CMakeFiles/deque.dir/src/deque.cpp.o -c /home/hhoa/hhoa/algorithm/c++/data_structure/src/deque.cpp

CMakeFiles/deque.dir/src/deque.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/deque.dir/src/deque.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/hhoa/hhoa/algorithm/c++/data_structure/src/deque.cpp > CMakeFiles/deque.dir/src/deque.cpp.i

CMakeFiles/deque.dir/src/deque.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/deque.dir/src/deque.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/hhoa/hhoa/algorithm/c++/data_structure/src/deque.cpp -o CMakeFiles/deque.dir/src/deque.cpp.s

# Object files for target deque
deque_OBJECTS = \
"CMakeFiles/deque.dir/src/deque.cpp.o"

# External object files for target deque
deque_EXTERNAL_OBJECTS =

libdeque.a: CMakeFiles/deque.dir/src/deque.cpp.o
libdeque.a: CMakeFiles/deque.dir/build.make
libdeque.a: CMakeFiles/deque.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/hhoa/hhoa/algorithm/c++/data_structure/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX static library libdeque.a"
	$(CMAKE_COMMAND) -P CMakeFiles/deque.dir/cmake_clean_target.cmake
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/deque.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/deque.dir/build: libdeque.a
.PHONY : CMakeFiles/deque.dir/build

CMakeFiles/deque.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/deque.dir/cmake_clean.cmake
.PHONY : CMakeFiles/deque.dir/clean

CMakeFiles/deque.dir/depend:
	cd /home/hhoa/hhoa/algorithm/c++/data_structure/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/hhoa/hhoa/algorithm/c++/data_structure /home/hhoa/hhoa/algorithm/c++/data_structure /home/hhoa/hhoa/algorithm/c++/data_structure/cmake-build-debug /home/hhoa/hhoa/algorithm/c++/data_structure/cmake-build-debug /home/hhoa/hhoa/algorithm/c++/data_structure/cmake-build-debug/CMakeFiles/deque.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/deque.dir/depend
