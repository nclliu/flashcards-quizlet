package cs3500.pa02;

import java.nio.file.Path;

/**
 * class to represent a file, given fake creation and modified dates
 */
public class MdFile {
  private Path path;
  private int creationTime;
  private int modiefiedDate;

  /**
   * constructor for mdfile
   * @param p path of the file
   * @param c created time
   * @param m modified date
   */
  MdFile(Path p, int c, int m) {
    this.path = p;
    this.creationTime = c;
    this.modiefiedDate = m;
  }

  /**
   * @return the creation time
   */
  int getCreationTime() {
    return this.creationTime;
  }

  /**
   * @return the modified date
   */
  int getModiefiedDate() {
    return this.modiefiedDate;
  }

  /**
   * @return path of the file
   */
  public Path getPath() {
    return this.path;
  }
}

