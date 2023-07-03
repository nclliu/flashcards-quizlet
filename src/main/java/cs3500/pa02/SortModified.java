package cs3500.pa02;

import java.util.Comparator;

/**
 * Class for comparator(modified date)
 */
public class SortModified implements Comparator<MdFile> {

  /**
   * Comparator for sorting my modified date
   *
   * @param o1 first mdfile
   * @param o2 second provided mdfile
   */
  @Override
  public int compare(MdFile o1, MdFile o2) {
    return o1.getModiefiedDate() - o2.getModiefiedDate();
  }
}
