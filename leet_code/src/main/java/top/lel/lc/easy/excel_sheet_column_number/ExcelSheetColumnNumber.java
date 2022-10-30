package top.lel.lc.easy.excel_sheet_column_number;

/**
 * @author echo lovely
 * @since 2022.9.7
 * @apiNote
 *          <p>
 *          excel表格列数...
 *          https://leetcode.cn/problems/excel-sheet-column-number/solution/
 *          </p>
 */
public class ExcelSheetColumnNumber {

    record R(int age, String name) {

        public static void hello() {
            System.out.println("hello, dd. u r only.");
        }

        public int char2Int(char param) {
            return param;
        }

        public int titleToNumber(String columnTitle) {
            var sum = 0;

            var l = columnTitle.length();
            int p = 0;
            for (int i = l - 1; i >= 0; i--) {
                var item = columnTitle.charAt(i);
                sum += (item - 'A' + 1) * Math.pow(26, p++);
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        var s = new R(1, "hh");
        System.out.println(s.titleToNumber("AB"));

        System.out.println(s.char2Int('A') + "\t" + s.char2Int('B'));
    }
}
