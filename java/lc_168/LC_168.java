package lc_168;

public class LC_168 {

}
//ÎÒµÄ´úÂë
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuffer sbu = new StringBuffer();
        while (columnNumber > 0){
            int remainder = columnNumber % 26;
            int consult = remainder == 0 ? columnNumber / 26 -  1 : columnNumber / 26;
            remainder = remainder == 0 ? 26 : remainder;
            sbu.append((char)(remainder + 64));
            columnNumber = consult;
        }
        return sbu.reverse().toString();
    }
}	
