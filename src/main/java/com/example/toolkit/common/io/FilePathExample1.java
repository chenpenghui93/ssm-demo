package com.example.toolkit.common.io;

import java.io.File;
import java.io.IOException;

/**
 * @author cph
 * @date 2019/12/22
 */
public class FilePathExample1 {
    public static void main(String[] args) throws IOException {
        String filename = "newFile1.txt";
        String workingDirectory = System.getProperty("user.dir");

        String absoluteFilePath = "";
//        absoluteFilePath = workingDirectory + System.getProperty("file.separator") + filename;
        absoluteFilePath = workingDirectory + File.separator + filename;
        System.out.println("final path: " + absoluteFilePath);

        File file = new File(absoluteFilePath);
        if (file.createNewFile()) {
            System.out.println("File is created.");
        } else {
            System.out.println("File is already existed.");
        }

    }
}
