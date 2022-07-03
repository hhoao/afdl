package lc_788;

/*
 *@author: 黄豪
 *@date : 2021年9月18日
 *@todo:
 *788. 旋转数字
我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。

如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。

现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
*/
public class LC_788 {

}
class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        int[][] rotated;
        if (n < 10){
            rotated = new int[10][2];
        }else{
            rotated = new int[n + 1][2];
        }
        rotated[0][0] = 0;
        rotated[0][1] = 1;
        rotated[1][0] = 1;
        rotated[1][1] = 1;
        rotated[8][0] = 8;
        rotated[8][1] = 1;
        rotated[5][0] = 2;
        rotated[5][1] = 2;
        rotated[2][0] = 5;
        rotated[2][1] = 2;
        rotated[6][0] = 9;
        rotated[6][1] = 2;
        rotated[9][0] = 6;
        rotated[9][1] = 2;
        for (int i = 0; i <= n; i++){
            int k = 1;
            while (i / k >= 10){
                k *= 10;
            }
            int div = i / k, remain = i % k;
            int state1 = rotated[div][1], state2 = rotated[remain][1];
            if (state1 == 0 || state2 == 0){
                continue;
            }
            if (state1 == 2 || state2 == 2){
                rotated[i][1] = 2;
                ans++;
            }else{
                rotated[i][1] = 1;
            }
            rotated[i][0] = rotated[remain][0] * k + rotated[div][0];
        }
        return ans;
    }
}
//官方(动态规划)
class Solution1 {
    public int rotatedDigits(int N) {
        char[] A = String.valueOf(N).toCharArray();
        int K = A.length;

        int[][][] memo = new int[K+1][2][2];
        memo[K][0][1] = memo[K][1][1] = 1;
        for (int i = K - 1; i >= 0; --i) {	
            for (int eqf = 0; eqf <= 1; ++eqf)
                for (int invf = 0; invf <= 1; ++invf) {
                    int ans = 0;
                    for (char d = '0'; d <= (eqf == 1 ? A[i] : '9'); ++d) {
                        if (d == '3' || d == '4' || d == '7') continue;
                        boolean invo = (d == '2' || d == '5' || d == '6' || d == '9');
                        ans += memo[i+1][d == A[i] ? eqf : 0][invo ? 1 : invf];
                    }
                    memo[i][eqf][invf] = ans;
                }
        }

        return memo[0][1][0];
    }

}
