package cs3500.pa2;

import cs3500.pa02.MdFile;
import cs3500.pa02.Sort;
import cs3500.pa02.SortCreated;
import cs3500.pa02.SortModified;
import cs3500.pa02.SortName;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * Class for consolidating notes by filtering file lines
 */

public class StudyGuide {

  private ArrayList<MdFile> list;

  public StudyGuide(ArrayList<MdFile> list) {
    this.list = list;
  }

  /**
   * @param comp the flag determines which comparator to use
   */
  public void sort(Sort comp) {
    switch (comp) {
      case filename:
        Collections.sort(list, new SortName());
        break;
      case created:
        Collections.sort(list, new SortCreated());
        break;
      case modified:
        Collections.sort(list, new SortModified());
    }
  }


  /**
   * @param o path t0 output file
   * @return will write to the output destination
   * questions and notes will be outputted to separate files
   */
  public FileWriter output(Path o) throws IOException {
    FileWriter out = new FileWriter(o.toAbsolutePath()  + "/Output.md");
    FileWriter qout = new FileWriter(o.toAbsolutePath() + "/QandQ.sr");
    for (MdFile path : this.list) {
      Scanner scanner = new Scanner(path.getPath());
      while (scanner.hasNext()) {
        String s = scanner.nextLine();
        if (s.contains("#")) {
          out.write(System.lineSeparator());
          out.write(System.lineSeparator());
          out.write(s);
        } else if (s.contains("[[") && !s.contains(":::")) {
          out.write(System.lineSeparator());
          out.write(" - " + s.substring(s.indexOf("[[") + 2, s.indexOf("]]")));
        }
        if (s.contains("[[") && s.contains(":::")) {
          qout.write(s.substring(s.indexOf("[[") + 2, s.indexOf("]]")));
          qout.write(System.lineSeparator());
        }
      }
    }
    out.close();
    qout.close();
    return out;
  }
}
