package com.codegym.task.task18.task1814;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;

/* 
UnsupportedFileName

*/

public class TxtInputStream extends FileInputStream {
    String fileName;
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (!checkFile(fileName)) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public boolean checkFile(String fileName) {
        Pattern pattern = Pattern.compile(".*\\.txt$", Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(fileName).matches()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}

