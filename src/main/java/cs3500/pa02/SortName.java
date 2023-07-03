package cs3500.pa02;

import java.util.Comparator;

/**
 * Class for comparator(name)
 */
public class SortName implements Comparator<MdFile> {
  /**
   * Comparator for sorting by modified date
   *
   * @param o1 first mdfile
   * @param o2 second provided mdfile
   */
  @Override
  public int compare(MdFile o1, MdFile o2) {
    return o1.getPath().toFile().getName().compareTo(
        o2.getPath().toFile().getName());
  }
}
