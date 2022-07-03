package lc_36;

import java.util.HashMap;

/**
 * @author 黄豪
 *36. 有效的数独
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


上图是一个部分填充的有效的数独。

数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class LC_36 {

}

class Solution {
	public boolean isValidSudoku(char[][] board) {
		// init data
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer>[] rows = new HashMap[9];
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer>[] columns = new HashMap[9];
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer>[] boxes = new HashMap[9];
		for (int i = 0; i < 9; i++) {
			rows[i] = new HashMap<Integer, Integer>();
			columns[i] = new HashMap<Integer, Integer>();
			boxes[i] = new HashMap<Integer, Integer>();
		}

		// validate a board
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char num = board[i][j];
				if (num != '.') {
					int n = (int) num;
					int box_index = (i / 3) * 3 + j / 3;

					// keep the current cell value
					rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
					columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
					boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

					// check if this value has been already seen before
					if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
						return false;
				}
			}
		}

		return true;
	}
}
