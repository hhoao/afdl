package lc_273;

import java.util.TreeMap;

/*
 *@author: 黄豪
 *@date : 2021年5月3日
 *@todo:273. 整数转换英文表示
将非负整数 num 转换为其对应的英文表示。
*/
public class LC_273 {

}
//我的代码
class Solution {
    TreeMap<Integer, String> tM = new TreeMap<>(){
        {
            put(1000000000, "Billion");
            put(1000000, "Million");
            put(1000, "Thousand");
            put(100, "Hundred");
            put(90, "Ninety");
            put(80, "Eighty");
            put(70, "Seventy");
            put(60, "Sixty");
            put(50, "Fifty");
            put(40, "Forty");
            put(30, "Thirty");
            put(20, "Twenty");
            put(19, "Nineteen");
            put(18, "Eighteen");
            put(17, "Seventeen");
            put(16, "Sixteen");
            put(15, "Fifteen");
            put(14, "Fourteen");
            put(13, "Thirteen");
            put(12, "Twelve");
            put(11, "Eleven");
            put(10, "Ten");
            put(9, "Nine");
            put(8, "Eight");
            put(7, "Seven");
            put(6, "Six");
            put(5, "Five");
            put(4, "Four");
            put(3, "Three");
            put(2, "Two");
            put(1, "One");
        }
    };
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuffer sbf = new StringBuffer();
        getDiv(num, sbf);
        return sbf.deleteCharAt(sbf.length() - 1).toString();
    }
    
    public void getDiv(int num, StringBuffer sbf){
        if (num < 10) {
            sbf.append(tM.get(num) + " ");
            return;
        }
        while (num > 0){
            int key = tM.floorKey(num);
            int n = num / key;
            if (num >= 100) getDiv(n, sbf);
            num = num % key;
            sbf.append(tM.get(key) + " ");
        }
    }
}
//官方
class Solution1 {
    public String one(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    public String twoLessThan20(int num) {
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }

    public String ten(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    public String two(int num) {
        if (num == 0)
            return "";
        else if (num < 10)
            return one(num);
        else if (num < 20)
            return twoLessThan20(num);
        else {
            int tenner = num / 10;
            int rest = num - tenner * 10;
            if (rest != 0)
              return ten(tenner) + " " + one(rest);
            else
              return ten(tenner);
        }
    }

    public String three(int num) {
        int hundred = num / 100;
        int rest = num - hundred * 100;
        String res = "";
        if (hundred * rest != 0)
            res = one(hundred) + " Hundred " + two(rest);
        else if ((hundred == 0) && (rest != 0))
            res = two(rest);
        else if ((hundred != 0) && (rest == 0))
            res = one(hundred) + " Hundred";
        return res;
    }

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        String result = "";
        if (billion != 0)
            result = three(billion) + " Billion";
        if (million != 0) {
            if (! result.isEmpty())
                result += " ";
            result += three(million) + " Million";
        }
        if (thousand != 0) {
            if (! result.isEmpty())
                result += " ";
            result += three(thousand) + " Thousand";
        }
        if (rest != 0) {
            if (! result.isEmpty())
                result += " ";
            result += three(rest);
        }
        return result;
    }
}