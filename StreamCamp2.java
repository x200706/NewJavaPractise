import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.stream.*;

class StreamCamp2 {
  public void result() {
    ArrayList<StudentExamResults> studentExamResults = new ArrayList<StudentExamResults>();
    studentExamResults.add(new StudentExamResults("Mikasa", 99));
    studentExamResults.add(new StudentExamResults("Sasha", 70));
    studentExamResults.forEach(result -> System.out.println(result.name())); // 先確認型態唄

    List<StudentExamResults> query = studentExamResults.stream()
        .filter(result -> result.score() > 80)
        .collect(Collectors.toList());
    query.forEach(result -> System.out.println("表揚考試分數大於八十分的寶寶" + result.name()));

    // 後來我尋思一件奇怪的事情，如果只是要sout這樣寫就好了吧
    studentExamResults.stream()
        .filter(result -> result.score() > 80)
        .forEach(result -> System.out.println("表揚考試分數大於八十分的寶寶" + result.name()));

    // Stream必須完成管道操作（collect forEach之類的）才會真的執行流
    // 管道操作完成的流也不能重新collect forEach之類的

    // 關於冒冒（？）的二三事：https://blog.csdn.net/weixin_44259720/article/details/122680270

    Stream.of("動物森友會大集合")
        .map(str -> str.split(""))
        .flatMap(Arrays::stream)
        .forEach(System.out::println);

    // 上面沒做平坦化會長這樣
    Stream.of("動物森友會大集合")
        .map(str -> str.split("")).forEach(arr -> {
          for (String element : arr) {
            System.out.println(element);
          }
        });
    // 沒有完成管道操作的多個流 可以用Stream.concat合用

    // TODO Map透過entrySet轉回Set 下方才有stream方法

    // Stream.generate 憑空生流，可以用在不用迴圈產隨機數等
    // 說到這個生隨機數 由於Stream會執行自動裝拆箱，如果有明確要操作的型態，建議用子類別如IntStream等
    // 愛用IntStream.iterate

    // Main::isPrime

    // TODO 說到Stream很久以前用過平行流開執行緒，但為甚麼執行的次數（range）跟我預期有落差呢...？
    // https://chat.openai.com/share/4022b256-5b00-4f02-a307-12ccc8633b35
    // 有待了解

    // TODO 我宣布暫時放棄Java17大師班..............

  } // 我是result結尾
} // 我是class結尾

record StudentExamResults(String name, int score) {
}