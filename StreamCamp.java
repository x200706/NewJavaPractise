import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

class StreamCamp {
  public void result() {
    List<Member> member = Arrays.asList(
        new Member("1", "Kiki", "kiki@123.com", "0929", "20"),
        new Member("2", "Bibi", "bb@123.com", "0988", "20"),
        new Member("3", "Nini", "nini@123.com", "0975", "35"),
        new Member("4", "wei", "wei7@123.com", "0963", "35"),
        new Member("5", "Kai", "exo@gmail.com", "0992", "40"));

    // 查詢術
    List<Member> mailDomainIsGmailMember = member.stream()
        .filter(e -> e.getEmail().contains("gmail"))
        .collect(Collectors.toList()); // 排版哲學1：點點在前 Code Style：e表元素
    mailDomainIsGmailMember.forEach(e -> System.out.println("員工" + e.getName() + "使用gmail"));
    // 必須說嚴謹寫法得是判斷老鼠以後的域名，不然gmail@yahoo.com.tw怎麼辦= =

    // 置換術（不會影響原本的member!!）
    List<Member> updateMemberId = member.stream().map(e -> { // 變數名稱不太好..
      Member updateMember = new Member(); // 這裡變數竟然不能用跟外面一樣的...
      updateMember.setId("IT" + e.getId()); // 這裡有坑，要更新記得所有屬性都更新
      updateMember.setName(e.getName());
      updateMember.setEmail(e.getEmail());
      updateMember.setPhone(e.getPhone());
      updateMember.setAge(e.getAge());
      return updateMember; // 我知道為何要rerutn啦 map通常都是拿變換後的值，只是做set作並沒有提供這個值
      // TODO 還沒看：map()需要返回的情境
      // 不return的錯誤：
      /*
       * ./StreamCamp.java:30: error: method map in interface Stream<T> cannot be
       * applied to given types;
       * List<Member> updateMemberId = member.stream().map(e -> { // 變數名稱不太好..
       * ^
       * required: Function<? super Member,? extends R>
       * found: (e)->{ Mem[...])); }
       * reason: cannot infer type-variable(s) R
       * (argument mismatch; bad return type in lambda expression
       * missing return value)
       * where R,T are type-variables:
       * R extends Object declared in method <R>map(Function<? super T,? extends R>)
       * T extends Object declared in interface Stream
       * ./StreamCamp.java:42: error: method map in interface Stream<T> cannot be
       * applied to given types;
       * List<Member> updateMemberId1 = member.stream().map(e -> { // 變數名稱不太好..
       * ^
       * required: Function<? super Member,? extends R>
       * found: (e)->{ Mem[...])); }
       * reason: cannot infer type-variable(s) R
       * (argument mismatch; bad return type in lambda expression
       * missing return value)
       * where R,T are type-variables:
       * R extends Object declared in method <R>map(Function<? super T,? extends R>)
       * T extends Object declared in interface Stream
       * Note: ./Main.java uses or overrides a deprecated API.
       * Note: Recompile with -Xlint:deprecation for details.
       * Note: ./StrangeHashMap.java uses unchecked or unsafe operations.
       * Note: Recompile with -Xlint:unchecked for details.
       * 2 errors
       */
    }).collect(Collectors.toList()); // 安安你forEach當然不能接上啊，你看你前面的型態是Listㄟ
    updateMemberId.forEach(e -> System.out.println(e.getId()));
    updateMemberId.forEach(System.out::println);

    // flatmap 得到一個全新的Stream？！

    // 判斷術
    Boolean isGmail = member.stream().anyMatch(e -> e.getEmail().contains("gmail"));
    System.out.println("有員工使用Gmail嗎？" + isGmail);
    // 更進階可以用findXxx等方法回傳的Optional判斷

    // 排序術
    List<Member> sortMember = member.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
        .collect(Collectors.toList());
    sortMember.forEach(e -> System.out.println(e.getName()));

    // 分組術GroupBy
    /*是說這接值型態這麼令人煩躁 我乾脆以後用var接好了 啊沒有用IDE要看再用.getClass().toString()*/
    Map<Optional<String>, List<Member>> memberMap = member.stream()
        .collect(Collectors.groupingBy(e -> Optional.ofNullable(e.getAge()))); // 千萬小心型別推斷
    // Map<String, List<Member>> memberMap = member.stream()
    // .collect(Collectors.groupingBy(Member::getAge));
    memberMap.forEach((k, v) -> System.out.println(k.get() + " : " + v));

    // Sum
    // Long sumAge = member.stream().mapToLong(e -> e.getAge()).sum();
    // 年齡加起來的爛笑話...
    // 這邊不成立因為這樣寫的時候String在這邊不能轉成Long QQ

    // Reduce
    String stuff = member.stream()
        .map(Member::getName)
        .reduce("", (last, name) -> last + " " + name);

    System.out.println(stuff);

    // Limit

    // 用Optional的orElseThrow扔出例外

    // 你還可以過濾完資料後以for each異動資料庫內容

  } // 我是result方法的結尾

} // 我是Class結尾

@Data
@AllArgsConstructor
@NoArgsConstructor
// 嗨嗨如果沒作用，清除緩存重新運行編譯
class Member {
  private String id;
  private String name;
  private String email;
  private String phone;
  private String age;
  // private String birth;
  // private String gender;
  // private String addr;
}
