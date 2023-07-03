package cs3500.controller;

import cs3500.pa02.MdFile;
import cs3500.pa02.MdFileWalker;
import cs3500.pa02.Sort;
import cs3500.pa2.Flashcard;
import cs3500.pa2.QandA;
import cs3500.pa2.StudyGuide;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * controller class to run appropriate sessions
 */
public class Controller {
  /**
   * @param p path to walk files in
   * @param comp sort type
   * @param o output path to write file to
   * @throws IOException when no file found
   */
  public void runStudyGuide(Path p, String comp, Path o) throws IOException {
    ArrayList<MdFile> files = new ArrayList<MdFile>();
    MdFileWalker mdf = new MdFileWalker(files);
    Files.walkFileTree(p, mdf);
    ArrayList<MdFile> validf = mdf.getFiles();

    StudyGuide notes = new StudyGuide(validf);
    notes.sort(Sort.valueOf(comp));
    notes.output(o);
  }

  /**
   * @param p path to the sr file
   * @param n number of questions user would like to answer
   * @throws IOException
   */
  public void runSession(Path p, int n) throws IOException {
    QandA session = new QandA(p);
    ArrayList<Flashcard> questions = session.sessionFlashcards(n);
    session.showQuestions(questions);
  }
}
