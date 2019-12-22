package com.example.toolkit.hello.io;

import java.io.File;
import java.io.IOException;

/**
 * @author cph
 * @date 2019/12/22
 */
public class FilePermissionExample {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\shellscript.sh");

            if (file.exists()) {
                System.out.println("Exectue? " + file.canExecute());
                System.out.println("Write? " + file.canWrite());
                System.out.println("Read? " + file.canRead());
            }

            file.setExecutable(false);
            file.setWritable(false);
            file.setReadable(false);

            System.out.println("Exectue? " + file.canExecute());
            System.out.println("Write? " + file.canWrite());
            System.out.println("Read? " + file.canRead());

            if (file.createNewFile()) {
                System.out.println("file is created.");
            } else {
                System.out.println("file is already existed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
