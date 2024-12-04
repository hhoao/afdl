package lc_93;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄豪
 *93. 复原 IP 地址
给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。

有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 */
public class LC_93 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> list = solution.restoreIpAddresses("101023");
		for (String str : list) {
			System.out.println(str);
		}
	}
}
//回溯
class Solution {
	int ADDRESS_POINT = 4;
    public List<String> restoreIpAddresses(String s) {
    	List<String> ans = new ArrayList<String>();
    	dfs(s, ans, new StringBuffer(),0, 0 );
    	return ans;
    }
    public void dfs(String s, List<String> ans, StringBuffer stb, int n, int size) {
    	if (size == s.length() && n == ADDRESS_POINT) {
    		StringBuffer subans = new StringBuffer(stb);
    		ans.add(subans.deleteCharAt(subans.length()-1).toString());
    		return ;
    	}
    	if (n >= ADDRESS_POINT) {
    		return;
    	}
    	for (int i = 1; i <= ADDRESS_POINT - 1 ; i++) {
    		if (size + i > s.length()) return;
    		String subs = s.substring(size, size + i);
    		int val = Integer.valueOf(subs);
    		if (subs.charAt(0) == '0' && subs.length() > 1) continue;
    		if (val <= 255) {
    			stb.append(subs + '.');
    			dfs(s, ans, stb, n + 1, size + i);
    			stb.delete(stb.length() - subs.length() - 1, stb.length());
    		}
    	}
    }
}
//官方
class Solution1 {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
