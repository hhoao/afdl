package lc_38;

import java.util.Stack;

/**
 * @author 黄豪
 *38. 外观数列
给定一个正整数 n ，输出外观数列的第 n 项。

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。

你可以将其视作是由递归公式定义的数字字符串序列：

countAndSay(1) = "1"
countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
第一项是数字 1 
描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。

例如，数字字符串 "3322251" 的描述如下图：
 */
public class LC_38 {
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.countAndSay(3));
	}
}
//我的垃圾递归
class Solution{
    public String countAndSay(int n) {
       // if (n == 1){
         //   return "" + 1;
        //}
        return desBefo(n-1);
    }
    public String desBefo(int num) {
		if (num == 0) {
			return "1";
		}
		String result = desBefo(num-1);
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i< result.length();i++) {
			stack.push(result.substring(i, i+1));
		}
		Stack<String> s = searchCom(stack);
		String temp_num = "";
		while(s.size() >0) {
			String n = s.pop();
			temp_num += n;
			
		}
		return temp_num;
	}
	public Stack<String> searchCom(Stack<String> stack) {//111221
		Stack<String> s = new Stack<String>();//312211
		int cnt = 0;
		String bef_num = stack.peek();
		while(stack.size() > 0 ) {
			String com_num = stack.pop();
			if (com_num.equals(bef_num)) {
				cnt++;
			}else {
				s.push(bef_num);
				s.push(cnt+"");
				cnt = 1;
			}
			if (stack.size() == 0) {
				s.push(com_num);
				s.push(cnt+"");
			}
			bef_num = com_num;
		}
		return s;
	}
}
class Solution2 {
    public String countAndSay(int n) {
        StringBuffer pre = new StringBuffer("1");
        StringBuffer cur = new StringBuffer("1");
        for(int i=1;i<n;i++){
            pre = cur;
            cur = new StringBuffer();
            int start =0,end = 0;
            //开始遍历前一项，开始描述
            while(end<pre.length()){
                while(end<pre.length() && pre.charAt(start) ==pre.charAt(end)){
                    end++;
                }
                //元素出现次数与元素进行拼接
                cur = cur.append(Integer.toString(end-start)).append(pre.charAt(start));
                start = end;
            }

        }
        return cur.toString();
    }
}
class Solution3 {
    public String countAndSay(int n) {
        String last;
        if (n == 1) {
            return "1";
        } else {
            last = countAndSay(n - 1);
        }

        int length = 2;
        int currIndex = 1;
        //long value = 0;
        char prev = last.charAt(0); //表示当前的group的char

        while (currIndex < last.length()) {
            if (prev != last.charAt(currIndex)) {
                prev = last.charAt(currIndex);
                length += 2;
            }
            currIndex++;
        }

        char[] chars = new char[length];
        int group = 0;
        prev = last.charAt(0);
        chars[1] = prev;
        currIndex = 1;
        length = 1;
        while (currIndex < last.length()) {
            if (prev == last.charAt(currIndex)) {
                length++;
            } else {
                chars[2 * group] = ((char) (length + 48));
                chars[2 * group + 1] = prev;
                prev = last.charAt(currIndex);
                length = 1;
                group++;
            }
            currIndex++;
        }

        chars[2 * group] = ((char) (length + 48));
        chars[2 * group + 1] = prev;

        return new String(chars);
    }

}
