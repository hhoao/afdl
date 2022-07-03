package lc_1185;
import java.time.LocalDate;

/*
 *@author: 黄豪
 *@date : 2022年1月3日
 *@todo:1185. 一周中的第几天
给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。

输入为三个整数：day、month 和 year，分别表示日、月、年。

您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
*/
public class LC_1185 {

}
//调用API


class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        String str = date.getDayOfWeek().toString();
        return str.charAt(0) + str.substring(1, str.length()).toLowerCase();
    }
}
//官方模拟
class Solution1 {
  public String dayOfTheWeek(int day, int month, int year) {
      String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
      int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
      /* 输入年份之前的年份的天数贡献 */
      int days = 365 * (year - 1971) + (year - 1969) / 4;
      /* 输入年份中，输入月份之前的月份的天数贡献 */
      for (int i = 0; i < month - 1; ++i) {
          days += monthDays[i];
      }
      if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
          days += 1;
      }
      /* 输入月份中的天数贡献 */
      days += day;
      return week[(days + 3) % 7];
  }
}