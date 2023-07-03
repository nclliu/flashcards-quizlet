package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa2.Flashcard;
import cs3500.pa2.Level;
import cs3500.pa2.QandA;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * class for testing q and a
 */
public class QandATest {
  private Flashcard f1 = new Flashcard("test1", "answer1", Level.HARD);
  private Flashcard f2 = new Flashcard("test2", "answer1", Level.HARD);


  /**
   * testing q and a object creation
   */
  @Test
  public void testqanda() {
    ArrayList<Flashcard> questions = new ArrayList<>();
    questions.add(f1);
    questions.add(f2);
    QandA test = new QandA(questions);
    assertEquals(test.allcards.size(), 2);

    assertThrows(NoSuchElementException.class, () -> {test.showQuestions(questions);});
  }
}
