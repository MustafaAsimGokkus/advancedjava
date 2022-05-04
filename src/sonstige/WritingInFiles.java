package sonstige;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingInFiles {
    public static void main(String[] args) throws IOException {
        //Create a folder under src
//        File folder =new File("FolderToWrite");
//        folder.mkdir();

        File file = new File("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\FolderToWrite\\FileToWrite.txt");
//        file.createNewFile();


//        try{
//            FileWriter fw = new FileWriter(file);
//            BufferedWriter bw = new BufferedWriter(fw,true);
//            bw.write("Writes text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters,arrays and strings");
//            bw.newLine();
//            bw.write("The buffer size may be specified, or the default size may be accepted");
//            bw.newLine();
//            bw.write("The default size is large enough for most purposes");
//            bw.close();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
        try( BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
            bw.write("Writes text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters,arrays and strings");
            bw.newLine();
            bw.write("The buffer size may be specified, or the default size may be accepted");
            bw.newLine();
            bw.write("The default size is large enough for most purposes");
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
