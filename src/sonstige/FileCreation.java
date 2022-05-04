package sonstige;

import java.io.File;
import java.io.IOException;

public class FileCreation {
    public static void main(String[] args) throws IOException {
      //just name+extension no path: it will be saved outside the src inside the project
//      File file = new File("FirstFile.txt");
//      file.createNewFile();
//        System.out.println("File created");
//
//        File file2 = new File("FirstFileOutOfSrc.txt");
//        file2.createNewFile();
//        System.out.println("File created");
//
//        File file3 = new File("src/FirstFileOutOfSrc.txt");
//        file3.createNewFile();
//        System.out.println("File created");
      //create a file under the documents folder in your local computer and name it as your own name
        File file4 = new File("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\src\\Asim.txt");
        file4.createNewFile();
        System.out.println("File created");

    }
}
