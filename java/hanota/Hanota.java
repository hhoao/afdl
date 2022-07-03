package hanota;

import java.io.IOException;
import java.util.Stack;

/**
 * @author »ÆºÀ
 *ººÅµËþ2020Äê12ÔÂ28ÈÕ13:03:19
 */
public class Hanota {
	public static int count = 0;
	public static void main(String[] args) throws IOException {
		Solution s = new Solution();
		Stack<Integer> a = new Stack<Integer>();
		Stack<Integer> b = new Stack<Integer>();
		Stack<Integer> c = new Stack<Integer>();
		for (int i = 5; i>= 1; i--) {
			a.add(i);
		}
		
		s.move(a.size(), a, b, c);
		for (Integer i : c) {
			System.out.println(i);
			
		}
		System.out.println(count);
	}
	public static class Solution{
		public void move(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
			if (n == 0) {
				return ;
			}
			move(n - 1, a, c, b);
			count++;
			c.push(a.pop());
			move(n-1, b, a, c);
		}
	}
}
