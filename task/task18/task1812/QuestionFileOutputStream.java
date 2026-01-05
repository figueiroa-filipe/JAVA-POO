package com.codegym.task.task18.task1812;

import java.io.*;

/* 
Extending AmigoOutputStream

*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream amigo;

    public QuestionFileOutputStream(AmigoOutputStream amigo) {
        this.amigo = amigo;
    }

    @Override
    public void flush() throws IOException {
        amigo.flush();
    }

    @Override
    public void write(int b) throws IOException {
        amigo.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        amigo.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        amigo.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do you really want to close the stream? Y/N");
        if (reader.readLine().equals("Y")) amigo.close();
    }
}

