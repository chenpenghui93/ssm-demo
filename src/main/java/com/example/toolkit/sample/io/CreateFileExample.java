package com.example.toolkit.sample.io;

import java.io.File;

/**
 * @author cph
 */
public class CreateFileExample {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\newFile.txt");
            if (file.createNewFile()) {
                System.out.println("file created.");
            } else {
                System.out.println("file already exists.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
