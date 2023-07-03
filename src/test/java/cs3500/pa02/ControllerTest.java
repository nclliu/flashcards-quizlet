package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.controller.Controller;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class ControllerTest {
  Controller c = new Controller();

  @Test
  public void controllerRunSession() {
    assertThrows(NoSuchFileException.class, () -> {
        c.runSession(Path.of("sampleqa.sr"), 10);});
  }
  @Test
  public void controllerStudyGuide() throws IOException {
    c.runStudyGuide(Path.of("arrays.md"), "filename",
        Path.of("src/test/pa01notes"));
  }
}
