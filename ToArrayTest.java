import java.util.ArrayList;

class ToArrayTest {
  public void result() {
    ArrayList<String> tagList = new ArrayList<>();
    tagList.add("a");
    tagList.add("b");
    tagList.add("c");
    String[] tagArr = tagList.toArray(new String[0]);
    for (String t : tagArr) {
      System.out.println(t);
    }
  }
}