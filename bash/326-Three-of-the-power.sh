#!/bin/bash
# 326. 3 的幂
# 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
# 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x

ret=0
read -p "请输入一个整数n: " n
echo "整数n为: $n"

isPowerOfThree1(){
    if [ ! $n ]
    then
        echo "请输入一个整数!"
        exit -1
    fi
    
    if [ $n -gt 0 ] && [ $((1162261467 % $n )) -eq 0 ]
    then
        ret=true
    else
        ret=false
    fi
}
isPowerOfThree(){
    local power=0;
    local base=3;
    local k=3;
    while [ $k -lt $n ];
    do
        let "k*=base"
    done
    if [ $k -eq $n ];
    then
        return 0;
    fi
    return 1;
}

isPowerOfThree1 $1;
echo $ret

