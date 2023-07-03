package cs3500.pa02;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * walks filetree to find all md files
 */
public class MdFileWalker implements FileVisitor<Path> {

  ArrayList<MdFile> files = new ArrayList<>();

  /**
   * Initializes files to given file
   *
   * @param f given list of paths
   */
  public MdFileWalker(ArrayList<MdFile> f) {
    files = f;
  }

  /**
   * what to do at the beginning of processing directory
   *
   * @param dir
   *          a reference to the directory
   * @param attrs
   *          the directory's basic attributes
   *
   * @return a directive to walk
   * @throws IOException when nothing found
   */
  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    System.out.format("Starting Directory: %s%n", dir);
    return CONTINUE;
  }

  /**
   * what to do when file is visited
   *
   * @param file
   *          a reference to the file
   * @param attrs
   *          the file's basic attributes
   * @return directive on how to process current item's siblings and children.
   * In this case, we continue.
   * @throws IOException
   */
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    String fileName = file.getFileName().toString();
    if (fileName.endsWith(".md")) {
      MdFile mdf = new MdFile(file, (int) System.currentTimeMillis(),
          (int) System.currentTimeMillis());
      files.add(mdf);
    }
    return CONTINUE;
  }

  /**
   * what to do when file cannot be found
   * @param file
   *          a reference to the file
   * @param exc
   *          the I/O exception that prevented the file from being visited
   * @return
   * @throws IOException throws exception
   */
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
    System.err.println(exc);
    return CONTINUE;
  }

  /**
   * @param dir
   *          a reference to the directory
   * @param exc
   *          {@code null} if the iteration of the directory completes without
   *          an error; otherwise the I/O exception that caused the iteration
   *          of the directory to complete prematurely
   *
   * @return
   * @throws IOException throws exception
   */
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
    System.out.format("Starting Directory: %s%n", dir);
    return CONTINUE;
  }

  /**
   * @return list of files accumulated
   */
  public ArrayList<MdFile> getFiles() {
    return files;
  }
}