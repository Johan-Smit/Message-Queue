package com.turtleMQ.broker.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class FileRWService {

    public File read(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists())
            throw new FileNotFoundException();
        return file;
    }

    public void write(String text, String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(text);
        writer.close();
    }
}
