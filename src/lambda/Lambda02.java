package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) throws IOException {
        //read the text from LambdaFile01.txt

        //after lines method you have a stream and you can use all lambda methods
        Files.lines(Paths.get("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\src\\LambdaFile01.txt")).forEach(System.out::println);
        System.out.println("==================================================");
        Files.lines
                (Paths.get("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\src\\LambdaFile01.txt"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("============================================");
        //read just the first row from lambdaFile01 in lower cases
        Files.lines(Paths.get("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\src\\LambdaFile01.txt"))
                .limit(1)
                .map(String::toLowerCase)
                .forEach(System.out::println);
        System.out.println("============================================");
        //read just the third row from lambdaFile01 in upper cases
        Files.lines(Paths.get("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\src\\LambdaFile01.txt"))
                .skip(2).limit(1).map(String::toUpperCase).forEach(System.out::println);
        System.out.println("============================================");
        //find the number of lines in which the word lambda is used
        System.out.println(Files.lines(Paths.get("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\src\\LambdaFile01.txt"))
        .filter(t->t.toLowerCase().contains("lambda")).count());
        System.out.println("============================================");
        //print all different words from the file in a list
        System.out.println(Files.lines(Paths.get("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\src\\LambdaFile01.txt"))
                .map(t->t.toLowerCase()
                .split(" "))
                .flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList()));
        System.out.println("**************************************************************");
        // count the different words used in the file

        System.out.println( Files.lines(Paths.get("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\src\\LambdaFile01.txt"))
         .map(t->t.toLowerCase()
         .split(" "))
         .flatMap(Arrays::stream)
         .distinct()
         .count());
    //find the number of the word lambda used in file (ignore cases)
        System.out.println( Files.lines(Paths.get("C:\\Users\\Asim\\IdeaProjects\\advanced_java\\src\\LambdaFile01.txt"))
                .map(t->t.toLowerCase()
                .split(" "))
                .flatMap(Arrays::stream)
                .filter(t->t.equalsIgnoreCase("and"))
                .count());






    }
}