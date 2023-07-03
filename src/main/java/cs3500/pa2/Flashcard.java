package cs3500.pa2;

/**
 * class representing a flashcard
 */
public class Flashcard {
  public String question;
  public String answer;
  Level level;

  /**
   * @param q question segment
   * @param a answer segment
   * @param l this questions' level of difficulty
   */
  public Flashcard(String q, String a, Level l) {
    this.question = q;
    this.answer = a;
    this.level = l;
  }
}