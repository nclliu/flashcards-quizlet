package cs3500.pa02;

import cs3500.controller.Controller;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * This is the main driver of this project.
 */
public class Driver {

  /**
   * Project entry point
   *
   * @param args - no command line args required
   * depending on size of argument, will either generate study guide
   * or run new study session
   */
  public static void main(String[] args) throws IOException {
    if (args.length != 3 && args.length != 0) {
      throw new IllegalArgumentException("please have either 3 or no arguments");
    }

    Controller c = new Controller();
    if (args.length == 3) {
      Path p = Path.of(args[0]);
      String comp = args[1];
      Path o = Path.of(args[2]);
      c.runStudyGuide(p, comp, o);
    }
    else {
      System.out.println("Welcome to your new study session! Please provide the path to a .sr file.");
      Scanner scanner = new Scanner(System.in);
      Path p = Path.of("");
      try {
        p = Path.of(scanner.nextLine());
      } catch (IllegalArgumentException e) {
        System.err.println("invalid path");
      }
      System.out.println("please enter the number of questions you would like to answer");
      int n = Integer.parseInt(scanner.nextLine());
      c.runSession(p, n);
    }
  }
}



