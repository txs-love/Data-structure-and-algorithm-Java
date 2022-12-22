package org.LeetCode;

/**
 * @author Sherry
 * @date 2022/12/17 21:19
 */
import java.util.ArrayList;
import java.util.List;
/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
   string convert(string s, int numRows);


 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"

 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 解释：
  P     I    N
  A   L S  I G
  Y A   H R
  P     I

 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"

 */
public class Code6 {
    public static void main(String[] args) {
        Code6 code = new Code6();
        String ans = code.convert("PAYPALISHIRING",3);
        System.out.println(ans);
    }

    //利用List容器创建StringBuilder来反转字符串;——> 通过flag来反转元素; 当中flag满足该元素的时候进行反转
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++)
            rows.add(new StringBuilder());
        int i = 0, flag = -1;    //将flag=numRows的时候进行换行
        for(char c : s.toCharArray()) {  //通过字符串添加到容器当中
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1)
                flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}


