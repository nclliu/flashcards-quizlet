package cs3500.pa2;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * class representing q and a session
 */
public class QandA {
  public ArrayList<Flashcard> allcards;
  private int questions;
  private Path file;
  private int easytohard;
  private int hardtoeasy;

  public QandA(Path file) throws IOException {
    this.questions = 0;
    this.file = file;
    this.allcards = generateFlashcards();
  }

  /**
   * constructor for testing
   * @param f sets all cards to given list of flashcards
   */
  public QandA(ArrayList<Flashcard> f) {
    this.questions = 0;
    this.file = null;
    this.allcards = f;
  }

  /**
   * will create list of flashcards containing all questions in sr file
   * @return list of flashcards with all questions in sr file
   * @throws IOException for exceptions
   */
  public ArrayList<Flashcard> generateFlashcards() throws IOException {
    ArrayList<Flashcard> flashcards = new ArrayList<>();
    Scanner scanner = new Scanner(this.file);
    while (scanner.hasNext()) {
      String s = scanner.nextLine();
      String q = s.substring(0, s.indexOf(":::"));
      String a = s.substring(s.indexOf(":::") + 3, s.length());
      flashcards.add(new Flashcard(q, a, Level.HARD));
    }
    return flashcards;
  }

  /**
   * creates flashcards to use in current session based on user input
   * @param n the number of flashcards in this session
   * @return list of flashcards, size n
   */
  public ArrayList<Flashcard> sessionFlashcards(int n) {
    ArrayList<Flashcard> output = new ArrayList<>();
    Random random = new Random();
    for(int i = 0; i < n; i++) {
      int num = random.nextInt(0, allcards.size());
      output.add(allcards.get(num));
      allcards.remove(num);
    }
    return output;
  }

  /**
   * will show user questions, answers and prompts
   * updates questions accordingly
   * updates state of q and a session
   * @param questions the list of this session's flashcards
   */
  public void showQuestions(ArrayList<Flashcard> questions) {
    for(int i = 0; i < questions.size(); i++) {
      Flashcard f = questions.get(i);
      System.out.println(f.question);
      System.out.println(f.answer);
      System.out.println("Please enter 1.easy 2.hard 3. exit");
      Scanner scanner = new Scanner(System.in);
      int n = Integer.parseInt(scanner.nextLine());
      if(n == 1 || n == 2) {
        this.questions++;
      }
      if(n == 1 && !f.level.equals(Level.EASY)) {
        this.hardtoeasy++;
        questions.set(i, new Flashcard(f.question, f.answer, Level.EASY));
      }
      if(n == 2 && !f.level.equals(Level.HARD)) {
        this.easytohard++;
        questions.set(i, new Flashcard(f.question, f.answer, Level.HARD));
      }
      if(n == 3 || i == questions.size() - 1) {
        printoutmessage(questions);
      }
    }
  }

  /**
   * prints out the final message when session concludes
   * @param questions this sessions list of questions
   */
  public void printoutmessage(ArrayList<Flashcard> questions) {
    int hard = 0;
    int easy = 0;
    System.out.println(this.allcards.size());

    for(int i = 0; i < questions.size(); i++) {
      this.allcards.add(questions.get(i));
    }

    for(Flashcard f : this.allcards) {
      if(f.level.equals(Level.EASY)) {
        easy++;
      }
      else {
        hard++;
      }
    }

    System.out.println("You've answered " + this.questions + " questions in total");
    System.out.println("There are now " + hard + " hard questions in the bank");
    System.out.println("There are now " + easy + " easy questions in the bank");
    System.out.println("A total of " + this.easytohard + " were classified as easy but changed to hard");
    System.out.println("A total of " + this.hardtoeasy + " were classified as easy but changed to hard");
  }


}

