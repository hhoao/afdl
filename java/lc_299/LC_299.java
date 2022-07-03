package lc_299;

/*
 *@author: 黄豪
 *@date : 2021年5月9日
 *@todo:299. 猜数字游戏
你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：

你写出一个秘密数字，并请朋友猜这个数字是多少。
朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
朋友根据提示继续猜，直到猜出秘密数字。
请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。

xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
*/
public class LC_299 {

}
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++){
            if (secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }else{
                count[secret.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < secret.length(); i++){
            int j = guess.charAt(i) - '0';
            int k = secret.charAt(i) - '0';
            if (count[j] != 0 && j != k){
                cows++;
                count[j]--;
            }
        }
        return bulls + "A"+cows+"B";
    }
}