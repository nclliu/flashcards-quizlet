package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa2.StudyGuide;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * class for testing study guide
 */
public class StudyGuideTest {

  /**
   * testing sort methods
   */
  private MdFile p1 = new MdFile(Path.of("src/test/testfilewalker/arrays.md"), 10, 10);
  private MdFile p2 = new MdFile(Path.of("src/test/testfilewalker/vectors.md"), 0, 20);
  @Test
  public void testSort() {

    ArrayList<MdFile> files = new ArrayList<MdFile>();
    files.add(p1);
    files.add(p2);
    ArrayList<MdFile> files2 = (ArrayList<MdFile>) files.clone();
    ArrayList<MdFile> files3 = new ArrayList<MdFile>();
    files3.add(p2);
    files3.add(p1);


    StudyGuide meow = new StudyGuide(files);
    meow.sort(Sort.filename);

    assertEquals(files, files2);

    StudyGuide meow2 = new StudyGuide(files);

    meow2.sort(Sort.created);
    assertEquals(files, files3);

    StudyGuide meow3 = new StudyGuide(files);
    meow3.sort(Sort.modified);
    assertEquals(files, files2);
  }

  /**
   * testing output method in qanda class
   * @throws IOException when cannot access files
   */
  @Test
  public void testOut() throws IOException {

    ArrayList<MdFile> files2 = new ArrayList<>();
    files2.add(new MdFile(Path.of("src/test/testStudy/arrays.md"), 10, 10));
    StudyGuide test2 = new StudyGuide(files2);

   test2.output(Path.of("src/test/testStudy"));
  }

}