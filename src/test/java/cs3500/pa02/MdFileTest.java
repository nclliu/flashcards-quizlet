package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * class for testing mdfiles
 */
public class MdFileTest {
  private MdFile p1 = new MdFile(Path.of("arrays.md"), 0, 0);
  private MdFile p2 = new MdFile(Path.of("vectors.md"), 10, 5);

  /**
   * test for getcreation
   */
  @Test
  public void testCreation() {
    assertEquals(p1.getCreationTime(), 0);
    assertEquals(p2.getCreationTime(), 10);
  }

  /**
   * test for getmodify
   */
  @Test
  public void testModify() {
    assertEquals(p1.getModiefiedDate(), 0);
    assertEquals(p2.getModiefiedDate(), 5);
  }

  /**
   * test for gettingpath
   */
  @Test
  public void testPath() {
    assertEquals(p1.getPath(), Path.of("arrays.md"));
    assertEquals(p2.getPath(), Path.of("vectors.md"));
  }

}
