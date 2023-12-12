
// 課程：黑馬程序員－泛型 https://www.bilibili.com/video/BV1xJ411n77R/?p=2&spm_id_from=pageDriver
import java.util.*;
import lombok.*;

class GenericsCamp {
  public void result() {
    GenericsClass<String> genericsClass = new GenericsClass("a");
    // 型別擦除->機碼還會保留原始泛型資訊

    // 良心企業摸彩箱
    ProductGetter<String> strProductGetter = new ProductGetter<>(); // JDK1.7有類型推斷功能
    strProductGetter.addProduct("漲價的iPad");
    strProductGetter.addProduct("我目前買不起的DITOO喇叭");
    strProductGetter.addProduct("我目前買不起的新板特區房子");

    System.out.println("我抽到了：" + strProductGetter.getProduct());
    // 我抽到了：我目前買不起的DITOO喇叭;w;

    // 調用泛型方法
    ProductGetter<Integer> intProductGetter = new ProductGetter<>();
    ArrayList<String> productList = new ArrayList<>();
    productList.add("親子溫泉民宿券");
    productList.add("電影票10張");
    productList.add("雪樂園體驗券");
    System.out.println(intProductGetter.getProduct(productList)); // 抽到了：親子溫泉民宿券

    // 調用靜態泛型方法
    ProductGetter.printType("Hello Generics", 100, true);
    ProductGetter.myPrinter("a", "b", "c");

    // 通配符單元
    System.out.println("/n?來囉");
    Box<Number> box = new Box<>(); // Integer會壞掉 Integer is a Number; Number has a Integet
    box.setFirst(100);
    showBox(box);
  }// result結尾

  // 通配符單元用
  // 類型通配符傳遞類型實際參數
  // public static void showBox(Box<?> box) { // 通配符?表任意類型
  // Object first = box.getFirst(); // 失去泛型的意義
  // System.out.println(first);
  // }

  // 上限通配符改良
  public static void showBox(Box<? extends Number> box) { // 通配符?表任意類型
    Number first = box.getFirst();
    System.out.println(first);
  }
  // 補充：單用問號的效果 ttps://www.slideshare.net/JustinSDK/ss-86431235

  // 上限通配符的List不能在方法內加入，因為尚未定義
  // public static void showBoxList(ArrayList<? extends Number> list) {
  // list.add(new Number); // 報錯
  // }
  // 協變
}// class結尾

// 對了 方法簽章 傳入值ArrayList<String>跟ArrayList<Integer>都被認為是同種

// 常用代號T, E, K, V
@Data
@AllArgsConstructor
@NoArgsConstructor
class GenericsClass<T> {
  private T key;
}

class ProductGetter<T> {
  Random random = new Random();
  private T product;
  ArrayList<T> list = new ArrayList<>();

  public void addProduct(T t) {
    list.add(t);
  }

  // 不可靜態
  public T getProduct() { // 嗨嗨這不是泛型方法 它只是使用類的泛型成員
    product = list.get(random.nextInt(list.size()));
    return product;
  }

  // 泛型方法 就算這邊是T也跟類的T無關 可以靜態
  // ! 泛型方法可以傳參數給泛型類
  //
  public <E> E getProduct(ArrayList<E> list) { // 這些E是你可以套用泛型的地方，第一個尖尖最重要，
    return (E) list.get(random.nextInt(list.size())); // 為啥我丟出去前還要轉講師不用?_?
  }

  public static <T, R, E> void printType(T t, R r, E e) {
    System.out.println("t " + t.getClass().getSimpleName());
    System.out.println("r " + r.getClass().getSimpleName());
    System.out.println("e " + e.getClass().getSimpleName());
  }

  // 泛型方法與可變參數
  public static <E> void myPrinter(E... e) {
    for (E el : e) {
      System.out.print(el + " ");
    }
  }
}

// 泛型父類派生子類是泛型類，那類型要跟父類保持一致
// 如果沒寫 那覆寫方法會變成Object
class GenericsClassSon1<T> extends GenericsClass<T> {

}

// 泛型父類派生子類不是泛型類，那要明確類型繼承父類的泛型型別
class GenericsClassSon2 extends GenericsClass<String> {

}
// interface同上

// 通配符
@Data
class Box<E> {
  private E first;
}