#!/bin/bash

# 345. 反转字符串中的元音字母
# 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
# 
# 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。

read -p "请输入一个字符串: " str
echo "输入的字符串为: $str"

vowels=(a e i o u)

hasVowel() {
    local c=$1
    for vowel in ${vowels[@]}
    do
        if [ $c == $vowel ]   
        then
            _ret=true
            break
        else
            _ret=false
        fi
    done
}
# 双指针
reverseVowels(){
    n=${#str}
    for (( l=0, r=$((n-1)); l<=r; l++));
    do
        local lval=${str:$l:1}
        hasVowel $lval
        if [ $_ret == true ]
        then
            while [ $r -gt $l ]
            do
                hasVowel ${str:$r:1}
                if [ $_ret == true ] 
                then
                    str=${str:0:$l}${str:$r:1}${str:$(($l+1)):$(($r-$l-1))}${str:$l:1}${str:$((r+1))}
                    r=$(($r-1))
                    break
                fi
                r=$(($r-1))
            done
        fi
    done
}

reverseVowels
echo "反转元音字母后为: ${str[@]}"
