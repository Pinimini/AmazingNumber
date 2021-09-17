// You can experiment here, it won’t be checked

import java.util.*;
import java.util.function.Consumer;

public class Task {
  public static void main(String[] args) {
    List<String> collection = new ArrayList<>(Arrays.asList("111", "22", "3"));

    Comparator<String> comparator = (x, y) -> x.length() > y.length() ? -1 : 1;
    comparator.compare("1","2");
    collection.sort(comparator);
  }
}
