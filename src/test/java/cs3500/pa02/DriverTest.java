package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class DriverTest {
  /**
   * testing main
   * @throws IOException when no file found
   */
  @Test
  public void testMain() throws IOException {
    Driver testdrive = new Driver();
    Scanner scanner0 = new Scanner(Path.of("src/test/pa01notes/arrays.md"));
    Driver.main(new String[] {Path.of("arrays.md").toString(), "filename",
        Path.of("src/test/pa01notes").toString()});

    assertThrows(NoSuchElementException.class, () -> {Driver.main(new String[0]);});
    assertTrue(scanner0.hasNext());
    Scanner scanner = new Scanner("/Users/nclliu/Documents/cs3500/pa02-nclliu/src/test/pa01notes/arrays.md");
    assertTrue(scanner.hasNext());

    assertThrows(IllegalArgumentException.class, () -> {Driver.main(new String[2]);});
  }
}