package lc_190;

/**
 * @author 黄豪
 *190. 颠倒二进制位
颠倒给定的 32 位无符号整数的二进制位。

 

提示：

请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 

进阶:
如果多次调用这个函数，你将如何优化你的算法？
 */
public class LC_190 {

}
class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 1; i <= 32; i++){
            rev |= (1 & n ) << (32 - i);
            n = n >> 1;
        }
        return rev;
    }
}
class Solution1 {
    public int reverseBits(int n) {
        int ret=0;
        int m=0;
        while(m!=32){//循环32次
            if((n&1)==0)ret=ret*2;//判断最后一位是0还是1
            else ret=ret*2+1;
            n=n>>1;//将n右移
            m++;//记录循环次数
        }
        return ret;
    }
}
//位运算分治
class Solution2 {
	private int M1 = 0x55555555;
	private int M2 = 0x33333333;
	private int M4 = 0x0f0f0f0f;
	private int M8 = 0x00ff00ff;
	public int reverseBits(int n) {
		n = n >>> 1 & M1 | (n & M1) << 1;
		n = n >>> 2 & M2 | (n & M2) << 2;
		n = n >>> 4 & M4 | (n & M4) << 4;
		n = n >>> 8 & M8 | (n & M8) << 8;
		return n >>> 16 | n << 16;
	}
}
