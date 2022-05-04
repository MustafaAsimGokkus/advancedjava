package sonstige;

import java.io.*;
import java.util.Scanner;

public class ReadingFile {
    /*

    1)Scanner cannot be used in multithreading
      BufferedReader is multi threaded
    2)Scanner cannot be used in synchronization
      BufferedReader is synhronized
    3) Scanner is used with small data till 1kb
       BufferedReader can be used larger data till 8kb
    4) Scanner is slower than BufferedReader

     */





    public static void main(String[] args) {
        //1. way to read file
//        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\FolderToWrite\\FileToWrite.txt"))) {
//        String line;
//
//        while((line = br.readLine()) !=null){
//            System.out.println(line);
//        }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //2nd way to read
//        try(Scanner scan = new Scanner(new File("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\FolderToWrite\\FileToWrite.txt"))) {
//        String line;
//        while(scan.hasNext()) {
//
//            line =scan.nextLine();
//            System.out.println(line);
//        }
//        }catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
        //3rd way to read a file

        try (FileInputStream fis = new FileInputStream("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\FolderToWrite\\FileToWrite.txt")) {

          int k;
         //read method gets the ascii value of char and puts it to int k
          while((k = fis.read()) != -1){
              System.out.print((char)k); //explicit narrowing
          }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }}








