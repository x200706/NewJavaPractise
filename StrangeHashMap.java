import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;

class StrangeHashMap {
  public void result() {
    ArrayList<TestModel> list = new ArrayList<>();
    TestModel testModel = new TestModel();
    testModel.setId("k1");
    testModel.setTag("tag1");
    list.add(testModel);

    TestModel testModel1 = new TestModel();
    testModel1.setId("k1");
    testModel1.setTag("tag2");
    list.add(testModel1);

    HashMap<String, List> map = new HashMap<>();
    list.forEach(node -> {
      map.put(node.getId(), new ArrayList<String>());
    });

    //這樣才不會蓋掉建立出來的ArrayList
    list.forEach(node -> {
      map.get(node.getId()).add(node.getTag());
    });

    map.forEach((k, v) -> {
      System.out.println(k + "：" + v);
    });
  }
}

@Data
class TestModel {
  String id;
  String tag;
}
