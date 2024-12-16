package lc_274;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��5��3��
 *@todo:274. H ָ��
����һλ�о������ı����ô��������飨�����ô����ǷǸ�����������дһ��������������о��ߵ� h ָ����

h ָ���Ķ��壺h ���������ô�������high citations����һ��������Ա�� h ָ����ָ���������� ��N ƪ�����У��ܹ��� h ƪ���ķֱ����������� h �Ρ�������� N - h ƪ����ÿƪ�����ô��� ������ h �Ρ�

���磺ĳ�˵� h ָ���� 20�����ʾ���ѷ���������У�ÿƪ������������ 20 �ε������ܹ��� 20 ƪ��
*/
public class LC_274 {

}
//�ҵĴ���
class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        Arrays.sort(citations);
        int n = 0;
        int i = citations.length - 1;
        while (i >= 0 &&n < citations[i]){
            n++;
            i--;
        }
        return n;
    }
}

class Solution1 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (citations[mid] > n - mid - 1) {
                r = mid;
            } else if (citations[mid] < n - mid - 1) {
                l = mid + 1;
            } else {
                return n - mid - 1;
            }
        }
        return citations[l] >= n - l ? n - l : n - l - 1;
    }
}
