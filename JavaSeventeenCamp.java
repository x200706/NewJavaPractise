import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

class JavaSeventeenCamp {
  public void result() {
    System.out.println("areEqualByThreeDecimalPlaces:" + areEqualByThreeDecimalPlaces(0.1234, 0.1235));
    printYearsAndDays(50000);
  }

  /*
   * 編寫一個方法 areEqualByThreeDecimalPlaces，其中包含兩個 double 類型的參數。
   * 該方法應返回布爾值，如果兩個double相同（最多小數點后三位），則需要返回 true。否則，返回 false。
   */
  public boolean areEqualByThreeDecimalPlaces(double a, double b) {
    return Math.abs(a - b) < 0.001;
  }

  /*
   * 編寫一個方法 printYearsAndDays，其參數類型為 long，命名為 minutes。
   * 該方法不應返回任何內容 （void），並且需要根據minutes參數計算年和日。
   * 如果參數小於 0，則列印文字“無效值”。
   * 否則，如果參數有效，則需要以“XX min = YY y and ZZ d”格式列印消息。
   * XX 表示原始值分鐘。 YY 表示計算出的年份。 ZZ 表示計算出的天數。
   */
  public void printYearsAndDays(long minutes) {
    if (minutes < 0) {
      System.out.println("無效值");
    } else {
      long years = minutes / 525600;
      long days = minutes % 525600 / 1440;
      System.out.println(minutes + " min = " + years + " y and " + days + " d");
    }
  }

  // Java17 Switch表達式依舊只能匹配一個常量
  public void patternMatching() {
    // 作個偽Tuple（不可變的多類型數組）
    ArrayList<Object[]> originalList = new ArrayList<>();
    /*
     * 之後要匹配的優先順序 一次只適用一種優惠
     * 1. 優待true 愛心票（更鬼的難度：陪同者）
     * 2. 年齡小於18或大於65 半票
     * 3. 當月壽星 生日票
     */
    // 訂購者姓名+放入遊樂園票價要判斷的檢核點 依序為年齡int 生日月份int 有優待身分boolean
    originalList.add(new Object[] { "Henry", 17, 12, false }); // 半票
    originalList.add(new Object[] { "Savala", 18, 12, false }); // 生日票
    originalList.add(new Object[] { "Cindy", 67, 1, false }); // 敬老票
    originalList.add(new Object[] { "Kuromi", 20, 1, true }); // 愛心票
    originalList.add(new Object[] { "Apachi", 25, 7, false }); // 全票

    List<Object[]> tuple = Collections.unmodifiableList(originalList);
    // 可能考慮做臨時物件
    // var obj = new Object(){
    // String color = "red";
    // };
    // 不過有其侷限性便是，或參考StreamCamp的保守作法

    /*
     * 用Stream filter辨識比較漂亮
     * 單純檢查存在可用findFirst
     * 想收集就用.collect(Collectors.toList())
     */

    // 廢案
    // for (Object[] obj : tuple) {
    // obj[0]取到年齡，以此類推
    // 抱歉ㄟJava沒有解包
    // https://stackoverflow.com/questions/17837014/how-to-unpack-an-array-into-different-arguments-on-method-call
    // }
  }

  // do while問一次再問第二次 例如簡易帳密檢查

  /*
   * 編寫一個名為 isPalindrome 的方法，其中包含一個名為 number 的 int 參數。
   * 該方法需要返回一個布爾值。
   * 如果數位是回文數位，則應返回 true，否則應返回 false。
   */
  /*
   * 提示：反轉數字的邏輯
   * 聲明並初始化另一個變數以存儲數位的反向，例如 reverse = 0。
   * 
   * 通過執行模除法（餘數）提取給定數字的最後一位數位。
   * 將最後一位數位存儲到某個變數中，例如 lastDigit = num% 10。
   * 將 reverse 的位值增加 1。
   * 要增加位值，請將反向變數乘以 10，例如 reverse = reverse * 10。
   * 添加 lastDigit 以反轉。
   * 由於處理了數字的最後一位數位，因此刪除了數字的最後一位數位。要刪除最後一位數位，請除以 10。
   * 重複這些步驟，直到數位不等於（或大於）零。
   * 
   * while 循環對於此編碼練習很有説明。
   * 
   * 提示：請注意負數。 它們也可以是回文編號。
   * 提示：反轉數位時要小心，您需要一個參數來將反轉的數位與起始數位（參數）進行比較。
   */

  /*
   * 編寫一個名為 printFactors 的方法，其中包含一個名為 number 的 int 類型的參數。
   * 如果 number < 1，則該方法應列印“無效值”。
   * 該方法應列印數位的所有因數。一個數位的因數是一個整數，它將該數位完全除以（即不留下餘數）。
   * 例如，3 是 6 的因數，因為 3 完全除以 6 而不留下餘數。換句話說，6 / 3 = 2。
   */

  // 最大公約數
  // 完美數
  // 最大質因數
  /*
   * 編寫一個名為 printSquareStar 的方法，其中包含一個名為 number 的 int 類型的參數。
   * 如果 number < 5，則該方法應列印“Invalid Value”。
   * 該方法應列印對角線以生成由星形 （*） 組成的矩形圖案。這應該通過使用循環來實現（請參閱下面的示例）。
   ********
   ** **
   * * * *
   * ** *
   * ** *
   * * * *
   ** **
   ********
   * 上面的模式由若干行和列組成（其中 number 是要列印的行數）。對於每一行或每一列，根據四個條件列印星號（請仔細閱讀）：
   * 在第一行或最後一行
   * 在第一列或最後一列中
   * 當行號等於列號時
   * 當列號等於 rowCount - currentRow + 1（其中 currentRow 是當前行號）
   * 
   * 提示：使用嵌套迴圈（循環內部的迴圈）。
   * 提示：要在同一行上列印，請使用 print 方法而不是 println，例如 System.out.print（“
   * ”）;列印一個空格，並且不會“移動”到另一行。
   * 提示： 要“移動”到另一行，您可以使用空的 println 調用，例如 System.out.println（）; 。
   */
}