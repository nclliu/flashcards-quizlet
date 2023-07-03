package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

/**
 * sorts by name
 */
public class SortNameTest {
  private MdFile p1 = new MdFile(Path.of("arrays.md"), 10, 10);
  private MdFile p2 = new MdFile(Path.of("vectors.md"), 10, 10);

  Comparator<MdFile> p = new SortName();

  /**
   * testing sorting by name
   */

  @Test
  public void testSortName() {
    assertTrue(p.compare(p1, p2) < 0);
    assertFalse(p.compare(p2, p1) < 0);
  }
}