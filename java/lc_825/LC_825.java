package lc_825;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年12月27日
 *@todo:825. 适龄的朋友
在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。

如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：

age[y] <= 0.5 * age[x] + 7
age[y] > age[x]
age[y] > 100 && age[x] < 100
否则，x 将会向 y 发送一条好友请求。

注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。

返回在该社交媒体网站上产生的好友请求总数。
*/
public class LC_825 {

}
class Solution {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        int ans = 0;
        Arrays.sort(ages);
        for (int i = 0; i < n; i++){
            for (int j = i - 1; j >= 0; j--){
                if ((ages[i]+1) * 0.5 + 7 < ages[j]){
                    ans = ages[i] == ages[j] ? 2 : 1;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}
//双指针
class Solution1 {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        int ans = 0;
        Arrays.sort(ages);
        int left = 0, right = 0;
        for (int age : ages){
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7){
                left++;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                ++right;
            }
            ans += right - left;
        }
            
        return ans;
    }
}
//方法二：计数排序 + 前缀和
class Solution2 {
    public int numFriendRequests(int[] ages) {
        int[] cnt = new int[121];
        for (int age : ages) {
            ++cnt[age];
        }
        int[] pre = new int[121];
        for (int i = 1; i <= 120; ++i) {
            pre[i] = pre[i - 1] + cnt[i];
        }
        int ans = 0;
        for (int i = 15; i <= 120; ++i) {
            if (cnt[i] > 0) {
                int bound = (int) (i * 0.5 + 8);
                ans += cnt[i] * (pre[i] - pre[bound - 1] - 1);
            }
        }
        return ans;
    }
}
