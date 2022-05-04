package sonstige;

import java.io.File;

public class FolderCreation {
    public static void main(String[] args) {
//        File folder = new File("FirstFolderOutOfSrc");
//        folder.mkdir();

        File folder1 = new File("src/FirstFolderUnderSrc");
        folder1.mkdir(); //under src folders are seen as package
    }
}
