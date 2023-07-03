package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa2.Flashcard;
import cs3500.pa2.Level;
import org.junit.jupiter.api.Test;

public class FlashCardTest {
  @Test
  public void testFlash() {
    Flashcard f = new Flashcard("What does CS3500 stand for?", "OOD", Level.HARD);

    /*
    assertEquals(f.question, "What does CS3500 stand for?");
    assertEquals(f.answer, "OOD");
    assertEquals(f.level, Level.HARD);
     */
  }
}
