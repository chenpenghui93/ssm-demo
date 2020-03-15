package com.example.toolkit.demo.io;

import java.io.File;
import java.io.IOException;

/**
 * @author cph
 * @date 2019/12/22
 */
public class FilePathExample2 {
    public static void main(String[] args) throws IOException {
        String filename = "newFile2.txt";
        String workingDirectory = System.getProperty("user.dir");

        File file = new File(workingDirectory, filename);

        System.out.println("final path: " + file.getAbsolutePath());

        if (file.createNewFile()) {
            System.out.println("file is created.");
        } else {
            System.out.println("file is already exists.");
        }
    }
}
