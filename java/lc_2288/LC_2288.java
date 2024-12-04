package lc_2288;

/**
 * LC_2288
 *
 * @author xianxing
 * @since 2024/6/18
 **/

//题目: [2288] 价格减免
//时间: 2024-06-18 22:49:21
//
//句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实
//数，那么这个单词就表示一个 价格 。
//
//
// 例如 "$100"、"$23" 和 "$6" 表示价格，而 "100"、"$" 和 "$1e5 不是。
//
//
// 给你一个字符串 sentence 表示一个句子和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新
// 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
//
// 返回表示修改后句子的字符串。
//
// 注意：所有价格 最多 为 10 位数字。
//
//
//
// 示例 1：
//
//
//输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
//输出："there are $0.50 $1.00 and 5$ candies in the shop"
//解释：
//表示价格的单词是 "$1" 和 "$2" 。
//- "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。
//- "$2" 减免 50% 为 "$1" ，所以 "$1" 替换为 "$1.00" 。
//
// 示例 2：
//
//
//输入：sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
//输出："1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
//解释：
//任何价格减免 100% 都会得到 0 。
//表示价格的单词分别是 "$3"、"$5"、"$6" 和 "$9"。
//每个单词都替换为 "$0.00"。
//
//
//
//
// 提示：
//
//
// 1 <= sentence.length <= 10⁵
// sentence 由小写英文字母、数字、' ' 和 '$' 组成
// sentence 不含前导和尾随空格
// sentence 的所有单词都用单个空格分隔
// 所有价格都是 正 整数且不含前导零
// 所有价格 最多 为 10 位数字
// 0 <= discount <= 100
//
//
// 👍 35 👎 0

public class LC_2288 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = solution.discountPrices("there are $1 $2 and 5$ candies in the shop", 50);
        String s = solution.discountPrices("there are $0 $1 $$2.. and $5$6 candies in the shop", 50);
//        String s = solution.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100);
        System.out.println(s);
    }
}

class Solution1 {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.charAt(0) == '$' && isNumeric(word.substring(1))) {
                double price = Long.parseLong(word.substring(1)) * (1 - discount / 100.0);
                words[i] = String.format("$%.2f", price);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(words[i]);
        }
        return sb.toString();
    }

    public boolean isNumeric(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public String discountPrices(String sentence, int discount) {
        double percentage = discount / 100.0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            while (i < sentence.length() - 1 && c == '$') {
                int begin = i, front = 0, lastIndex = -1;
                double back = 0.0;
                boolean lessOne = false, hasNum = false;
                res.append(c);
                i++;
                StringBuilder slip = new StringBuilder();
                while (i < sentence.length() - 1 &&
                    (((c = sentence.charAt(i)) == '.' && begin != i) || Character.isDigit(c))) {
                    if (c == '.') {
                        if (lessOne) {
                            if (lastIndex == i - 1) {
                                slip.append('.');
                            }
                            break;
                        } else {
                            lessOne = true;
                            lastIndex = i;
                        }
                    } else if (Character.isDigit(c)) {
                        hasNum = true;
                        if (lessOne) {
                            back = ((back / 10 + (c - '0') / 10.0));
                        } else {
                            double realV = (front * 10 + (c - '0'));
                            front = (int)realV;
                            back += realV - front;
                        }
                    }
                    i++;
                }
                c = sentence.charAt(i);
                if (hasNum) {
                    res.append(String.format("%.2f", (front + back) - (front + back) * percentage));
                }
                res.append(slip);
            }
            res.append(c);
        }
        return res.toString();
    }
}
