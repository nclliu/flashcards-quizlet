package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.nio.file.Path;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

/**
 * class for testing sortmodified
 */
public class SortModifiedTest {
  private MdFile p1 = new MdFile(Path.of("arrays.md"), 10, 10);
  private MdFile p2 = new MdFile(Path.of("vectors.md"), 10, 20);

  Comparator<MdFile> pm = new SortName();

  /**
   * tests comparator for modified dates
   */
  @Test
  public void testSortModified() {
    assertTrue(pm.compare(p1, p2) < 0);
    assertTrue(pm.compare(p2, p1) > 0);
  }
}