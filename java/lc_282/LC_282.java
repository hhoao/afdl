package lc_282;

import java.util.ArrayList;
import java.util.List;

/*
 *@author: 黄豪
 *@date : 2021年5月5日
 *@todo:282. 给表达式添加运算符
给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
*/
public class LC_282 {

}

class Solution {

	public ArrayList<String> answer;
	public String digits;
	public long target;

	public void recurse(int index, long previousOperand, long currentOperand, long value, ArrayList<String> ops) {
		String nums = this.digits;

		// Done processing all the digits in num
		if (index == nums.length()) {

			// If the final value == target expected AND
			// no operand is left unprocessed
			if (value == this.target && currentOperand == 0) {
				StringBuilder sb = new StringBuilder();
				ops.subList(1, ops.size()).forEach(v -> sb.append(v));
				this.answer.add(sb.toString());
			}
			return;
		}

		// Extending the current operand by one digit
		currentOperand = currentOperand * 10 + Character.getNumericValue(nums.charAt(index));
		String current_val_rep = Long.toString(currentOperand);
		int length = nums.length();

		// To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
		// valid operand. Hence this check
		if (currentOperand > 0) {

			// NO OP recursion
			recurse(index + 1, previousOperand, currentOperand, value, ops);
		}

		// ADDITION
		ops.add("+");
		ops.add(current_val_rep);
		recurse(index + 1, currentOperand, 0, value + currentOperand, ops);
		ops.remove(ops.size() - 1);
		ops.remove(ops.size() - 1);

		if (ops.size() > 0) {
			// SUBTRACTION
			ops.add("-");
			ops.add(current_val_rep);
			recurse(index + 1, -currentOperand, 0, value - currentOperand, ops);
			ops.remove(ops.size() - 1);
			ops.remove(ops.size() - 1);

			// MULTIPLICATION
			ops.add("*");
			ops.add(current_val_rep);
			recurse(index + 1, currentOperand * previousOperand, 0,
					value - previousOperand + (currentOperand * previousOperand), ops);
			ops.remove(ops.size() - 1);
			ops.remove(ops.size() - 1);
		}
	}

	public List<String> addOperators(String num, int target) {
		if (num.length() == 0) {
			return new ArrayList<String>();
		}

		this.target = target;
		this.digits = num;
		this.answer = new ArrayList<String>();
		this.recurse(0, 0, 0, 0, new ArrayList<String>());
		return this.answer;
	}
}
