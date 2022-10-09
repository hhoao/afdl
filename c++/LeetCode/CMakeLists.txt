cmake_minimum_required(VERSION 3.18)
project(LeetCode)

# 文件规范: 必须以all/或者lcof/开头后面接题目号最后接题目, 例如 lcof/03_duplicate_numbers_in_array和all/310_minimum_height_trees
# 测试文件名字必须为test.cpp、题目文件必须为Solution.cpp 和 Solution.h
list(APPEND source_dirs "src/all;src/lcof")

SET(include_directory_names "")
include_directories(include)
foreach (source_dir IN LISTS source_dirs)
    file(GLOB sub_dir ${source_dir}/*)
    list(APPEND dir_list ${source_dir})
    get_filename_component(lib_we "${dir_list}" NAME_WE)
    foreach (sub_dir_file_path IN LISTS sub_dir)
        get_filename_component(sub_dir_file_name "${sub_dir_file_path}" NAME)
        list(APPEND include_directory_names ${lib_we}/${sub_dir_file_name})
    endforeach ()
endforeach ()

foreach (name IN LISTS include_directory_names)
    string(REGEX MATCH "^((all)|(lcof))/[0-9]*" name ${name})
    string(REPLACE "/" "_" name ${name})
    list(APPEND library_names ${name})
endforeach ()

enable_testing()
add_subdirectory(src)
add_subdirectory(test)