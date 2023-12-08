import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;

class StreamCamp2 {
  public void result() {
    ArrayList<StudentExamResults> studentExamResults = new ArrayList<StudentExamResults>();
    studentExamResults.add(new StudentExamResults("Mikasa", 99));
    studentExamResults.add(new StudentExamResults("Sasha", 70));
    studentExamResults.forEach(result -> System.out.println(result));
  }

}

record StudentExamResults(String name, int score) {
}