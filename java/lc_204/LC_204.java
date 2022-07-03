package lc_204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_204 {

}
//方法二：埃氏筛
class Solution {
    public int countPrimes(int n) {
        int res = 0;
        int[] isPrimes = new int[n];
        Arrays.fill(isPrimes, 1);
        for (int i = 2; i < n; i++) {
        	if (isPrimes[i] == 1) {
        		res++;
        		if ((long)(i * i) < n) {
	        		for (int j = i * i;j < n; j += i) {
	        			isPrimes[j] = 0;
	        		}
        		}
        	}
        }
        return res;
    }
}
//线性筛选
class Solution1{
	public int countPrimes(int n) {
		List<Integer> primes = new ArrayList<>();
		int[] isPrimes = new int[n];
		Arrays.fill(isPrimes, 1);
		for (int i = 2; i < n; i++) {
			if (isPrimes[i] == 1) {
				primes.add(i);
			}
			for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
				isPrimes[i * primes.get(j)] = 0;
				if (i % primes.get(j) == 0) {
					break;
				}
			}
		}
		return primes.size();
	}
}