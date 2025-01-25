package com.lb.a08;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// 抽象类的子类：FileLogger
public class FileLogger extends Logger {
    private Writer fileWriter;

    public FileLogger(String name, boolean enabled, Level minPermittedLevel, String filepath) {
        super(name, enabled, minPermittedLevel);
        try {
            this.fileWriter = new FileWriter(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doLog(Level level, String message) {
        try {
            fileWriter.write("[" + level + "] " + message + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
