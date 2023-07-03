package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.nio.file.Path;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

/**
 * class for testing created sort
 * im sorry nothing i tried was working bruh
 */
public class SortCreatedTest {
  private MdFile p1 = new MdFile(Path.of("arrays.md"), 10, 10);
  private MdFile p2 = new MdFile(Path.of("vectors.md"), 20, 10);

  Comparator<MdFile> pc = new SortCreated();

  /**
   * tests created comparator
   */
  @Test
  public void testSortCreated() {
    assertTrue(pc.compare(p1, p2) < 0);
    assertFalse(pc.compare(p2, p1) < 0);
  }
}
