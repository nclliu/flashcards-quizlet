package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * test file visitor
 */

public class MdFileWalkerTest {
  /**
   * method for testing mdFile
   * @throws IOException when nothing found
   */
  private MdFile p1 = new MdFile(Path.of("src/test/testfilewalker/arrays.md"), 0, 0);
  private MdFile p2 = new MdFile(Path.of("src/test/testfilewalker/vectors.md"), 0, 0);

  /**
   * testing filewalker class, will call all appropriate methods
   * @throws IOException when file not found
   */
  @Test
  public void testFileVisitor() throws IOException {
    MdFileWalker mdf = new MdFileWalker(new ArrayList<MdFile>());
    Files.walkFileTree(Path.of("src/test/testfilewalker"), mdf);
    ArrayList<MdFile> actual = mdf.getFiles();

    ArrayList<MdFile> expected = new ArrayList<>();
    expected.add(p2);
    expected.add(p1);

    assertTrue(actual.size() == 2);


  }

}