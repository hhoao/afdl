package lc_191;

public class LC_191 {

}
class Solution1{
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++){
            cnt += n & 1;
            n = n >>> 1;
        }
        return cnt;
    }
}
class Solution2 {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
class Solution3 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        n=(n&0x55555555)+(n>>>1&0x55555555);
        n=(n&0x33333333)+(n>>>2&0x33333333);
        n=(n&0x0F0F0F0F)+(n>>>4&0x0F0F0F0F);
        n=(n*0x01010101)>>24;
        return n;
    }
}