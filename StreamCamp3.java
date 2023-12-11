import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.stream.*;
import java.util.function.*;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

class StreamCamp3 {
  public void result() {
    // 改看這個https://www.bilibili.com/video/BV1Gh41187uR/?spm_id_from=333.337.search-card.all.click
    /*-----------一個匿名類部類別如何變成Lambda-----------*/
    // 匿名類別
    int z = sum(new IntBinaryOperator() {
      @Override
      public int applyAsInt(int l, int r) {
        return l + r;
      }
    });
    System.out.println(z);

    // 上者改成Lambda
    int z1 = sum((int l, int r) -> {
      return l + r;
    });
    System.out.println(z1);

    // 更加簡化
    int z2 = sum((l, r) -> l + r);
    System.out.println(z2);

    /*-----------Lambda2-----------*/
    printNum((int value) -> {
      return value % 2 == 0;
    });
    // TODO 試著還原回匿名類別吧

    // TODO 泛型那個太複雜了先跳

    /*-----------流的中間操作-----------*/
    // Stream的流程 創造流->中間操作->終端操作
    List<Author> authors = Arrays.asList(
        new Author(1, "Miku", 16, "Ievan Polkka"),
        new Author(3, "Paimon ", 1000, "原神啟動"));
    // stream().distinct 去重
    // 想了解Stream旗下方法如filter的原理，可以透過還原為匿名類別會更加清楚

    // map()映射成其他元素 authors.stream.map(author::getAge) 或age->age+1
    // map()完還能一直map

    // sorted() 要想使流具有排序能力，可以在POJO實作Comparable以及下方的比較方法
    // 要小心溢出 https://www.imooc.com/wenda/detail/579600

    // limit()
    // skip()跳過
    // flapMap() 對多個流的操作 有攤平的作用

    /*-----------流的終端操作-----------*/
    // forEach()
    // count()
    // max()&min()
    // collect()

    // anyMatch() allMatch() noneMatch() findAny() findFirst() findFirstOrThrow()
    // 可以去Javadoc看看它們的回傳值

    // reduce()遞迴操作 得到一個計算結果
    // 像是.reduce(0, (a, b) -> a + b) 要給個初始值及apply Lambda
    // 也能用來求最大值 最小值

    /*-----------流的注意事項-----------*/
    // 流是惰性求值 一次性的 不影響原本資料

    /*-----------Optional-----------*/
    // 跟Stream都是實現了Serializable和BaseStream接口
    // 可用於創建對象
    // 安全消費值
    // 其實用單用get()是不太好的 要搭配isPresent()做檢查嘛 那用流的思想來看 用個ifPresent()一次處理不香嘛
    // 獲取值就get()
    // 安全獲取值 orElseGet() orElseThrow

    // filter()過濾
    // 判斷isPresent()

    // map()數據轉換

    /*-----------FunctionalInterface-----------*/
    // JDK內的 不用硬記!!
    // Consumer 消費 forEach()
    // Fuction 計算 map()
    // Predicate 判斷 filter() and() or()
    // Supplier 生產

    /*-----------方法引用::-----------*/
    // 只有符合規則的可以用 匿名方法只return一個東西
    // 引用類的靜態方法
    // 引用物件的實例方法
    // 引用類的實例方法
    //TODO 微跳
    // 構造函數引用類名::New

    /*-----------高級用法-----------*/
    // Stream對基礎型態有優化 mapToXxx幫忙轉換 不用手動拆裝箱
    // 平行流 跳

  }// 我是result結尾

  // IntBinaryOperator這個interface只有一個方法要實作，他還是一個functional interface
  public static int sum(IntBinaryOperator operator) {
    int a = 10;
    int b = 20;
    return operator.applyAsInt(a, b);
  }

  public static void printNum(IntPredicate predicate) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    for (int i : arr) {
      if (predicate.test(i)) {
        System.out.println(i);
      }
    }
  }
}// 我是class結尾

// 這個好像也不錯https://www.bilibili.com/video/BV1k64y1R7sA/?spm_id_from=333.337.search-card.all.click
// https://juejin.cn/post/7009925824899973150
// 哇!!策略模式+自製@FunctionalInterface!!（真的覺得這篇比大師班還清楚）

@Data
// 舊lombok中Data=Getter+Setter 確認下新版有無EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
// distinct才會正常作用，不然吃到Object的HashCode就不是我們期望的（我們認為值相等也是相等，而非哈希符合才算相等，所以必須重寫方法）
class Author {
  private Long id;
  private String name;
  private Interger age;
  private String intro;
  // private List<Books>;
}
// Books
