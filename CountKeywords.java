import java.util.*;
import java.io.*;

public class CountKeywords {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a Java source file: ");
    String filename = input.nextLine();

    File file = new File(filename);
    if (file.exists()) {
      System.out.println("The number of keywords in " + filename + " is " + countKeywords(file));
    } else {
      System.out.println("File " + filename + " does not exist");
    }
  }

  public static int countKeywords(File file) throws Exception {
    String[] keywordString = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"};

    Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
    int count = 0;

    Scanner input = new Scanner(file);
    boolean inBlockComment = false;

    while (input.hasNextLine()) {
      String line = input.nextLine();
      // Remove strings
      line = line.replaceAll("\".*?\"", "");
      
      // Check for block comments
      if (inBlockComment) {
        if (line.contains("*/")) {
          line = line.substring(line.indexOf("*/") + 2);
          inBlockComment = false;
        } else {
          continue;
        }
      }
      
      // Check for line comments and remove them
      if (line.contains("//")) {
        line = line.substring(0, line.indexOf("//"));
      }

      // Check for the start of a block comment
      if (line.contains("/*")) {
        inBlockComment = true;
        line = line.substring(0, line.indexOf("/*"));
      }
      
      String[] words = line.split("\\s+");
      for (String word : words) {
        if (keywordSet.contains(word)) count++;
      }
    }

    return count;
  }
}
