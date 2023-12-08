import java.util.*;

class MultipleKeyTest {
  public void result() {
    IdentityHashMap<String, String> infoMap = new IdentityHashMap<>();
    infoMap.put("test","a");
    infoMap.put("test","b");
    System.out.print(infoMap.get("test"));
  }
}