import java.util.Scanner;
import java.lang.reflect.Method;

class Main {
  public static void main(String[] args) {
    // 打印程式標題與說明
    System.out.println("=====================");
    System.out.println("【打印試題結果系統v1.0】");
    System.out.println("輸入點開File功能後，想看解答的java檔案名稱");
    System.out.println("如想看Test.java，輸入Test即可");
    System.out.println("=====================");
    System.out.println("請輸入想看結果的檔案名稱：");
    /* debug註掉範圍~頭 */
    Scanner scanner = new Scanner(System.in);
    // 檢查使用者輸入內容
    String userInputName = scanner.nextLine();
    while (userInputName.equals("")) { // 檢查輸入空值待考
      System.out.println("您沒輸入內容，請輸入內容：");
      userInputName = scanner.nextLine();
    }
    // String userInputName = "SnakeGame"; // debug時抽換成這個
    /* debug註掉範圍~尾 */

    try {
      Object obj = Class.forName(userInputName).newInstance();
      Method method = obj.getClass().getMethod("result");
      // 基於這個架構，所有試題要print出答案的method名稱都得叫做result
      method.invoke(obj);
    } catch (ClassNotFoundException c) {
      System.out.println("沒有這個檔案");
    } catch (Exception e) {
      e.printStackTrace();
    }
    // 詢問還要不要繼續使用這支程式
    ask(scanner, args); // debug時註掉這個
  }

  public static void ask(Scanner scanner, String[] args) {
    System.out.println("請問您還要使用這個系統嗎？Y/N");
    String userDesire = scanner.nextLine();
    switch (userDesire) {
      case "Y":
      case "y":
        main(args);
        break;
      case "N":
      case "n":
        System.out.println("程式結束！");
        System.exit(0);
        break;
      default:
        System.out.println("輸入一個正確的指令吧;w;");
        ask(scanner, args); // 遞迴
        break;
    }
  }
}