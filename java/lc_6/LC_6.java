package lc_6;

import java.util.*;

/**
 * @author 黄豪
 *将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */
public class LC_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "rearsdfsdfasfd";
		Solution sl = new Solution();
		//for (char v : sl.convert(str, 3)) {
			//System.out.println(v);
		//}
		System.out.println(sl.convert(str, 3));
	}

}

class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
